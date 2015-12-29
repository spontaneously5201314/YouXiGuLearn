package com.youxigu.dynasty.combat.domain.combat;

import java.io.Serializable;
import java.util.Date;

/**
* @Description: 战斗本身的类，定义一场战斗
* @author myg
* @time 2015年12月25日 下午1:05:27
*/
public class CombatDB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7762429805260791278L;

	/**
	 * 战斗id
	 */
	private String combatId;
	
	/**
	 * 战斗数据
	 */
	private Object combatData;
	
	/**
	 * 战斗时间
	 */
	private Date combatDt;

	public String getCombatId() {
		return combatId;
	}

	public void setCombatId(String combatId) {
		this.combatId = combatId;
	}

	public Object getCombatData() {
		return combatData;
	}

	public void setCombatData(Object combatData) {
		this.combatData = combatData;
	}

	public Date getCombatDt() {
		return combatDt;
	}

	public void setCombatDt(Date combatDt) {
		this.combatDt = combatDt;
	}

	@Override
	public String toString() {
		return "Combat [combatId=" + combatId + ", combatData=" + combatData + ", combatDt=" + combatDt + "]";
	}
	
}
