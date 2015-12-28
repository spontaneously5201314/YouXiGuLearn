package com.youxigu.dynasty.combat.domain.behavior;

/**
 * @Description:战斗单元的动作类
 * @author myg
 * @time 2015年12月28日 上午10:57:35
 */
public class CombatUnitBehavior extends AbstractCombatBehavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4276611790188545958L;
	protected int ownerId;

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}


}
