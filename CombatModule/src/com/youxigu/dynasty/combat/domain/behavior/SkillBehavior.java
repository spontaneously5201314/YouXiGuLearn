package com.youxigu.dynasty.combat.domain.behavior;

/**
 * @Description:每一个技能的动作类
 * @author myg
 * @time 2015年12月28日 上午11:38:19
 */
public class SkillBehavior extends AttackBehavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7757814170946132764L;

	/**
	 * 技能的id
	 */
	protected int skillId;

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
}
