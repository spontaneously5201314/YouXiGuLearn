package com.youxigu.dynasty.combat.domain.skill;

import com.youxigu.dynasty.combat.domain.combat.CombatUnit;
import com.youxigu.dynasty.entity.domain.HeroSkillLimit;

/**
* @Description: 技能释放的约束
* @author myg
* @time 2015年12月31日 下午4:47:37
*/
public interface ISkillFiredLimitValidator {

	public boolean checked(CombatSkill skill ,HeroSkillLimit limit, CombatUnit source,CombatUnit target);
}
