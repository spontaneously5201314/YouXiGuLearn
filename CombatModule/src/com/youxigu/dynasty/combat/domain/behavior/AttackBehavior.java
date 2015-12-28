package com.youxigu.dynasty.combat.domain.behavior;

import java.util.LinkedList;
import java.util.List;

/**
* @Description: 战斗单元的普通攻击动作类
* @author myg
* @time 2015年12月28日 上午11:03:58
*/
public class AttackBehavior extends CombatUnitBehavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4195050684599914942L;
	/**
	 * 攻击对象的id
	 */
	protected int targetId;
	/**
	 * 攻击的结果集
	 */
	List<AbstractCombatBehavior> attackResults = new LinkedList<AbstractCombatBehavior>();
	public int getTargetId() {
		return targetId;
	}
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}
	public List<AbstractCombatBehavior> getAttackResults() {
		return attackResults;
	}
	public void setAttackResults(List<AbstractCombatBehavior> attackResults) {
		this.attackResults = attackResults;
	}
}
