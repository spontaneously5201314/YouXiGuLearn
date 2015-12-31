package com.youxigu.dynasty.combat.domain.skill;

import java.io.Serializable;

import com.youxigu.dynasty.entity.domain.HeroSkill;

/**
* @Description: 战斗中的技能
* @author myg
* @time 2015年12月28日 下午5:36:42
*/
public class CombatSkill implements Serializable {
	private static final long serialVersionUID = -8475702945446681669L;
	/**
	 * 技能定义
	 */
	private HeroSkill skill;

	/**
	 * 特殊技能2,3
	 */
	private HeroSkill specSkill;

	/**
	 * 最后一次施放的回合
	 */
	private int firedRound = -1;
	/**
	 * 技能下一次可施放技能的回合数
	 */
	private int nextFiredRound = 0;

	/**
	 * 已经释放的总次数
	 */
	private int firedCount;
	

	public CombatSkill() {

	}

	public CombatSkill(HeroSkill skill) {
		this.skill = skill;
	}
	
	public CombatSkill(HeroSkill skill, HeroSkill specSkill) {
		this.skill = skill;
		this.specSkill = specSkill;
	}

	public HeroSkill getSkill() {
		return skill;
	}

	public void setSkill(HeroSkill skill) {
		this.skill = skill;
	}

	public HeroSkill getSpecSkill() {
		return specSkill;
	}

	public void setSpecSkill(HeroSkill specSkill) {
		this.specSkill = specSkill;
	}

	public int getFiredRound() {
		return firedRound;
	}

	public void setFiredRound(int firedRound) {
		this.firedRound = firedRound;
	}

	public int getNextFiredRound() {
		return nextFiredRound;
	}

	public void setNextFiredRound(int nextFiredRound) {
		this.nextFiredRound = nextFiredRound;
	}

	public int getFiredCount() {
		return firedCount;
	}

	public void setFiredCount(int firedCount) {
		this.firedCount = firedCount;
	}

	public Object getTarget() {
		return null;
	}
}
