package com.youxigu.dynasty.combat.domain.combat;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.youxigu.dynasty.combat.domain.behavior.AbstractCombatBehavior;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ICombatEngine getCombatEngine() {
		return combatEngine;
	}

	public void setCombatEngine(ICombatEngine combatEngine) {
		this.combatEngine = combatEngine;
	}

	public CombatTeam getParent() {
		return parent;
	}

	public void setParent(CombatTeam parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public byte getInitX() {
		return initX;
	}

	public void setInitX(byte initX) {
		this.initX = initX;
	}

	public byte getInitY() {
		return initY;
	}

	public void setInitY(byte initY) {
		this.initY = initY;
	}

	public byte getInitDirection() {
		return initDirection;
	}

	public void setInitDirection(byte initDirection) {
		this.initDirection = initDirection;
	}

	public byte getX() {
		return x;
	}

	public void setX(byte x) {
		this.x = x;
	}

	public byte getY() {
		return y;
	}

	public void setY(byte y) {
		this.y = y;
	}

	public byte getDirection() {
		return direction;
	}

	public void setDirection(byte direction) {
		this.direction = direction;
	}

	public boolean isCanAttacked() {
		return canAttacked;
	}

	public void setCanAttacked(boolean canAttacked) {
		this.canAttacked = canAttacked;
	}

	public int getUnitEntId() {
		return unitEntId;
	}

	public void setUnitEntId(int unitEntId) {
		this.unitEntId = unitEntId;
	}

	public int getArmyEntId() {
		return armyEntId;
	}

	public void setArmyEntId(int armyEntId) {
		this.armyEntId = armyEntId;
	}

	public int getGrowing() {
		return growing;
	}

	public void setGrowing(int growing) {
		this.growing = growing;
	}

	public int getInitLead() {
		return initLead;
	}

	public void setInitLead(int initLead) {
		this.initLead = initLead;
	}

	public int getInitArmyNum() {
		return initArmyNum;
	}

	public void setInitArmyNum(int initArmyNum) {
		this.initArmyNum = initArmyNum;
	}

	public int getCurrArmyNum() {
		return currArmyNum;
	}

	public void setCurrArmyNum(int currArmyNum) {
		this.currArmyNum = currArmyNum;
	}

	public int getResumeArmyNum() {
		return resumeArmyNum;
	}

	public void setResumeArmyNum(int resumeArmyNum) {
		this.resumeArmyNum = resumeArmyNum;
	}

	public short getHpStatus() {
		return hpStatus;
	}

	public void setHpStatus(short hpStatus) {
		this.hpStatus = hpStatus;
	}

	public short getUnitType() {
		return unitType;
	}

	public void setUnitType(short unitType) {
		this.unitType = unitType;
	}

	public int getAwardExp() {
		return awardExp;
	}

	public void setAwardExp(int awardExp) {
		this.awardExp = awardExp;
	}

	public boolean isCurrRoundAttacked() {
		return currRoundAttacked;
	}

	public void setCurrRoundAttacked(boolean currRoundAttacked) {
		this.currRoundAttacked = currRoundAttacked;
	}

	public double getCurrHarm() {
		return currHarm;
	}

	public void setCurrHarm(double currHarm) {
		this.currHarm = currHarm;
	}

	public double getCurrPower() {
		return currPower;
	}

	public void setCurrPower(double currPower) {
		this.currPower = currPower;
	}

	public short getSortDistance() {
		return sortDistance;
	}

	public void setSortDistance(short sortDistance) {
		this.sortDistance = sortDistance;
	}

	public short getSortYDis() {
		return sortYDis;
	}

	public void setSortYDis(short sortYDis) {
		this.sortYDis = sortYDis;
	}

	public Map<Short, List<CombatSkill>> getSkills() {
		return skills;
	}

	public void setSkills(Map<Short, List<CombatSkill>> skills) {
		this.skills = skills;
	}

	public List<CombatSkillEffect> getSkillEffects() {
		return skillEffects;
	}

	public void setSkillEffects(List<CombatSkillEffect> skillEffects) {
		this.skillEffects = skillEffects;
	}

	public Map<String, Integer> getSkillEffectValues() {
		return skillEffectValues;
	}

	public void setSkillEffectValues(Map<String, Integer> skillEffectValues) {
		this.skillEffectValues = skillEffectValues;
	}

	public Map<String, Integer> getTmpSkillEffectValues() {
		return tmpSkillEffectValues;
	}

	public void setTmpSkillEffectValues(Map<String, Integer> tmpSkillEffectValues) {
		this.tmpSkillEffectValues = tmpSkillEffectValues;
	}

	public CombatSkill getSpecialSkill() {
		return specialSkill;
	}

	public void setSpecialSkill(CombatSkill specialSkill) {
		this.specialSkill = specialSkill;
	}

	public List<CombatSkillEffect> get_skillEffects() {
		return _skillEffects;
	}

	public void set_skillEffects(List<CombatSkillEffect> _skillEffects) {
		this._skillEffects = _skillEffects;
	}

	public Map<String, Integer> get_skillEffectValues() {
		return _skillEffectValues;
	}

	public void set_skillEffectValues(Map<String, Integer> _skillEffectValues) {
		this._skillEffectValues = _skillEffectValues;
	}

	public Map<String, Integer> get_tmpSkillEffectValues() {
		return _tmpSkillEffectValues;
	}

	public void set_tmpSkillEffectValues(Map<String, Integer> _tmpSkillEffectValues) {
		this._tmpSkillEffectValues = _tmpSkillEffectValues;
	}
	/**
	 * 战斗单元的机动力：影响移动的先后顺序
	 */
	public abstract long _getMobility();

	/**
	 * 战斗单元的行动力：战场上每回合最远的移动距离
	 * 
	 * @return
	 */
	public abstract int _getMoveRange();

	/**
	 * 战斗单元的攻击/移动频率：攻击/移动一次后，需要多少回合可以再次攻击、移动，>=1,默认为1，每回合都攻击
	 * 
	 * @return
	 */
	public abstract double _getFrequency();

	/**
	 * 战斗单元的攻击范围
	 * 
	 * @return
	 */
	public abstract int _getAttackRange();

	/**
	 * 得到战斗单元带兵类型
	 * 
	 * @return
	 */
	public abstract String _getUnitArmyType();

	/**
	 * 带兵类型对应的整数值,技能使用这个作为过滤兵种的条件
	 * 
	 * @return
	 */
	public abstract int _getUnitArmyTypeInt();
	
	public abstract int _getUnitBaseArmyTypeInt();	

	public abstract String _getArmyName();

	/**
	 * 得到阵法位置
	 * 
	 * @return
	 */
	public abstract int _getFormationPos();

	/**
	 * 攻击类型 =0物理攻击 =1法术攻击 10;//单挑物理攻击 11;//单挑法术攻击
	 * 
	 * @return
	 */
	public abstract int _getAtkMode();

	/**
	 * 战斗单元的生命值
	 * 
	 * @return
	 */
	public abstract int _getHp();

	/**
	 * 攻击
	 * 
	 * @return
	 */
	public abstract int _getAttack();

	/**
	 * 防御
	 * 
	 * @return
	 */
	public abstract int _getDefense();

	/**
	 * 体力
	 * 
	 * @return
	 */
	public abstract int _getStrength();

	/**
	 * 敏捷
	 * 
	 * @return
	 */
	public abstract int _getAgility();

	/**
	 * 额外闪避率
	 * 
	 * @return
	 */
	public abstract int _getAddDodge();

	/**
	 * 额外命中率
	 * 
	 * @return
	 */
	public abstract int _getAddHit();

	/**
	 * 额外暴击率
	 * 
	 * @return
	 */
	public abstract int _getDamageAdd();

	/**
	 * 增伤
	 * 
	 * @return
	 */
	public abstract int _getDamageDec();

	/**
	 * 减伤
	 * 
	 * @return
	 */
	public abstract int _getAddCrit();

	/**
	 * 取得兵种相克附加效果
	 * 
	 * @return
	 */
	public abstract double _getArmyAttackRelationAdd(int armyType);

	public abstract double _getArmyAttackRelationDec(int armyType);

	/**
	 * 判断武将时候已经死亡
	 * @return
	 */
	public boolean dead() {
		return this.currArmyNum == 0 ? true : false;
	}

	/**
	 * 增加武将出手的战力
	 */
	public void increasePower() {
		currPower = currPower + this._getFrequency() / 100d;
	}
	
	/**
	 * 减少武将出手的战力
	 */
	public void decreasePower(){
		currPower = currPower - 1;
	}

	public boolean attack() {
		if (this.isCurrRoundAttacked()) {
			return false;
		}
		CombatUnit target = _getFirstCanAttackUnit();
		if (target != null) {
			return _doAttack(target);
		}
		return false;
	}

	/**
	 * 找到兵种攻击优先级最高的，相同优先级下距离最近的在攻击范围内的目标
	 * @return
	 */
	private CombatUnit _getFirstCanAttackUnit() {
		CombatUnit curr = null;
		int currDist = Integer.MAX_VALUE;
		int currPriority = Integer.MAX_VALUE;
		int currFPos = Integer.MAX_VALUE;
		CombatTeam team = this.getParent().getEnemyTeam();
		int atkRange = this._getAttackRange();
		boolean hasNotWallCombatUnit = false;
		for (CombatUnit unit : team.getUnits()) {
			if (unit.dead() || !unit.isCanAttacked())
				continue;
			int distance = Math.abs(this.x - unit.x);
			if (!(this instanceof CanotAttackedCombatUnit)) {
				if (!(unit instanceof WallCombatUnit)) {// 城墙占整个Y轴，不计算Y
					distance = Math.abs(this.y - unit.y) + distance;
					if (!hasNotWallCombatUnit) {
						hasNotWallCombatUnit = true;
					}
				}
			}
			if (distance <= atkRange) {
				if (currDist == 1) {
					// 近身的优先级最高，多个近身的则按兵种优先顺序
					if (distance == 1) {
						int priority = getPriority(this, unit);
						if (priority < currPriority) {
							curr = unit;
							currDist = distance;
							currPriority = priority;
							currFPos = unit._getFormationPos();
						} else if (priority == currPriority) {
							// 阵法序号小的优先
							int fpos = unit._getFormationPos();
							if (fpos < currFPos) {
								curr = unit;
								currDist = distance;
								currPriority = priority;
								currFPos = fpos;
							}
						}
					} else {
						// 扔掉，只要有近身的就打近身的
					}
				} else {
					int priority = getPriority(this, unit);
					if (distance == 1) {// 近身的优先
						curr = unit;
						currDist = distance;
						currPriority = priority;
						currFPos = unit._getFormationPos();
					} else {
						if (priority < currPriority) {
							curr = unit;
							currDist = distance;
							currPriority = priority;
							currFPos = unit._getFormationPos();
						} else if (priority == currPriority) {
							if (distance < currDist) {
								curr = unit;
								currDist = distance;
								currPriority = priority;
								currFPos = unit._getFormationPos();
							} else {
								// 阵法序号小的优先
								int fpos = unit._getFormationPos();
								if (fpos < currFPos) {
									curr = unit;
									currDist = distance;
									currPriority = priority;
									currFPos = unit._getFormationPos();
								}
							}
						}
					}
				}
			}
		}
		// /如果还有非城墙类的可攻击的敌对单位存活，则不攻击城墙
		if (curr instanceof WallCombatUnit && hasNotWallCombatUnit) {
			return null;
		}
		return curr;
	}

	/**
	 * 两个战斗单元，获取其中优先级高的
	 * @param combatUnit
	 * @param unit
	 * @return
	 */
	private int getPriority(CombatUnit unit1, CombatUnit unit2) {
		return this.getCombatEngine().getArmyAttackPriority(unit1._getUnitArmyType(), unit2._getUnitArmyType());
	}

	/**
	 * 寻找可以攻击的目标
	 * @param target
	 * @return
	 */
	private boolean _doAttack(CombatUnit target) {
		// TODO Auto-generated method stub
		return false;
	}

	public AbstractCombatBehavior doMove() {
		// TODO Auto-generated method stub
		return null;
	}

}
