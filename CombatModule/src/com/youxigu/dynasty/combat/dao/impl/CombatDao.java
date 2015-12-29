package com.youxigu.dynasty.combat.dao.impl;

import java.sql.SQLException;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.youxigu.dynasty.combat.dao.ICombatDao;
import com.youxigu.dynasty.combat.domain.combat.CombatDB;

/**
* @Description: 从数据库中查找战斗团队信息的dao
* @author myg
* @time 2015年12月25日 下午4:56:25
*/
public class CombatDao extends SqlMapClientDaoSupport implements ICombatDao{

	@Override
	public CombatDB findCombatByUserId(int userId){
		return (CombatDB) this.getSqlMapClientTemplate().queryForObject("queryForCombat", userId);
	}

	public CombatDB getCombatById(String combatId) throws SQLException {
		return (CombatDB) this.getSqlMapClientTemplate().queryForObject("queryForCombatById", combatId);
//		return (Combat) this.getSqlMapClient().queryForObject("queryForCombatById", combatId);
	}
	//org.springframework.orm.ibatis.support.SqlMapClientDaoSupport.getSqlMapClientTemplate()


	
}
