package com.youxigu.dynasty.combat.domain.behavior;

import java.util.ArrayList;
import java.util.List;

/**
* @Description: 团队初始化时加buff的类
* @author myg
* @time 2015年12月28日 上午11:42:45
*/
public class InitTeamBuffBehavior extends AbstractCombatBehavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8817679030336067285L;

	
	/**
	 * 团队buff列表
	 */
	protected List<AbstractCombatBehavior> teamBuffLists = new ArrayList<AbstractCombatBehavior>();


	public List<AbstractCombatBehavior> getTeamBuffLists() {
		return teamBuffLists;
	}


	public void setTeamBuffLists(List<AbstractCombatBehavior> teamBuffLists) {
		this.teamBuffLists = teamBuffLists;
	}
}
