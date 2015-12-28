package com.youxigu.dynasty.combat.domain.combat;

import java.io.Serializable;
import java.util.Date;

/**
* @Description: 战斗本身的类，定义一场战斗
* @author myg
* @time 2015年12月25日 下午1:05:27
*/
public class Combat implements Serializable {

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
	
//	/**
//	 * 进攻方军团
//	 */
//	private CombatTeam attackerTeam;
//	
//	/**
//	 * 防守方军团
//	 */
//	private CombatTeam defenderTeam;
//	
//	/**
//	 * 前台需要做的每个动作的预处理
//	 */
//	private List<AbstractCombatBehavior> preBehaviors = new ArrayList<AbstractCombatBehavior>();
	
//	public List<AbstractCombatBehavior> getPreBehaviors() {
//		return preBehaviors;
//	}
//
//	public void setPreBehaviors(List<AbstractCombatBehavior> preBehaviors) {
//		this.preBehaviors = preBehaviors;
//	}

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

//	public CombatTeam getAttackerTeam() {
//		return attackerTeam;
//	}
//
//	public void setAttackerTeam(CombatTeam attackerTeam) {
//		this.attackerTeam = attackerTeam;
//	}
//
//	public CombatTeam getDefenderTeam() {
//		return defenderTeam;
//	}
//
//	public void setDefenderTeam(CombatTeam defenderTeam) {
//		this.defenderTeam = defenderTeam;
//	}
	
	
}
