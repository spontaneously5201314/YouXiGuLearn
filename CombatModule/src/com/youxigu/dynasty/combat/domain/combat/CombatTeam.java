package com.youxigu.dynasty.combat.domain.combat;

import java.io.Serializable;

/**
* @Description: 战斗团队
* @author myg
* @time 2015年12月25日 上午11:01:19
*/
public class CombatTeam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3106651141328795828L;

	/**
	 * 战斗团队id
	 */
	private String id;
	
	/**
	 * 战斗单元
	 */
	private CombatUnit combatUnit;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CombatUnit getCombatUnit() {
		return combatUnit;
	}

	public void setCombatUnit(CombatUnit combatUnit) {
		this.combatUnit = combatUnit;
	}
}
