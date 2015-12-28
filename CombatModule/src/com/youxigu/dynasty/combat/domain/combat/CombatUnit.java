package com.youxigu.dynasty.combat.domain.combat;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.youxigu.dynasty.combat.domain.skill.CombatSkill;
import com.youxigu.dynasty.combat.domain.skill.CombatSkillEffect;
import com.youxigu.dynasty.combat.service.ICombatEngine;

/**
* @Description: 抽象的战斗单元
* @author myg
* @time 2015年12月25日 上午11:02:36
*/
public abstract class CombatUnit implements Serializable,Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7542748646020121784L;
	/**
	 *战斗单元的ID,自动生成
	 */
	protected int id;
	protected transient ICombatEngine combatEngine;
	/**
	 * 所属的团队
	 */
	protected transient CombatTeam parent;
	/**
	 * 战斗单元的名称(武将/哨塔/城防/城墙)
	 */
	protected String name;
	/**
	 * 战斗单元的头像
	 */
	protected String icon;
	/**
	 * 战斗单元的等级
	 */
	protected int level;
	/**
	 * 战斗单元的初始坐标
	 */
	protected transient byte initX;
	protected transient byte initY;
	protected transient byte initDirection;
	/**
	 * 战斗单元当前所在位置的横坐标
	 */
	protected transient byte x;
	/**
	 * 战斗单元当前所在位置的纵坐标
	 */
	protected transient byte y;
	/**
	 * 移动方向
	 */
	protected transient byte direction;
	protected transient boolean canAttacked = true;// 是否可被攻击
	protected int unitEntId;// 战斗单元的entId(SysheroId....)，前台显示用
	protected int armyEntId;// 兵种，前台显示用
	protected int growing;// 颜色
	protected int initLead;// 初始统帅，对于一个战斗单元需要打多场战斗的时候,需要这个
	protected int initArmyNum;// 初始带兵量
	protected int currArmyNum;// 当前带兵量
	protected int resumeArmyNum;// 战斗后回复的兵力
	protected short hpStatus = 100;// 战斗完成后的健康度
	protected short unitType;// 战斗单元类型：默认为子类名称;
	protected int awardExp;// 战斗奖励的经验
	// 记录当前回合是否已经攻击过
	protected transient boolean currRoundAttacked;
	// 本次被攻击受到的伤害值 ，临时缓存，每次攻击逻辑完成后清零
	protected transient double currHarm;
	/**
	 * 当前的攻击/移动能力：能力大于1，可以进行攻击、移动.否则本回合静止 currPower初始为0， 每一回合 currPower =
	 * currPower+this.getFrequency()/100d; 如果当前回合currPower<1,则不能进行攻击
	 * 如果当前回合currPower>=1,则可以攻击,攻击后currPower=currPower-1
	 * 
	 */
	protected transient double currPower;
	/**
	 * 按距离排序临时变量
	 */
	protected transient short sortDistance;
	protected transient short sortYDis;// y轴距离
	// ////////////////////////技能类处理
	/**
	 * 战斗单元的技能列表,key =发动时机
	 */
	protected transient Map<Short, List<CombatSkill>> skills;

	// //////////////////////////武将类技能缓存
	/**
	 * 附加在战斗单元身上的技能效果,BUF类与DOT类
	 */
	protected transient List<CombatSkillEffect> skillEffects;

	/**
	 * 累计的未失效的技能效果和,BUF类与DOT类
	 */
	protected transient Map<String, Integer> skillEffectValues;

	/**
	 * 普通==通常是指瞬间效果，或者说对一次攻击有效，对一次防御有效的效果,一次攻击后清除
	 */
	protected transient Map<String, Integer> tmpSkillEffectValues;

	// ////////////////////特殊技能1，由于与武将普通技能效果同时存在，且相互不影响，并且叠加方式不同，这里只能分成两套缓存

	/**
	 * 特殊技能
	 */
	protected transient CombatSkill specialSkill;
	/**
	 * 附加在战斗单元身上的技能效果,BUF类与DOT类
	 */
	protected transient List<CombatSkillEffect> _skillEffects;

	/**
	 * 累计的未失效的技能效果和,BUF类与DOT类
	 */
	protected transient Map<String, Integer> _skillEffectValues;

	/**
	 * 普通==通常是指瞬间效果，或者说对一次攻击有效，对一次防御有效的效果,一次攻击后清除
	 */
	protected transient Map<String, Integer> _tmpSkillEffectValues;
}
