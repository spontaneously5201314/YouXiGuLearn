package com.youxigu.dynasty.combat.domain.skill;

import java.util.Map;

import com.youxigu.dynasty.entity.domain.HeroSkillEffect;

/**
* @Description: 
* @author myg
* @time 2015年12月31日 下午4:42:09
*/
public class SkillEffectFactory {

	/**
	 * key = skilleffect id 或者skilleffect type
	 */
	private static Map<String, ISkillEffectRender> renders;

	/**
	 * key = skill id ,或者是目标类型 对某个Effect的施放对象的搜索器
	 */
	private static Map<Integer, ITargetSearcher> searchers;

	/**
	 * 技能释放约束 key = 发动条件的key值
	 */
	private static Map<String, ISkillFiredLimitValidator> limits;

	public void setSearchers(Map<Integer, ITargetSearcher> searchers) {
		SkillEffectFactory.searchers = searchers;
	}

	public void setRenders(Map<String, ISkillEffectRender> renders) {
		SkillEffectFactory.renders = renders;
	}

	public void setLimits(Map<String, ISkillFiredLimitValidator> limits) {
		SkillEffectFactory.limits = limits;
	}

	public static ITargetSearcher getTargetSearcher(CombatSkill skill) {

		return searchers.get(skill.getTarget());

	}

	public static ISkillEffectRender getSkillEffectRender(HeroSkillEffect effect) {

		ISkillEffectRender render = renders.get(effect.getEffKey());
		if (render == null) {
			render = renders.get(effect.getEffTypeStr());
		}
		return render;

	}

	public static ISkillFiredLimitValidator getSkillFiredLimitValidator(
			String limitType) {
		return limits.get(limitType);
	}
	
}
