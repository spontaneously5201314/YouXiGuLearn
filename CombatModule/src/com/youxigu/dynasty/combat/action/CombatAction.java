package com.youxigu.dynasty.combat.action;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;

import com.youxigu.dynasty.combat.dao.impl.CombatDao;
import com.youxigu.dynasty.combat.domain.combat.Combat;
import com.youxigu.dynasty.combat.service.impl.CombatService;

/**
 * @Description: 负责处理前台传来的战斗数据，并将结果返回给前台
 * @author myg
 * @time 2015年12月25日 下午4:23:43
 */
public class CombatAction {

	Combat attackerCombat;
	

	private CombatService combatService;

	public void setCombatService(CombatService combatService) {
		this.combatService = combatService;
	}

//	public void setCombatDao(CombatDao combatDao) {
//		this.combatDao = combatDao;
//	}

//	@Before(value = "exec(* com.youxigu.dynasty.combat.action.CombatAction.execCombat(..))")
//	public void init() {
//		attackerCombat = combatDao.findCombatByUserId(99921);
//
//	}

	public void execCombat(Combat combat) {
		System.out.println(combat);
		// combatService.execCombat(combat);
	}
	
	public Combat getCombatById(String combatId){
		return combatService.getCombatById(combatId);
	}

}
