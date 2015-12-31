package com.youxigu.dynasty.entity.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
* @Description: 武将的技能实体类
* @author myg
* @time 2015年12月31日 下午2:29:53
*/
public class HeroSkill extends Entity implements Serializable {

	private static final long serialVersionUID = -4564971067796147554L;
	public static final short SKILL_TYPE_FENG = 0;
	public static final short SKILL_TYPE_HUO = 1;
	public static final short SKILL_TYPE_LIN = 2;
	public static final short SKILL_TYPE_SHAN = 3;
	public static final short SKILL_TYPE_ADVISER_POWER = 4;
	public static final short SKILL_TYPE_ADVISER_INTEL = 5;

	public static final short FIRED_AT_BEGIN = 0;// 开战前即发动，一直有效
	public static final short FIRED_AT_BEFOREATK1 = 1;// 攻击前发动，不占用普通攻击
	public static final short FIRED_AT_BEFOREATK2 = 2;// 攻击前发动，占用普通攻击
	public static final short FIRED_AT_AFTERATK = 3;// 攻击后发动
	public static final short FIRED_AT_ATTACKED = 4;// 被攻击后发动
	public static final short FIRED_AT_ROUNDBEGIN = 5;// 回合开始前技能
	public static final short FIRED_AT_END = 6;// 战斗后施放技能，仅对军师有效，用来特殊处理 论语/搜刮

	public static final int TARGET_ARMY_BUBUING = 1;// 步兵/盾兵
	public static final int TARGET_ARMY_GONGBING = 2;// 弓兵/弓兵
	public static final int TARGET_ARMY_QIBING = 4;// 骑兵/剑士
	public static final int TARGET_ARMY_CHEBING = 8;// 车兵/枪兵
	public static final int TARGET_ARMY_CHESHI = 16;// 策士/策士
	public static final int TARGET_ARMY_CHENGFANG = 32;// 城防
	public static final int TARGET_ARMY_WALL = 64;// 城墙

	public static final short OWN_SKILL = 1;// 天生技能
	public static final short SPEC_SKILL1 = 2;// 特殊技能1
	public static final short SPEC_SKILL2 = 3;// 特殊技能2、特殊技能3

	private String skillName;
	private int level; // 等级
	private int nextSkillId;// 升级后的技能Id

	private String skillDesc;
	private String iocn;
	private String pic;

	/**
	 * 技能品质：（军师技能有效） 0无 1绿 2蓝 3紫 4橙
	 */
	private int quality;
	/**
	 * 是否是天成技能 =0非天生技能；（后天学习的技能，即被动技能） =1：天生技能；（天生技能，即主动技能） =2 特殊技能1
	 * =3特殊技能2、特殊技能3
	 */
	private short ownSkill;

	/**
	 * 技能类型 =0 风 =1 火 =2 林 =3山 =4 军师-武力类 =5 军师武力类-6智力类
	 */
	private short skillType;
	/**
	 * 施放技能的时机<BR>
	 * 0：开战前即发动，一直有效；<BR>
	 * 1：攻击前发动，不占用普通攻击；<BR>
	 * 2：攻击时发动，占用普通攻击；<BR>
	 * 3：攻击后发动，不占用普通攻击；<BR>
	 * 4：被攻击时发动，不占用普通攻击；<BR>
	 * 5：回合开始前技能不占用普通攻击；<BR>
	 * 6:战斗后发动，仅对军师技能有效(为了处理论语，搜刮技能)；<BR>
	 * <BR>
	 */
	private short firedAt;

	/**
	 * 施放的概率，百分比
	 */
	private int percent;

	/**
	 * 持续的回合数
	 */
	private int roundPeriod;

	/**
	 * 作用目标
	 * 1：自己；<BR>
	 * 2：己方全体；<BR>
	 * 3：己方随机n个部队；<BR>
	 * 4：攻击范围内敌方n个攻击对象；（n=1~6，包括城墙）<BR>
	 * 5：敌方全体（无视攻击距离）；<BR>
	 * 6：攻击目标横向一条直线上所有敌方的单位；（包括城墙）<BR>
	 * 7：攻击目标纵向一条直线上所有敌方的单位；（包括城墙）<BR>
	 * 8：己方的城防设施；<BR>
	 * 9：敌方的城防设施；<BR>
	 * 10：对自己进行攻击的战斗单元或者自己攻击的战斗单元<BR>
	 * 11：对自己进行攻击的战斗单元；并且在攻击范围内<BR>
	 * 12：己方全体受伤的部队（不包括城墙/城防）<BR>
	 * 13：自己(受伤)<BR>
	 * 14: 敌方任意n个(不包括城墙)
	 */
	private short target;

	/**
	 * 最大目标数，<=0表示不限制 仅对target=4有效
	 */
	private short targetNum;

	/**
	 * 目标兵种类型，按位表示，可叠加<br>
	 * 0任意 –为了兼容原武将技能 <br>
	 * 1步兵<br>
	 * 2 弓兵<br>
	 * 4 骑兵<br>
	 * 8 车兵<br>
	 * 16 策士<br>
	 */
	private int targetArmy;
	/**
	 * 战斗力类型,1=千分比,0=绝对值
	 */
	private byte powerType;
	/**
	 * 战斗力
	 */
	private int power;

	/**
	 * 带哪种兵种的武将可以学习该技能 按位表示，可叠加 =0，不能学习 1步兵（盾） 2 弓兵（弓） 4 骑兵（剑） 8 车兵（枪） 16 策士（策）
	 * 对普通技能，填0 对特殊技能1 ，填 上述的任意值或者叠加 对于特殊技能2.3,无效，填 31
	 */
	private int canStudy;
	/**
	 * 前置技能Id，同时也是受增益的普通技能Id 多个用逗号分开。 特殊技能2,特殊技能3有效
	 */
	private String baseSkillIds;
	/**
	 * 可替换的技能Id，多个用逗号分开 普通技能有效
	 */
	private String switchSkillds;
	/**
	 * 替换技能消耗的道具Id
	 */
	private int switchItemId;
	/**
	 * 替换技能消耗的道具数量
	 */
	private int switchItemNum;

	private List<HeroSkillEffect> skillEffects;

	private List<HeroSkillLimit> skillLimits;

	private transient HeroSkill prev;// 上一级技能（低级）=null则没有上一级，为根技能
	private transient HeroSkill next;// 下一级技能(高级)，=null则没有下一级

	private transient HeroSkill root;

	private transient Map<HeroSkill, Object> baseSkillIdMaps;
	private transient Map<HeroSkill, Object> switchSkilldMaps;

	/**
	 * 特殊技能2,3的效果缓存 key = 兵种类型,TARGET_ARMY_BUBUING ........ value = map key =
	 * effKey value = effValue
	 */
	private Map<Integer, Map<String, Integer>> specEffMaps = null;

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getNextSkillId() {
		return nextSkillId;
	}

	public void setNextSkillId(int nextSkillId) {
		this.nextSkillId = nextSkillId;
	}

	public String getSkillDesc() {
		return skillDesc;
	}

	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}

	public String getIocn() {
		return iocn;
	}

	public void setIocn(String iocn) {
		this.iocn = iocn;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public short getOwnSkill() {
		return ownSkill;
	}

	public void setOwnSkill(short ownSkill) {
		this.ownSkill = ownSkill;
	}

	public short getSkillType() {
		return skillType;
	}

	public void setSkillType(short skillType) {
		this.skillType = skillType;
	}

	public short getFiredAt() {
		return firedAt;
	}

	public void setFiredAt(short firedAt) {
		this.firedAt = firedAt;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public int getRoundPeriod() {
		return roundPeriod;
	}

	public void setRoundPeriod(int roundPeriod) {
		this.roundPeriod = roundPeriod;
	}

	public short getTarget() {
		return target;
	}

	public void setTarget(short target) {
		this.target = target;
	}

	public short getTargetNum() {
		return targetNum;
	}

	public void setTargetNum(short targetNum) {
		this.targetNum = targetNum;
	}

	public int getTargetArmy() {
		return targetArmy;
	}

	public void setTargetArmy(int targetArmy) {
		this.targetArmy = targetArmy;
	}

	public byte getPowerType() {
		return powerType;
	}

	public void setPowerType(byte powerType) {
		this.powerType = powerType;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getCanStudy() {
		return canStudy;
	}

	public void setCanStudy(int canStudy) {
		this.canStudy = canStudy;
	}

	public String getBaseSkillIds() {
		return baseSkillIds;
	}

	public void setBaseSkillIds(String baseSkillIds) {
		this.baseSkillIds = baseSkillIds;
	}

	public String getSwitchSkillds() {
		return switchSkillds;
	}

	public void setSwitchSkillds(String switchSkillds) {
		this.switchSkillds = switchSkillds;
	}

	public int getSwitchItemId() {
		return switchItemId;
	}

	public void setSwitchItemId(int switchItemId) {
		this.switchItemId = switchItemId;
	}

	public int getSwitchItemNum() {
		return switchItemNum;
	}

	public void setSwitchItemNum(int switchItemNum) {
		this.switchItemNum = switchItemNum;
	}

	public List<HeroSkillEffect> getSkillEffects() {
		return skillEffects;
	}

	public void setSkillEffects(List<HeroSkillEffect> skillEffects) {
		this.skillEffects = skillEffects;
	}

	public List<HeroSkillLimit> getSkillLimits() {
		return skillLimits;
	}

	public void setSkillLimits(List<HeroSkillLimit> skillLimits) {
		this.skillLimits = skillLimits;
	}

	public HeroSkill getPrev() {
		return prev;
	}

	public void setPrev(HeroSkill prev) {
		this.prev = prev;
	}

	public HeroSkill getNext() {
		return next;
	}

	public void setNext(HeroSkill next) {
		this.next = next;
	}

	public HeroSkill getRoot() {
		return root;
	}

	public void setRoot(HeroSkill root) {
		this.root = root;
	}

	public Map<HeroSkill, Object> getBaseSkillIdMaps() {
		return baseSkillIdMaps;
	}

	public void setBaseSkillIdMaps(Map<HeroSkill, Object> baseSkillIdMaps) {
		this.baseSkillIdMaps = baseSkillIdMaps;
	}

	public Map<HeroSkill, Object> getSwitchSkilldMaps() {
		return switchSkilldMaps;
	}

	public void setSwitchSkilldMaps(Map<HeroSkill, Object> switchSkilldMaps) {
		this.switchSkilldMaps = switchSkilldMaps;
	}

	public Map<Integer, Map<String, Integer>> getSpecEffMaps() {
		return specEffMaps;
	}

	public void setSpecEffMaps(Map<Integer, Map<String, Integer>> specEffMaps) {
		this.specEffMaps = specEffMaps;
	}
}
