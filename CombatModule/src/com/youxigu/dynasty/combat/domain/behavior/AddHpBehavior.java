package com.youxigu.dynasty.combat.domain.behavior;

/**
 * @Description: 战斗单元加血的行为
 * @author myg
 * @time 2015年12月28日 上午11:32:56
 */
public class AddHpBehavior extends CombatUnitBehavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7395293995070825795L;
	protected int hp;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

}
