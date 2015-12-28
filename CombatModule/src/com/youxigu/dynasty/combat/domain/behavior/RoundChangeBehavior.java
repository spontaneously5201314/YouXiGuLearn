package com.youxigu.dynasty.combat.domain.behavior;

/**
 * @Description: 回合改变的动作类
 * @author myg
 * @time 2015年12月28日 上午11:47:22
 */
public class RoundChangeBehavior extends AbstractCombatBehavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4683108644709087727L;

	protected int roundId;

	public int getRoundId() {
		return roundId;
	}

	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}
}
