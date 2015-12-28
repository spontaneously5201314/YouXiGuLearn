package com.youxigu.dynasty.hero.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description: 武将
 * @author myg
 * @time 2015年12月28日 下午4:53:29
 */
public class Hero implements Serializable {
	// status 雇佣状态 1:等待雇佣, 2:雇佣 , 3:已解雇
	public static final int STATUS_UNEMPLOYEE = 1;
	public static final int STATUS_EMPLOYEE = 2;
	public static final int STATUS_FIRED = 3;

	// 基本信息
	protected long heroId;// 主键
	protected long casId;// 所属城堡id
	protected long userId;// 君主id
	protected int sysHeroId;// 系统武将entId
	protected String name;// 名字
	protected String icon;// 武将头像
	protected int level;// 级别
	protected int exp;// 经验
	protected int power;// 武力修改为攻击
	protected int skill;// 技巧修改为防御
	protected int intel;// 智力修改为体力
	protected int strategy;// 谋略修改为敏捷
	protected int growing;// 当前成长
	protected int growingItem;// 达到当前成长消耗的道具数量
	protected int relifeNum;// 转生次数
	protected int featureId;// 特点id
	protected int chartr;// 性格 （1：谨慎，2：冷静，3：果敢，4：勇猛）
	// 状态
	// status 雇佣状态 , 1:雇佣 , 2:等待雇佣.3:已解雇
	// 对Hero已经没用了，对FiredHero有用
	protected int status = STATUS_EMPLOYEE; // 雇佣状态 1:未雇佣 2：已雇佣
	protected int actionStatus; // 行动状态
	protected Timestamp freeDttm;// 行动超时时间
	// 装备
	protected long equ1;// 头盔-treasuryId
	protected long equ2;// 盔甲
	protected long equ3;// 武器
	protected long equ4;// 护腿
	protected long equ5;// 饰品
	protected long equ6;// 披风-treasuryId
	protected long equ7;
	protected long equ8;
	protected long equ9;
	protected long equ10;
	// 配兵
	protected int armyEntId; // 带兵entId-兵种
	protected int armyNum; // 带兵数量
	// 封官
	protected int govPotzId;// 官职
	protected Timestamp govPotzTime;// 封官时间
	protected int careerId;// 职业id
	protected int heroSkillId;// 技能ID0
	protected int heroSkillId1;// 技能ID1 ,特殊技能1
	protected int heroSkillId2;// 技能ID2,特殊技能2，或者特殊技能3
	@Deprecated
	protected int heroSkillId3;// 技能ID3，暂时不用
	@Deprecated
	protected int heroSkillId4;// 技能ID4，暂时不用
	@Deprecated
	protected int heroSkillId5;// 技能ID5，暂时不用
	@Deprecated
	protected int heroSkillId6;// 技能ID6，暂时不用
	// 门客
	protected int hangerEntId1;
	protected int hangerEntId2;
	protected int hangerEntId3;
	protected int hangerEntId4;
	protected int hangerEntId5;
	// 武将情缘
	protected String heroFate;
	// 装备情缘
	protected String equipFate;
	/**
	 * 镶嵌的宝石id
	 */
	protected int gemId1;
	/**
	 * 宝石1当前的经验
	 */
	protected int gemExp1;

	/**
	 * 镶嵌的宝石id
	 */
	protected int gemId2;
	/**
	 * 宝石1当前的经验
	 */
	protected int gemExp2;

	/**
	 * 镶嵌的宝石id
	 */
	protected int gemId3;
	/**
	 * 宝石1当前的经验
	 */
	protected int gemExp3;

	/**
	 * 镶嵌的宝石id
	 */
	protected int gemId4;
	/**
	 * 宝石1当前的经验
	 */
	protected int gemExp4;

	/**
	 * 镶嵌的宝石id
	 */
	protected int gemId5;
	/**
	 * 宝石1当前的经验
	 */
	protected int gemExp5;

	/**
	 * 镶嵌的宝石id
	 */
	protected int gemId6;
	/**
	 * 宝石1当前的经验
	 */
	protected int gemExp6;

	/**
	 * 镶嵌的宝石id
	 */
	protected int gemId7;
	/**
	 * 宝石1当前的经验
	 */
	protected int gemExp7;

	/**
	 * 镶嵌的宝石id
	 */
	protected int gemId8;
	/**
	 * 宝石1当前的经验
	 */
	protected int gemExp8;

	/**
	 * 镶嵌的宝石id
	 */
	protected int gemId9;
	/**
	 * 宝石1当前的经验
	 */
	protected int gemExp9;

	/**
	 * 宝石类型：默认0为宝石，1为玉帛 1位置的宝石类型，2~9以此类推
	 */
	protected int gemType1 = 0;
	protected int gemType2 = 0;
	protected int gemType3 = 0;
	protected int gemType4 = 0;
	protected int gemType5 = 0;
	protected int gemType6 = 0;
	protected int gemType7 = 0;
	protected int gemType8 = 0;
	protected int gemType9 = 0;
	/**
	 * 所在军团的阵型Id,用于计算军师对阵型的加成
	 */
	protected int formationId;

	public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

	public long getCasId() {
		return casId;
	}

	public void setCasId(long casId) {
		this.casId = casId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getSysHeroId() {
		return sysHeroId;
	}

	public void setSysHeroId(int sysHeroId) {
		this.sysHeroId = sysHeroId;
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

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public int getIntel() {
		return intel;
	}

	public void setIntel(int intel) {
		this.intel = intel;
	}

	public int getStrategy() {
		return strategy;
	}

	public void setStrategy(int strategy) {
		this.strategy = strategy;
	}

	public int getGrowing() {
		return growing;
	}

	public void setGrowing(int growing) {
		this.growing = growing;
	}

	public int getGrowingItem() {
		return growingItem;
	}

	public void setGrowingItem(int growingItem) {
		this.growingItem = growingItem;
	}

	public int getRelifeNum() {
		return relifeNum;
	}

	public void setRelifeNum(int relifeNum) {
		this.relifeNum = relifeNum;
	}

	public int getFeatureId() {
		return featureId;
	}

	public void setFeatureId(int featureId) {
		this.featureId = featureId;
	}

	public int getChartr() {
		return chartr;
	}

	public void setChartr(int chartr) {
		this.chartr = chartr;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getActionStatus() {
		return actionStatus;
	}

	public void setActionStatus(int actionStatus) {
		this.actionStatus = actionStatus;
	}

	public Timestamp getFreeDttm() {
		return freeDttm;
	}

	public void setFreeDttm(Timestamp freeDttm) {
		this.freeDttm = freeDttm;
	}

	public long getEqu1() {
		return equ1;
	}

	public void setEqu1(long equ1) {
		this.equ1 = equ1;
	}

	public long getEqu2() {
		return equ2;
	}

	public void setEqu2(long equ2) {
		this.equ2 = equ2;
	}

	public long getEqu3() {
		return equ3;
	}

	public void setEqu3(long equ3) {
		this.equ3 = equ3;
	}

	public long getEqu4() {
		return equ4;
	}

	public void setEqu4(long equ4) {
		this.equ4 = equ4;
	}

	public long getEqu5() {
		return equ5;
	}

	public void setEqu5(long equ5) {
		this.equ5 = equ5;
	}

	public long getEqu6() {
		return equ6;
	}

	public void setEqu6(long equ6) {
		this.equ6 = equ6;
	}

	public long getEqu7() {
		return equ7;
	}

	public void setEqu7(long equ7) {
		this.equ7 = equ7;
	}

	public long getEqu8() {
		return equ8;
	}

	public void setEqu8(long equ8) {
		this.equ8 = equ8;
	}

	public long getEqu9() {
		return equ9;
	}

	public void setEqu9(long equ9) {
		this.equ9 = equ9;
	}

	public long getEqu10() {
		return equ10;
	}

	public void setEqu10(long equ10) {
		this.equ10 = equ10;
	}

	public int getArmyEntId() {
		return armyEntId;
	}

	public void setArmyEntId(int armyEntId) {
		this.armyEntId = armyEntId;
	}

	public int getArmyNum() {
		return armyNum;
	}

	public void setArmyNum(int armyNum) {
		this.armyNum = armyNum;
	}

	public int getGovPotzId() {
		return govPotzId;
	}

	public void setGovPotzId(int govPotzId) {
		this.govPotzId = govPotzId;
	}

	public Timestamp getGovPotzTime() {
		return govPotzTime;
	}

	public void setGovPotzTime(Timestamp govPotzTime) {
		this.govPotzTime = govPotzTime;
	}

	public int getCareerId() {
		return careerId;
	}

	public void setCareerId(int careerId) {
		this.careerId = careerId;
	}

	public int getHeroSkillId() {
		return heroSkillId;
	}

	public void setHeroSkillId(int heroSkillId) {
		this.heroSkillId = heroSkillId;
	}

	public int getHeroSkillId1() {
		return heroSkillId1;
	}

	public void setHeroSkillId1(int heroSkillId1) {
		this.heroSkillId1 = heroSkillId1;
	}

	public int getHeroSkillId2() {
		return heroSkillId2;
	}

	public void setHeroSkillId2(int heroSkillId2) {
		this.heroSkillId2 = heroSkillId2;
	}

	public int getHeroSkillId3() {
		return heroSkillId3;
	}

	public void setHeroSkillId3(int heroSkillId3) {
		this.heroSkillId3 = heroSkillId3;
	}

	public int getHeroSkillId4() {
		return heroSkillId4;
	}

	public void setHeroSkillId4(int heroSkillId4) {
		this.heroSkillId4 = heroSkillId4;
	}

	public int getHeroSkillId5() {
		return heroSkillId5;
	}

	public void setHeroSkillId5(int heroSkillId5) {
		this.heroSkillId5 = heroSkillId5;
	}

	public int getHeroSkillId6() {
		return heroSkillId6;
	}

	public void setHeroSkillId6(int heroSkillId6) {
		this.heroSkillId6 = heroSkillId6;
	}

	public int getHangerEntId1() {
		return hangerEntId1;
	}

	public void setHangerEntId1(int hangerEntId1) {
		this.hangerEntId1 = hangerEntId1;
	}

	public int getHangerEntId2() {
		return hangerEntId2;
	}

	public void setHangerEntId2(int hangerEntId2) {
		this.hangerEntId2 = hangerEntId2;
	}

	public int getHangerEntId3() {
		return hangerEntId3;
	}

	public void setHangerEntId3(int hangerEntId3) {
		this.hangerEntId3 = hangerEntId3;
	}

	public int getHangerEntId4() {
		return hangerEntId4;
	}

	public void setHangerEntId4(int hangerEntId4) {
		this.hangerEntId4 = hangerEntId4;
	}

	public int getHangerEntId5() {
		return hangerEntId5;
	}

	public void setHangerEntId5(int hangerEntId5) {
		this.hangerEntId5 = hangerEntId5;
	}

	public String getHeroFate() {
		return heroFate;
	}

	public void setHeroFate(String heroFate) {
		this.heroFate = heroFate;
	}

	public String getEquipFate() {
		return equipFate;
	}

	public void setEquipFate(String equipFate) {
		this.equipFate = equipFate;
	}

	public int getGemId1() {
		return gemId1;
	}

	public void setGemId1(int gemId1) {
		this.gemId1 = gemId1;
	}

	public int getGemExp1() {
		return gemExp1;
	}

	public void setGemExp1(int gemExp1) {
		this.gemExp1 = gemExp1;
	}

	public int getGemId2() {
		return gemId2;
	}

	public void setGemId2(int gemId2) {
		this.gemId2 = gemId2;
	}

	public int getGemExp2() {
		return gemExp2;
	}

	public void setGemExp2(int gemExp2) {
		this.gemExp2 = gemExp2;
	}

	public int getGemId3() {
		return gemId3;
	}

	public void setGemId3(int gemId3) {
		this.gemId3 = gemId3;
	}

	public int getGemExp3() {
		return gemExp3;
	}

	public void setGemExp3(int gemExp3) {
		this.gemExp3 = gemExp3;
	}

	public int getGemId4() {
		return gemId4;
	}

	public void setGemId4(int gemId4) {
		this.gemId4 = gemId4;
	}

	public int getGemExp4() {
		return gemExp4;
	}

	public void setGemExp4(int gemExp4) {
		this.gemExp4 = gemExp4;
	}

	public int getGemId5() {
		return gemId5;
	}

	public void setGemId5(int gemId5) {
		this.gemId5 = gemId5;
	}

	public int getGemExp5() {
		return gemExp5;
	}

	public void setGemExp5(int gemExp5) {
		this.gemExp5 = gemExp5;
	}

	public int getGemId6() {
		return gemId6;
	}

	public void setGemId6(int gemId6) {
		this.gemId6 = gemId6;
	}

	public int getGemExp6() {
		return gemExp6;
	}

	public void setGemExp6(int gemExp6) {
		this.gemExp6 = gemExp6;
	}

	public int getGemId7() {
		return gemId7;
	}

	public void setGemId7(int gemId7) {
		this.gemId7 = gemId7;
	}

	public int getGemExp7() {
		return gemExp7;
	}

	public void setGemExp7(int gemExp7) {
		this.gemExp7 = gemExp7;
	}

	public int getGemId8() {
		return gemId8;
	}

	public void setGemId8(int gemId8) {
		this.gemId8 = gemId8;
	}

	public int getGemExp8() {
		return gemExp8;
	}

	public void setGemExp8(int gemExp8) {
		this.gemExp8 = gemExp8;
	}

	public int getGemId9() {
		return gemId9;
	}

	public void setGemId9(int gemId9) {
		this.gemId9 = gemId9;
	}

	public int getGemExp9() {
		return gemExp9;
	}

	public void setGemExp9(int gemExp9) {
		this.gemExp9 = gemExp9;
	}

	public int getGemType1() {
		return gemType1;
	}

	public void setGemType1(int gemType1) {
		this.gemType1 = gemType1;
	}

	public int getGemType2() {
		return gemType2;
	}

	public void setGemType2(int gemType2) {
		this.gemType2 = gemType2;
	}

	public int getGemType3() {
		return gemType3;
	}

	public void setGemType3(int gemType3) {
		this.gemType3 = gemType3;
	}

	public int getGemType4() {
		return gemType4;
	}

	public void setGemType4(int gemType4) {
		this.gemType4 = gemType4;
	}

	public int getGemType5() {
		return gemType5;
	}

	public void setGemType5(int gemType5) {
		this.gemType5 = gemType5;
	}

	public int getGemType6() {
		return gemType6;
	}

	public void setGemType6(int gemType6) {
		this.gemType6 = gemType6;
	}

	public int getGemType7() {
		return gemType7;
	}

	public void setGemType7(int gemType7) {
		this.gemType7 = gemType7;
	}

	public int getGemType8() {
		return gemType8;
	}

	public void setGemType8(int gemType8) {
		this.gemType8 = gemType8;
	}

	public int getGemType9() {
		return gemType9;
	}

	public void setGemType9(int gemType9) {
		this.gemType9 = gemType9;
	}

	public int getFormationId() {
		return formationId;
	}

	public void setFormationId(int formationId) {
		this.formationId = formationId;
	}
}
