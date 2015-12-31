package com.youxigu.dynasty.combat.domain.skill;

import java.util.List;

import com.youxigu.dynasty.combat.domain.combat.CombatUnit;

/**
* @Description: 寻找目标的接口 
* @author myg
* @time 2015年12月31日 下午4:37:39
*/
public interface ITargetSearcher {

	List<CombatUnit> doSearchTarget(CombatSkill skill,CombatUnit source,CombatUnit target);
}
