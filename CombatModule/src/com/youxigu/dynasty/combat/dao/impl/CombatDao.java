package com.youxigu.dynasty.combat.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.youxigu.dynasty.combat.dao.ICombatDao;
import com.youxigu.dynasty.combat.domain.attackrelation.ArmyAttackRelation;
import com.youxigu.dynasty.combat.domain.combat.CombatDB;
import com.youxigu.dynasty.combat.domain.combat.CombatFactor;
import com.youxigu.dynasty.combat.domain.combat.CombatHarmFactor;

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
	}

	@Override
	public List<ArmyAttackRelation> getArmyAttackRelation() {
		return this.getSqlMapClientTemplate().queryForList("youxigu.queryForArmyAttackRelation");
	}

	@Override
	public List<CombatFactor> getCombatFactor() {
		return this.getSqlMapClientTemplate().queryForList("youxigu.queryForCombatFactor");
	}

	@Override
	public List<CombatHarmFactor> getCombatHarmFactor() {
		return this.getSqlMapClientTemplate().queryForList("youxigu.queryForCombatHarmFactor");
	}



	
}
