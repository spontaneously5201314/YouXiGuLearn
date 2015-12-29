package com.youxigu.dynasty.combat.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.youxigu.dynasty.combat.dao.ICombatDao;
import com.youxigu.dynasty.combat.domain.attackrelation.ArmyAttackRelation;
import com.youxigu.dynasty.combat.domain.behavior.AbstractCombatBehavior;
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
	
	private static MoveComparator moveComparator = new MoveComparator<CombatUnit>();
	
	static class MoveComparator<CombatUnit> implements Comparator<CombatUnit>{

		@Override
		public int compare(CombatUnit o1, CombatUnit o2) {
			return 0;//TODO 这里的比较逻辑没有写
		}
		
	}
	
	private static AttackComparator atkComparator = new AttackComparator<CombatUnit>();
	
	static class AttackComparator<CombatUnit> implements Comparator<CombatUnit>{

		@Override
		public int compare(CombatUnit o1, CombatUnit o2) {
			return 0;//TODO 这里的比较逻辑没有写
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
		long time = System.currentTimeMillis();
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

	private void doBeforeNextRound(Combat combat, List<com.youxigu.dynasty.combat.domain.combat.CombatUnit> units) {
		// TODO Auto-generated method stub
		
	}

	private void doNextRound(Combat combat, List<com.youxigu.dynasty.combat.domain.combat.CombatUnit> units) {
		// TODO Auto-generated method stub
		
	}

	private void doafterNextRound(Combat combat, List<com.youxigu.dynasty.combat.domain.combat.CombatUnit> units) {
		// TODO Auto-generated method stub
		
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
