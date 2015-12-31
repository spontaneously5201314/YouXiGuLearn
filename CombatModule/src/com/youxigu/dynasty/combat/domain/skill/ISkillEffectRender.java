package com.youxigu.dynasty.combat.domain.skill;

import java.util.List;

import com.youxigu.dynasty.combat.domain.behavior.AttackBehavior;
import com.youxigu.dynasty.combat.domain.behavior.FireAttackBehavior;
import com.youxigu.dynasty.combat.domain.combat.Combat;
import com.youxigu.dynasty.combat.domain.combat.CombatUnit;

/**
* @Description:技能的效果渲染类 
* @author myg
* @time 2015年12月31日 下午2:56:51
*/
public interface ISkillEffectRender {

	/**
	 * 战斗中技能的渲染
	 * @param combat 战斗
	 * @param combatSkill 技能
	 * @param effect 技能的效果
	 * @param targets 技能的目标
	 * @param behavior 战斗中技能的行为
	 */
	public void doRender(Combat combat, CombatSkill combatSkill, CombatSkillEffect effect,List<CombatUnit> targets, FireAttackBehavior behavior);
	
	/**
	 * 应用效果，dot类的使用
	 * @param effect
	 */
	public AttackBehavior applyEffect(CombatSkillEffect effect,CombatUnit target);
}
