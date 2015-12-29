package com.youxigu.dynasty.combat.domain.attackrelation;

import java.io.Serializable;

/**
* @Description: 武将攻击关系
* @author myg
* @time 2015年12月29日 上午11:33:09
*/
public class ArmyAttackRelation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2245423942825908239L;
	/**
	 * 攻击兵种
	 */
	protected String atkArmyType;
	/**
	 * 防守兵种
	 */
	protected String dfcArmyType;
	/**
	 * 优先级
	 */
	protected int priority;
	/**
	 * 系数
	 */
	protected double factor;

	public String getAtkArmyType() {
		return atkArmyType;
	}

	public void setAtkArmyType(String atkArmyType) {
		this.atkArmyType = atkArmyType;
	}

	public String getDfcArmyType() {
		return dfcArmyType;
	}

	public void setDfcArmyType(String dfcArmyType) {
		this.dfcArmyType = dfcArmyType;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}
	
}
