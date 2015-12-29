package com.youxigu.dynasty.combat.dao;

import java.sql.SQLException;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.youxigu.dynasty.combat.domain.combat.CombatDB;

/**
* @Description: 
* @author myg
* @time 2015年12月25日 下午5:08:25
*/
public interface ICombatDao{

	public CombatDB findCombatByUserId(int userId);
	
	public CombatDB getCombatById(String combatId) throws SQLException;

}