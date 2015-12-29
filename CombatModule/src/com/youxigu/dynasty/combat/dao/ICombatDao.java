package com.youxigu.dynasty.combat.dao;

import java.sql.SQLException;
import java.util.List;

import com.youxigu.dynasty.combat.domain.attackrelation.ArmyAttackRelation;
import com.youxigu.dynasty.combat.domain.combat.CombatDB;
import com.youxigu.dynasty.combat.domain.combat.CombatFactor;
import com.youxigu.dynasty.combat.domain.combat.CombatHarmFactor;

/**
* @Description: 
* @author myg
* @time 2015年12月25日 下午5:08:25
*/
public interface ICombatDao{

	public CombatDB findCombatByUserId(int userId);
	
	public CombatDB getCombatById(String combatId) throws SQLException;
	
	public List<ArmyAttackRelation> getArmyAttackRelation();

	public List<CombatFactor> getCombatFactor();

	public List<CombatHarmFactor> getCombatHarmFactor();


}