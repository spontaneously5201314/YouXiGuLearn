package com.youxigu.dynasty.combat.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.youxigu.dynasty.combat.action.CombatAction;

/**
* @Description: 测试我自己写的简单的战斗引擎
* @author myg
* @time 2015年12月25日 下午4:53:04
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CombatTest {

	@Resource(name="combatAction")
	private CombatAction combatAction;
	
	@Test
	public void testCombat(){
		System.out.println(combatAction.getCombatById("C_00119469-922d-4e7c-adf9-d5f61f1fb535-2-11040586"));
	}
}
