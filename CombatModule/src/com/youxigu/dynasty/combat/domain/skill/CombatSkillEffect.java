package com.youxigu.dynasty.combat.domain.skill;

import java.io.Serializable;
import java.util.List;

import com.youxigu.dynasty.combat.domain.behavior.AbstractCombatBehavior;
import com.youxigu.dynasty.combat.domain.combat.CombatUnit;
import com.youxigu.dynasty.entity.domain.HeroSkillEffect;

/**
* @Description: 战斗中的技能加成，如眩晕等
* @author myg
* @time 2015年12月28日 下午5:38:04
*/
public class CombatSkillEffect implements Serializable {
	private static final long serialVersionUID = 7273786089535246471L;


	// 禁止全部
	public static final String EFF_CONF = "EFF_CONF"; // 混乱效果，参数为生效百分比
	public static final String EFF_BUY = "EFF_BUY"; // 收买，错乱，使战斗单元攻击自己人
	
	public static final String EFF_CLEAR = "EFF_CLEAR"; // 清除混乱效果
	public static final String EFF_FENGYIN = "EFF_FENGYIN"; // 封印效果，效果生效期间，无法施展主动技能

	// ////这两个与7q处理不同,见combatSkill中关于 EFF_DAMAGE_PER EFF_SHIELD_PER的特殊处理
	public static final String EFF_DAMAGE_PER = "EFF_DAMAGE_PER"; // 伤害百分比加成
	public static final String EFF_SHIELD_PER = "EFF_SHIELD_PER"; // 伤害百分比减免

	public static final String EFF_ARMY_MOBILITY = "EFF_SPEED_NUM"; // 兵种的机动力

	public static final String EFF_ATTACK = "EFF_ATTACK"; // 加攻击
	public static final String EFF_DEFENSE = "EFF_DEFENSE"; // 加防御
	public static final String EFF_STRENGTH = "EFF_STRENGTH"; // 加体力
	public static final String EFF_AGILITY = "EFF_AGILITY"; // 加敏捷
	public static final String EFF_CRIT = "EFF_CRIT"; // 加暴击率
	public static final String EFF_DODGE = "EFF_DODGE"; // 加闪避率
	public static final String EFF_HIT = "EFF_HIT"; // 加命中率

	public static final String EFF_POISON_NUM = "EFF_POISON_NUM"; // DOT死兵
	public static final String EFF_AID_NUM = "EFF_AID_NUM"; // 恢复,目前策划配置似乎是非DOT类的

	public static final String EFF_POISON_NUM_CLEAR = "EFF_POISON_NUM_CLEAR"; // 清除DOT死兵
	public static final String EFF_POISON_NUM_LV = "EFF_POISON_NUM_LV"; // 按施放者等级DOT死兵

	public static final String EFF_AID_NUM_D = "EFF_AID_NUM_D"; // 按固定值恢复,DOT类的	
	public static final String EFF_AID_NUM_LV = "EFF_AID_NUM_LV"; // 按施放者等级恢复,DOT类的

	public static final String EFF_HP = "EFF_LIFE_NUM"; // 加HP

	public static final String EFF_COUNTERATK = "EFF_COUNTERATTACK"; // 反击效果
	public static final String EFF_VAMPIRE = "EFF_BLOODSUCK"; // 吸血效果
	public static final String EFF_VAMPIRE2 = "EFF_BLOODSUCK2"; // 吸血效果-2，普通攻击后按给对方产生的伤害增加自己的血量
	public static final String EFF_FANTAN = "EFF_FANTAN"; // 反弹效果
	public static final String EFF_CHENGFANG_NUM = "EFF_CHENGFANG_NUM"; // 改变城防数量效果

	public static final String EFF_MOVE_NUM = "EFF_MOVE_NUM"; // 按数值改变武将所带兵种的移动力（最小改变至0）；
	public static final String EFF_MOBILITY = "EFF_MOBILITY"; // 按数值改变武将所带兵种的机动力；
	public static final String EFF_LIANJI = "EFF_LIANJI"; // 连击逻辑，攻击时发动，对目标进行n次攻击，每次攻击造成普通攻击的百分比伤害
	
	public static final String EFF_MOVEBACK = "EFF_MOVEBACK"; // 击退，将目标的位置放置在敌方的最后一排	
	public static final String EFF_CALLING = "EFF_CALLING"; // 召唤

	public static final String EFF_COLDDOWN_NUM = "EFF_COLDDOWN_NUM"; // 减少技能冷却回合数

	public static final String EFF_HEROEXP = "EFF_HEROEXP"; // 战斗后增加经验的百分比
	public static final String EFF_RESOURCE = "EFF_RESOURCE"; // 战斗后资源+铜币的百分比

	// 特殊技能2,3的效果
	public static final String EFF_SKILLEFF_PER = "EFF_SKILLEFF_PER"; // 增加前置普通技能效果百分比
	public static final String EFF_SKILLEFF_ABS = "EFF_SKILLEFF_ABS"; // 增加前置普通技能效果绝对值
	public static final String EFF_FIRE_PER = "EFF_FIRE_PER"; // 增加技能施放概率
	public static final String EFF_ROUND = "EFF_ROUND"; // 增加技能效果持续回合数


	public static final String EFF_ATTACK_ADD_PER = "EFF_ATTACK_ADD_PER"; // 攻击加成百分比
	public static final String EFF_DEFENSE_ADD_PER = "EFF_DEFENSE_ADD_PER"; // 防御加成成百分比
	public static final String EFF_STRENGTH_ADD_PER = "EFF_STRENGTH_ADD_PER"; // 体力加成成百分比
	public static final String EFF_AGILITY_ADD_PER = "EFF_AGILITY_ADD_PER"; // 敏捷加成成百分比 
	public static final String EFF_ATTACK_DEC_PER = "EFF_ATTACK_DEC_PER"; // 攻击减益百分比
	public static final String EFF_DEFENSE_DEC_PER = "EFF_DEFENSE_DEC_PER"; // 防御减益成百分比
	public static final String EFF_STRENGTH_DEC_PER = "EFF_STRENGTH_DEC_PER"; // 体力减益成百分比
	public static final String EFF_AGILITY_DEC_PER = "EFF_AGILITY_DEC_PER"; // 敏捷减益成百分比
	
	public static final String EFF_DEC_ARMY = "EFF_DEC_ARMY"; // 死兵(最大兵数百分比)
	public static final String EFF_ADD_ARMY = "EFF_ADD_ARMY"; // 加兵(最大兵数百分比)	
	public static final String EFF_ADD_ARMY_F = "EFF_ADD_ARMY_F"; // 根据伤害按计算公式增加兵	
	
	/**
	 * 技能效果定义
	 */
	private HeroSkillEffect effect;

	/**
	 * 技能释放者
	 */
	private CombatUnit owner;

	/**
	 * 技能释放目标
	 */
	private CombatUnit target;

	/**
	 * 技能效果目标
	 */
	private List<CombatUnit> targets;

	private CombatSkill combatSkill;
	/**
	 * 效果产生后的值
	 */
	private int value = 0;

	/**
	 * 有效期：持续到的回合数
	 */
	private int validRound;

	/**
	 * 最后一次触发的回合数
	 */
	private int lastTrigerRound;

	/**
	 * 最后一次render的回合,主要是对dot类有效
	 */
	private int lastRenderRound;
	/**
	 * 效果渲染器
	 */
	private transient ISkillEffectRender render;

	public HeroSkillEffect getEffect() {
		return effect;
	}

	public void setEffect(HeroSkillEffect effect) {
		this.effect = effect;
	}

	public CombatUnit getOwner() {
		return owner;
	}

	public void setOwner(CombatUnit owner) {
		this.owner = owner;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValidRound() {
		return validRound;
	}

	public void setValidRound(int validRound) {
		this.validRound = validRound;
	}

	public int getLastTrigerRound() {
		return lastTrigerRound;
	}

	public void setLastTrigerRound(int lastTrigerRound) {
		this.lastTrigerRound = lastTrigerRound;
	}

	public ISkillEffectRender getRender() {
		return render;
	}

	public void setRender(ISkillEffectRender render) {
		this.render = render;
	}

	public short getEffType() {
		return effect.getEffType();
	}

	public int getEffId() {
		return effect.getEffId();
	}

	public String getEffKey() {
		return effect.getEffKey();
	}

	public List<CombatUnit> getTargets() {
		return targets;
	}

	public void setTargets(List<CombatUnit> targets) {
		this.targets = targets;
	}

	public CombatSkill getCombatSkill() {
		return combatSkill;
	}

	public void setCombatSkill(CombatSkill combatSkill) {
		this.combatSkill = combatSkill;
	}

	public AbstractCombatBehavior doRender(CombatUnit target) {
		int currRound = target.getParent().getParent().getRound();
		if (this.lastRenderRound >= currRound) {
			return null;
		} else {
			this.lastRenderRound = currRound;
			return this.render.applyEffect(this, target);
		}
	}

	public CombatUnit getTarget() {
		return target;
	}

	public void setTarget(CombatUnit target) {
		this.target = target;
	}


}
