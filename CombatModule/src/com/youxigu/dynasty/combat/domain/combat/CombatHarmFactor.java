package com.youxigu.dynasty.combat.domain.combat;

import java.io.Serializable;

/**
 * @Description: 战斗中每个战斗单元的伤害计算公式
 * @author myg
 * @time 2015年12月29日 下午2:38:04
 */
public class CombatHarmFactor implements Serializable {
	private static final long serialVersionUID = 3295667174266276584L;
	private String armyType;
	private int sol;// 带兵
	private int hp; // 生命值
	// 兵种物理属性
	private int phyAtk; // 物理攻击
	private int phyDef; // 物理防御
	private int phyCrit; // 物理暴击
	private int phyDodge; // 物理闪避
	private int phyHit; // 物理命中
	private int phyAgl; // 物理韧性
	// 兵种法术属性
	private int magicAtk; // 法术 攻击
	private int magicDef; // 法术防守
	private int magicCrit; // 法术暴击
	private int magicDodge; // 法术闪避
	private int magicHit; // 法术命中
	private int magicAgl; // 法术韧性
	private int critHarm; // 暴击伤害
	private int critReduce; // 削弱暴击伤害

	public String getArmyType() {
		return armyType;
	}

	public void setArmyType(String armyType) {
		this.armyType = armyType;
	}

	public int getSol() {
		return sol;
	}

	public void setSol(int sol) {
		this.sol = sol;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPhyAtk() {
		return phyAtk;
	}

	public void setPhyAtk(int phyAtk) {
		this.phyAtk = phyAtk;
	}

	public int getPhyDef() {
		return phyDef;
	}

	public void setPhyDef(int phyDef) {
		this.phyDef = phyDef;
	}

	public int getPhyCrit() {
		return phyCrit;
	}

	public void setPhyCrit(int phyCrit) {
		this.phyCrit = phyCrit;
	}

	public int getPhyDodge() {
		return phyDodge;
	}

	public void setPhyDodge(int phyDodge) {
		this.phyDodge = phyDodge;
	}

	public int getPhyHit() {
		return phyHit;
	}

	public void setPhyHit(int phyHit) {
		this.phyHit = phyHit;
	}

	public int getPhyAgl() {
		return phyAgl;
	}

	public void setPhyAgl(int phyAgl) {
		this.phyAgl = phyAgl;
	}

	public int getMagicAtk() {
		return magicAtk;
	}

	public void setMagicAtk(int magicAtk) {
		this.magicAtk = magicAtk;
	}

	public int getMagicDef() {
		return magicDef;
	}

	public void setMagicDef(int magicDef) {
		this.magicDef = magicDef;
	}

	public int getMagicCrit() {
		return magicCrit;
	}

	public void setMagicCrit(int magicCrit) {
		this.magicCrit = magicCrit;
	}

	public int getMagicDodge() {
		return magicDodge;
	}

	public void setMagicDodge(int magicDodge) {
		this.magicDodge = magicDodge;
	}

	public int getMagicHit() {
		return magicHit;
	}

	public void setMagicHit(int magicHit) {
		this.magicHit = magicHit;
	}

	public int getMagicAgl() {
		return magicAgl;
	}

	public void setMagicAgl(int magicAgl) {
		this.magicAgl = magicAgl;
	}

	public int getCritHarm() {
		return critHarm;
	}

	public void setCritHarm(int critHarm) {
		this.critHarm = critHarm;
	}

	public int getCritReduce() {
		return critReduce;
	}

	public void setCritReduce(int critReduce) {
		this.critReduce = critReduce;
	}
}
