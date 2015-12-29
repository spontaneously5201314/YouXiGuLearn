package com.youxigu.dynasty.combat.domain.combat;

import java.io.Serializable;
import java.util.List;

import com.youxigu.dynasty.combat.domain.behavior.AbstractCombatBehavior;

/**
 * @Description: 战斗本身
 * @author myg
 * @time 2015年12月28日 下午6:00:37
 */
public class Combat implements Serializable {
	private static final long serialVersionUID = 5625380603421795454L;
	private transient Object params;
	private String combatId;
	private short combatType;
	private int terrian;
	private CombatTeam attackerTeam;
	private CombatTeam defenderTeam;
	private List<AbstractCombatBehavior> preBehaviors;
	private List<AbstractCombatBehavior> behaviors;
	private int round;
	private byte winType;
	private CombatRob combatRob;
	private transient CombatMap combatMap;
	private transient List<CombatUnit> callingUnits;

	public Object getParams() {
		return params;
	}

	public void setParams(Object params) {
		this.params = params;
	}

	public String getCombatId() {
		return combatId;
	}

	public void setCombatId(String combatId) {
		this.combatId = combatId;
	}

	public short getCombatType() {
		return combatType;
	}

	public void setCombatType(short combatType) {
		this.combatType = combatType;
	}

	public int getTerrian() {
		return terrian;
	}

	public void setTerrian(int terrian) {
		this.terrian = terrian;
	}

	public CombatTeam getAttackerTeam() {
		return attackerTeam;
	}

	public void setAttackerTeam(CombatTeam attackerTeam) {
		this.attackerTeam = attackerTeam;
	}

	public CombatTeam getDefenderTeam() {
		return defenderTeam;
	}

	public void setDefenderTeam(CombatTeam defenderTeam) {
		this.defenderTeam = defenderTeam;
	}

	public List<AbstractCombatBehavior> getPreBehaviors() {
		return preBehaviors;
	}

	public void setPreBehaviors(List<AbstractCombatBehavior> preBehaviors) {
		this.preBehaviors = preBehaviors;
	}

	public List<AbstractCombatBehavior> getBehaviors() {
		return behaviors;
	}

	public void setBehaviors(List<AbstractCombatBehavior> behaviors) {
		this.behaviors = behaviors;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public byte getWinType() {
		return winType;
	}

	public void setWinType(byte winType) {
		this.winType = winType;
	}

	public CombatRob getCombatRob() {
		return combatRob;
	}

	public void setCombatRob(CombatRob combatRob) {
		this.combatRob = combatRob;
	}

	public CombatMap getCombatMap() {
		return combatMap;
	}

	public void setCombatMap(CombatMap combatMap) {
		this.combatMap = combatMap;
	}

	public List<CombatUnit> getCallingUnits() {
		return callingUnits;
	}

	public void setCallingUnits(List<CombatUnit> callingUnits) {
		this.callingUnits = callingUnits;
	}

	public boolean isEnd() {
		if(attackerTeam.getUnits().size() == 0 || defenderTeam.getUnits().size() == 0)
			return true;
		return false;
	}

	public void afterCombat() {
		// TODO 这里要根据战斗结果计算战斗的成绩，分为攻守双方各五个档
		
	}

}
