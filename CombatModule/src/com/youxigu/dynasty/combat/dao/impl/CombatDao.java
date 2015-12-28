package com.youxigu.dynasty.combat.dao.impl;

import java.sql.SQLException;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.youxigu.dynasty.combat.dao.ICombatDao;
import com.youxigu.dynasty.combat.domain.combat.Combat;

/**
* @Description: 从数据库中查找战斗团队信息的dao
* @author myg
* @time 2015年12月25日 下午4:56:25
*/
public class CombatDao extends SqlMapClientDaoSupport implements ICombatDao{

	@Override
	public Combat findCombatByUserId(int userId){
		return (Combat) this.getSqlMapClientTemplate().queryForObject("queryForCombat", userId);
	}

	public Combat getCombatById(String combatId) throws SQLException {
		return (Combat) this.getSqlMapClientTemplate().queryForObject("queryForCombatById", combatId);
//		return (Combat) this.getSqlMapClient().queryForObject("queryForCombatById", combatId);
	}
	//org.springframework.orm.ibatis.support.SqlMapClientDaoSupport.getSqlMapClientTemplate()


	
}
