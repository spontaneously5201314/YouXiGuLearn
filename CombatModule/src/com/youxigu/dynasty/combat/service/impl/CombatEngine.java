package com.youxigu.dynasty.combat.service.impl;

import java.util.HashMap;

import com.youxigu.dynasty.combat.domain.combat.CombatDB;
import com.youxigu.dynasty.combat.domain.combat.CombatTeam;
import com.youxigu.dynasty.combat.service.ICombatEngine;

/**
* @Description: 
* @author myg
* @time 2015年12月25日 下午4:21:15
*/
public class CombatEngine implements ICombatEngine {
	public CombatEngine() {
		super();
	}

	@Override
	public HashMap<String, String> execCombat(CombatDB combat) {
//		CombatTeam attackerTeam = combat.getAttackerTeam();
//		CombatTeam defenderTeam = combat.getDefenderTeam();
//		
		return null;
	}

}
