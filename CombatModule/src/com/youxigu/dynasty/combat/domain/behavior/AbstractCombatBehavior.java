package com.youxigu.dynasty.combat.domain.behavior;

import java.io.Serializable;

/**
* @Description: 战斗行为的抽象类，定义共有的行为
* @author myg
* @time 2015年12月25日 上午11:04:28
*/
public abstract class AbstractCombatBehavior implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8352530989635666462L;
	protected short behaviorId;

	public short getBehaviorId() {
		return behaviorId;
	}

	public void setBehaviorId(short behaviorId) {
		this.behaviorId = behaviorId;
	}

}
