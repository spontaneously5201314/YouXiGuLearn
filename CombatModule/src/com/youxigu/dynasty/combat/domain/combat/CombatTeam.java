package com.youxigu.dynasty.combat.domain.combat;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.youxigu.dynasty.guild.Guild;
import com.youxigu.dynasty.hero.domain.Formation;
import com.youxigu.dynasty.util.EffectValue;

/**
* @Description: 战斗团队
* @author myg
* @time 2015年12月25日 上午11:01:19
*/
public class CombatTeam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3106651141328795828L;

	/**
	 * 所属的用户ID或者NPC ID,对于NPC.userId=casId
	 */
	private long userId;

	/**
	 * 玩家城池ID或者NPC ID
	 */
	private long casId;

	/**
	 * 玩家或者npc的等级
	 */
	private int level;

	/**
	 * 团队名称,通常是玩家名称或者NPC名称
	 */
	private String teamName;

	/**
	 * 联盟
	 */
	private transient Guild guild;
	/**
	 * 联盟名称
	 */
	private String guildName;

	/**
	 * 玩家图标或者NPC图标
	 */
	private String icon;

	private short teamType;

	/**
	 * 战斗力
	 */
	private int teamPower;

	/**
	 * 当前战斗力：这里是为了计算战斗结束后显示的战斗力
	 */
	// private int currentPower;
	/**
	 * 战斗单元
	 */
	private List<CombatUnit> units;

	/**
	 * 所属的战斗
	 */
	private transient Combat parent;

	/**
	 * 战斗结果分数
	 */
	private short score;

	/**
	 * 初始统帅
	 */
	private int initLead = -1;
	/**
	 * 初始兵力
	 */
	private int initArmyNum = -1;
	/**
	 * 战斗完成后剩余兵力
	 */
	private int remainArmyNum = -1;

	private int fId;// 阵法ID;
	/**
	 * 保存一些其他需要的信息
	 * 
	 */
	
	private int buf;//武将等级差产生的buf.
	
	private transient Object params;

	private transient Formation formation;// 阵法

	// 战斗部队所在的默认地形：会被战场所在地形覆盖
	// TODO：地形实际上不应该与CombatTeam关联，只应该与combat对象关联。
	private int terrian;

	/**
	 * 本放军师的针对敌方阵形的效果 这里设置这个属性是为了跨服战，没法在构造combat的时候取到这个数据
	 */
	private Map<String, EffectValue> adviserEff;
	private transient long troopId;// 军团Id
	private transient String troopName;// 军团名称
	/*
	 * 战斗队伍本身所带的加成：例如君主官职的加成
	 */
	private transient Map<String, EffectValue> effects;
	
	//重楼战神buf，
	private int tempBuf;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCasId() {
		return casId;
	}

	public void setCasId(long casId) {
		this.casId = casId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Guild getGuild() {
		return guild;
	}

	public void setGuild(Guild guild) {
		this.guild = guild;
	}

	public String getGuildName() {
		return guildName;
	}

	public void setGuildName(String guildName) {
		this.guildName = guildName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public short getTeamType() {
		return teamType;
	}

	public void setTeamType(short teamType) {
		this.teamType = teamType;
	}

	public int getTeamPower() {
		return teamPower;
	}

	public void setTeamPower(int teamPower) {
		this.teamPower = teamPower;
	}

	public List<CombatUnit> getUnits() {
		return units;
	}

	public void setUnits(List<CombatUnit> units) {
		this.units = units;
	}

	public Combat getParent() {
		return parent;
	}

	public void setParent(Combat parent) {
		this.parent = parent;
	}

	public short getScore() {
		return score;
	}

	public void setScore(short score) {
		this.score = score;
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

	public int getRemainArmyNum() {
		return remainArmyNum;
	}

	public void setRemainArmyNum(int remainArmyNum) {
		this.remainArmyNum = remainArmyNum;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public int getBuf() {
		return buf;
	}

	public void setBuf(int buf) {
		this.buf = buf;
	}

	public Object getParams() {
		return params;
	}

	public void setParams(Object params) {
		this.params = params;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public int getTerrian() {
		return terrian;
	}

	public void setTerrian(int terrian) {
		this.terrian = terrian;
	}

	public Map<String, EffectValue> getAdviserEff() {
		return adviserEff;
	}

	public void setAdviserEff(Map<String, EffectValue> adviserEff) {
		this.adviserEff = adviserEff;
	}

	public long getTroopId() {
		return troopId;
	}

	public void setTroopId(long troopId) {
		this.troopId = troopId;
	}

	public String getTroopName() {
		return troopName;
	}

	public void setTroopName(String troopName) {
		this.troopName = troopName;
	}

	public Map<String, EffectValue> getEffects() {
		return effects;
	}

	public void setEffects(Map<String, EffectValue> effects) {
		this.effects = effects;
	}

	public int getTempBuf() {
		return tempBuf;
	}

	public void setTempBuf(int tempBuf) {
		this.tempBuf = tempBuf;
	}
	
	/**
	 * 获得本方军团对方的军团
	 * @return
	 */
	public CombatTeam getEnemyTeam(){
		CombatTeam attackerTeam = this.getParent().getAttackerTeam();
		if(this == attackerTeam){
			return this.getParent().getDefenderTeam();
		}
		return attackerTeam;
	}
}
