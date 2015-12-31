package com.youxigu.dynasty.combat.domain.behavior;


/**
* @Description: 普通攻击的类
* @author myg
* @time 2015年12月31日 下午2:53:38
*/
public class FireAttackBehavior extends AttackBehavior{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6639776983899034723L;

	private int skillId;

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
}
