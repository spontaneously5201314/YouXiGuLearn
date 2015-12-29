package com.youxigu.dynasty.combat.domain.combat;

import java.io.Serializable;

/**
* @Description: 战斗相关的残联
* @author myg
* @time 2015年12月29日 下午5:32:27
*/
public class CombatConstants implements Serializable {
	private static final long serialVersionUID = 5967990760757009649L;

	/**
	 * 防守方赢得战斗
	 */
	public static final byte DEF_WIN = 1;
	/**
	 * 进攻方赢得战斗
	 */
	public static final byte ATK_WIN = 2;
}
