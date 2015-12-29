package com.youxigu.dynasty.combat.domain.combat;

import java.io.Serializable;

/**
 * @Description: 战斗公式
 * @author myg
 * @time 2015年12月29日 下午2:34:35
 */
public class CombatFactor implements Serializable {
	private static final long serialVersionUID = -2354466525156084776L;

	private String formula;
	private double para1;
	private double para2;
	private double para3;
	private double para4;

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public double getPara1() {
		return para1;
	}

	public void setPara1(double para1) {
		this.para1 = para1;
	}

	public double getPara2() {
		return para2;
	}

	public void setPara2(double para2) {
		this.para2 = para2;
	}

	public double getPara3() {
		return para3;
	}

	public void setPara3(double para3) {
		this.para3 = para3;
	}

	public double getPara4() {
		return para4;
	}

	public void setPara4(double para4) {
		this.para4 = para4;
	}

}
