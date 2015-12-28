package com.youxigu.dynasty.combat.domain.behavior;

/**
 * @Description: 战斗单元移动的动作类
 * @author myg
 * @time 2015年12月28日 上午11:39:44
 */
public class MoveBehavior extends CombatUnitBehavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2075775846510310289L;

	/**
	 * 位置坐标
	 */
	protected int[][] pos;

	public int[][] getPos() {
		return pos;
	}

	public void setPos(int[][] pos) {
		this.pos = pos;
	}

}
