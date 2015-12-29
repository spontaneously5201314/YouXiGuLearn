package com.youxigu.dynasty.combat.service.impl;

import java.sql.SQLException;

import com.youxigu.dynasty.combat.dao.impl.CombatDao;
import com.youxigu.dynasty.combat.domain.combat.CombatDB;
import com.youxigu.dynasty.combat.service.ICombatService;

/**
* @Description: 战斗service的实现类，其中会调用战斗引擎
* @author myg
* @time 2015年12月25日 下午4:44:18
*/
public class CombatService implements ICombatService {
	
	private CombatEngine combatEngine;
	
	private CombatDao combatDao;
	
	public void setCombatEngine(CombatEngine combatEngine) {
		this.combatEngine = combatEngine;
	}

	public void setCombatDao(CombatDao combatDao) {
		this.combatDao = combatDao;
	}

	@Override
	public void execCombat(CombatDB combat) {
		combatEngine.execCombat(combat);
	}

	public CombatDB getCombatById(String combatId) {
		try {
			return combatDao.getCombatById(combatId);
		} catch (SQLException e) {
			return null;
		}
	}

}
