package com.youxigu.dynasty.combat.domain.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 加buff的动作类
 * @author myg
 * @time 2015年12月28日 上午11:35:19
 */
public class AddBuffBehavior extends CombatUnitBehavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6617906924492703935L;
	
	/**
	 * buff列表
	 */
	protected List<CombatUnitBehavior> buffLists = new ArrayList<CombatUnitBehavior>();

	public List<CombatUnitBehavior> getBuffLists() {
		return buffLists;
	}

	public void setBuffLists(List<CombatUnitBehavior> buffLists) {
		this.buffLists = buffLists;
	}
}
