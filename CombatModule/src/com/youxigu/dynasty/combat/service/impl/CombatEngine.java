package com.youxigu.dynasty.combat.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.youxigu.dynasty.combat.dao.ICombatDao;
import com.youxigu.dynasty.combat.domain.attackrelation.ArmyAttackRelation;
import com.youxigu.dynasty.combat.domain.behavior.AbstractCombatBehavior;
import com.youxigu.dynasty.combat.domain.behavior.RoundChangeBehavior;
import com.youxigu.dynasty.combat.domain.combat.Combat;
import com.youxigu.dynasty.combat.domain.combat.CombatConstants;
import com.youxigu.dynasty.combat.domain.combat.CombatFactor;
import com.youxigu.dynasty.combat.domain.combat.CombatHarmFactor;
import com.youxigu.dynasty.combat.domain.combat.CombatTeam;
import com.youxigu.dynasty.combat.domain.combat.CombatUnit;
import com.youxigu.dynasty.combat.service.ICombatEngine;

import edu.emory.mathcs.backport.java.util.Collections;

/**
* @Description: 战斗服务
* @author myg
* @time 2015年12月25日 下午4:21:15
*/
public class CombatEngine implements ICombatEngine {
	private static final long serialVersionUID = -382322704552685154L;
	
	private ICombatDao combatDao;
	
	public void setCombatDao(ICombatDao combatDao) {
		this.combatDao = combatDao;
	}
	
	/**
	 * 移动排序
	 */
	private static MoveComparator moveComparator = new MoveComparator();
	
	static class MoveComparator<T extends CombatUnit> implements Comparator<CombatUnit>{

		@Override
		public int compare(CombatUnit unit1, CombatUnit unit2) {
			long mobility1 = unit1._getMobility();
			long mobility2 = unit2._getMobility();
			if (mobility1 == mobility2) {
				// 进攻方优先 出手/优先攻击
				int direct1 = unit1.getDirection();
				int direct2 = unit2.getDirection();
				if (direct1 == direct2) {
					// 阵法位置越小的优先
					int pos1 = unit1._getFormationPos();
					int pos2 = unit2._getFormationPos();
					return pos1 > pos2 ? 1 : -1;
				} else {
					return direct2 > direct1 ? 1 : -1;
				}
			} else {
				return mobility1 > mobility2 ? 1 : -1;
			}
		}
	}
	
	/**
	 * 战斗力排序
	 */
	private static AttackComparator atkComparator = new AttackComparator();
	
	static class AttackComparator<T extends CombatUnit> implements Comparator<CombatUnit>{

		@Override
		public int compare(CombatUnit unit1, CombatUnit unit2) {
			long mobility1 = unit1._getMobility();
			long mobility2 = unit2._getMobility();
			if (mobility1 == mobility2) {
				// 进攻方优先 出手/优先攻击
				int direct1 = unit1.getDirection();
				int direct2 = unit2.getDirection();
				if (direct1 == direct2) {
					// 阵法位置越小的优先
					int pos1 = unit1._getFormationPos();
					int pos2 = unit2._getFormationPos();
					return pos1 > pos2 ? 1 : -1;
				} else {
					return direct2 > direct1 ? 1 : -1;
				}
			} else {
				return mobility2 > mobility1 ? 1 : -1;
			}
		}
	}

	/**
	 * 存放兵种之间攻击优先级和系数的map
	 */
	private Map<String,Map<String,ArmyAttackRelation>> armyAttackRelations = new HashMap<String,Map<String,ArmyAttackRelation>>();

	/**
	 * 存放攻击公式系数的map
	 */
	private Map<String,CombatFactor> combatFactors = new HashMap<String,CombatFactor>();
	
	/**
	 * 存放攻击伤害系数的map
	 */
	private Map<String,CombatHarmFactor> combatHarmFactors = new HashMap<String,CombatHarmFactor>();
	
	/**
	 * 初始化类的时候就把上面的三个map装填一遍
	 */
	private void init(){
		List<ArmyAttackRelation> relations = combatDao.getArmyAttackRelation();
		for (ArmyAttackRelation relation : relations) {
			Map<String, ArmyAttackRelation> submap = armyAttackRelations.get(relation.getAtkArmyType());
			if(submap == null){
				submap = new HashMap<String, ArmyAttackRelation>();
				armyAttackRelations.put(relation.getAtkArmyType(), submap);
			}
			submap.put(relation.getDfcArmyType(), relation);
		}
		List<CombatFactor> factors = combatDao.getCombatFactor();
		for (CombatFactor factor : factors) {
			combatFactors.put(factor.getFormula(), factor);
		}
		List<CombatHarmFactor> harmFactors = combatDao.getCombatHarmFactor();
		for (CombatHarmFactor harmFactor : harmFactors) {
			combatHarmFactors.put(harmFactor.getArmyType(), harmFactor);
		}
	}
	
	@Override
	public void execCombat(Combat combat) {
		// 有了兵种间攻击优先级和系数，攻击公式的系数，攻击伤害的系数
		CombatTeam attackerTeam = combat.getAttackerTeam();
		CombatTeam defenderTeam = combat.getDefenderTeam();
		if(attackerTeam == null || defenderTeam == null)
			return;
		if(attackerTeam.getUnits() == null || attackerTeam.getUnits().size() == 0){
			combat.setWinType(CombatConstants.DEF_WIN);
		}else if(defenderTeam.getUnits() == null || defenderTeam.getUnits().size() == 0){
			combat.setWinType(CombatConstants.ATK_WIN);
		}else{
			//新建一个List,将攻守双方的所有战斗单元（武将）全部放进去
			List<CombatUnit> units = new ArrayList<CombatUnit>();
			units.addAll(attackerTeam.getUnits());
			units.addAll(defenderTeam.getUnits());
			//对攻守双方的所有武将进行战力排序
			Collections.sort(units, atkComparator);
			//获得所有的回合开始前的操作
			List<AbstractCombatBehavior> preBehaviors = combat.getPreBehaviors();
			if(preBehaviors == null){
				preBehaviors = new LinkedList<AbstractCombatBehavior>();
				preBehaviors = combat.getPreBehaviors();
			}
			//武将按照排序好的顺序释放技能
			for (CombatUnit unit : units) {
				//TODO 这里写释放技能的方法，释放技能的时候要考虑到选取目标和释放技能的效果，还要考虑时候有诸如眩晕之类持续有效的buff技能
			}
			//判断战斗时候结束，没有结束就一直持续
			while(!combat.isEnd()){
				doBeforeNextRound(combat, units);
				doNextRound(combat, units);
				doafterNextRound(combat, units);
			}
			//战斗结束判断是哪一方赢得战斗
			if(attackerTeam.getUnits().size() == 0)
				combat.setWinType(CombatConstants.DEF_WIN);
			combat.setWinType(CombatConstants.ATK_WIN);
			//计算战斗的成绩
			combat.afterCombat();
		}
	}
	
	/**
	 * 战斗开始前所需要做的
	 * @param combat
	 * @param units
	 */
	private void doBeforeNextRound(Combat combat, List<CombatUnit> units) {
		//增加回合数
		int round = combat.increaseRound();
		RoundChangeBehavior rBehavior = new RoundChangeBehavior(CombatConstants.BEHAVIORS_ROUNDCHANGE, round);
		if(round == 1){
			combat.getPreBehaviors().add(rBehavior);
		}else{
			combat.getLastSubBehaviors().add(rBehavior);
		}
		//按照战力排序攻守双方武将，依次出招
		Iterator<CombatUnit> iterator = units.iterator();
		while(iterator.hasNext()){
			CombatUnit unit = iterator.next();
			if(unit.dead()){
				iterator.remove();
			}else{
				//战斗单元没有死的情况下，增加出手的机会，就计算战力，并释放技能
				unit.increasePower();
				unit.setCurrRoundAttacked(false);
			}
		}
		//获得回合开始前所有的动作
		List<AbstractCombatBehavior> subBehaviors = new LinkedList<AbstractCombatBehavior>();
		//回合开始前,对于每个战斗单元判断是否被对方收买
		iterator = units.iterator();
		while(iterator.hasNext()){
			CombatUnit unit = iterator.next();
			if(unit.dead()){
				iterator.remove();
			}else{
				//释放技能
				//TODO
			}
		}
		combat.addSubBehavior(subBehaviors);
	}

	/**
	 * 每回合内 移动 和 攻击 分为2级阶段 第一阶段为移动阶段: 在移动阶段内，比较兵种机动力，机动力低的优先移动，但移动后不攻击。
	 * 第二阶段为攻击阶段: 在攻击阶段内，比较兵种机动力，机动力高的优先进行攻击。
	 * 而且每回合结束，每个战斗单元的战力可能发生变化，所有在每个回合开始前都要重新进行排序
	 * @param combat
	 * @param units
	 */
	private void doNextRound(Combat combat, List<CombatUnit> units) {
		Collections.sort(units, moveComparator);
		List<AbstractCombatBehavior> lastSubBehaviors = combat.getLastSubBehaviors();
		Iterator<CombatUnit> iterator = units.iterator();
		while(iterator.hasNext()){
			CombatUnit unit = iterator.next();
			if(unit.dead()){
				iterator.remove();
			}else{
				//移动
				AbstractCombatBehavior moveBehavior = unit.doMove();
				lastSubBehaviors.add(moveBehavior);
			}
		}
		Collections.sort(units, atkComparator);
		iterator = units.iterator();
		while(iterator.hasNext()){
			CombatUnit unit = iterator.next();
			if(unit.dead()){
				iterator.remove();
			}else{
				//攻击
				unit.attack();
			}
		}
		if(combat.isEnd()){
			return ;
		}
	}

	/**
	 * 一个回合结束后需要做的事情
	 * @param combat
	 * @param units
	 */
	private void doafterNextRound(Combat combat, List<CombatUnit> units) {
		
	}

	@Override
	public int getArmyAttackPriority(String atkArmyType, String defArmyType) {
		if(atkArmyType != null && defArmyType != null){
			Map<String, ArmyAttackRelation> submap = armyAttackRelations.get(atkArmyType);
			if(submap != null){
				ArmyAttackRelation relation = submap.get(defArmyType);
				if(relation != null){
					return relation.getPriority();
				}
			}
		}
		return 1;
	}

	@Override
	public double getArmyAttackFactor(String atkArmyType, String defArmyType) {
		if(atkArmyType != null && defArmyType != null){
			Map<String, ArmyAttackRelation> submap = armyAttackRelations.get(atkArmyType);
			if(submap != null){
				ArmyAttackRelation relation = submap.get(defArmyType);
				if(relation != null){
					return relation.getFactor();
				}
			}
		}
		return 1.0d;
	}

	@Override
	public CombatFactor getCombatFactor(String formula) {
		return combatFactors.get(formula);
	}

	@Override
	public CombatHarmFactor getCombatHarmFactor(String armyType) {
		return combatHarmFactors.get(armyType);
	}

}
