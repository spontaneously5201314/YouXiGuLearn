package com.youxigu.dynasty.combat.service;

import java.io.Serializable;
import java.util.HashMap;

import com.youxigu.dynasty.combat.domain.combat.Combat;

/**
 * @Description: 战斗引擎接口
 * @author myg
 * @time 2015年12月25日 下午4:12:10
 */
public interface ICombatEngine extends Serializable {

	/**
	 * 执行一场战斗
	 * @param combat 包括一场战斗的所有数据
	 * @return
	 */
	public HashMap<String, String> execCombat(Combat combat);
}
