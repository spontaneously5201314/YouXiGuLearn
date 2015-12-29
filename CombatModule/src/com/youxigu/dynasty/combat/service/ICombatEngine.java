package com.youxigu.dynasty.combat.service;

import java.io.Serializable;

import com.youxigu.dynasty.combat.domain.combat.Combat;
import com.youxigu.dynasty.combat.domain.combat.CombatFactor;
import com.youxigu.dynasty.combat.domain.combat.CombatHarmFactor;

/**
 * @Description: 战斗引擎接口
 * @author myg
 * @time 2015年12月25日 下午4:12:10
 */
public interface ICombatEngine extends Serializable {

	/**
	 * 进攻团队和防守团队的一场战斗
	 * @param combat
	 */
	void execCombat(Combat combat);
	
	/**
	 * 取攻守双方的攻击优先级
	 * @param atkArmyType
	 * @param defArmyType
	 * @return
	 */
	int getArmyAttackPriority(String atkArmyType, String defArmyType);
	
	/**
	 * 去攻守双方的攻击加成
	 * @param atkArmyType
	 * @param defArmyType
	 * @return
	 */
	double getArmyAttackFactor(String atkArmyType, String defArmyType);
	
	/**
	 * 取战斗公式
	 * @param formula
	 * @return
	 */
	CombatFactor getCombatFactor(String formula);
	
	/**
	 * 取战斗中每种兵种的伤害计算公式
	 * @param armyType
	 * @return
	 */
	CombatHarmFactor getCombatHarmFactor(String armyType);
}
