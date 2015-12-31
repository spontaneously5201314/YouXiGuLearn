package com.youxigu.dynasty.combat.domain.combat;

import java.io.Serializable;

/**
* @Description: 城墙，也就是之前的不可攻击的战斗单元
* @author myg
* @time 2015年12月31日 上午10:35:23
*/
public class WallCombatUnit extends CombatUnit implements Serializable {
	private static final long serialVersionUID = -8265016837432028167L;

	@Override
	public long _getMobility() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _getMoveRange() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double _getFrequency() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _getAttackRange() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String _getUnitArmyType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int _getUnitArmyTypeInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _getUnitBaseArmyTypeInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String _getArmyName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int _getFormationPos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _getAtkMode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _getHp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _getAttack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _getDefense() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _getStrength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _getAgility() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _getAddDodge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _getAddHit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _getDamageAdd() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _getDamageDec() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int _getAddCrit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double _getArmyAttackRelationAdd(int armyType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double _getArmyAttackRelationDec(int armyType) {
		// TODO Auto-generated method stub
		return 0;
	}

}
