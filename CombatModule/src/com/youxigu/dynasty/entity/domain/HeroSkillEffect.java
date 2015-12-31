package com.youxigu.dynasty.entity.domain;

import java.io.Serializable;

/**
* @Description: 武将技能效果类
* @author myg
* @time 2015年12月31日 下午2:39:51
*/
public class HeroSkillEffect implements Serializable {
	private static final long serialVersionUID = 7978614821595148866L;
	public static final short EFF_TYPE_GEN = 0;
	public static final short EFF_TYPE_CONTROLBUF = 1;// 控制类BUF
	public static final short EFF_TYPE_BUF = 2;
	public static final short EFF_TYPE_DOT = 4;
	/**
	 * 效果ID
	 */
	private int effId;

	private String effPic;

	/**
	 * 组ID,组内的效果互斥，按priority来决定.不同组的同时存在，即使效果Key相同。通常是BUF类，DOT类有效，普通类不考虑吧.
	 */
	private int groupId;
	/**
	 * 同一组内的优先级，值越大则优先级越高 同一组内优先级不能相同
	 */
	private int priority;

	/**
	 * 效果类型： 0:<br>
	 * 普通类: 技能执行后直接生效，修改直接修改某个属性值，<br>
	 * 属于非DOT攻击技能，非DOT类治疗技能<br>
	 * 1/2:<BR>
	 * BUF/DEBUF类:对某个属性的增益/减益技能，n个回合后失效，<br>
	 * 在失效之前所有与该属性相关的计算都增益/减益,<br>
	 * 控制类机能属于BUF/DEBUF技能<br>
	 * 其中1为控制类BUFF,通常参数表示生效的概率 <br>
	 * 4:<br>
	 * DOT类:DOT攻击技能，DOT类治疗技能,施放后即时生效一次，<br>
	 * 以后每回合根据生效时间点每回合生效一次<br>
	 * DOT类的效果，相当于在持续的回合内，每回合发动一次<br>
	 */
	private short effType;

	/**
	 * 目标属性
	 * 这个Key实际上只对BUF/DEBUF有效， 另外两类的处理不需要这个
	 */
	private String effKey;

	/**
	 * 系数1, 参数1—正常值 军师技则是技能效果系数 10
	 */
	private int para1;
	/**
	 * 参数2 --地形减益后的值 军师技则是技能效果附加值,， 对于特殊技能表示 目标兵种类型，按位表示，可叠加 1步兵（盾） 2 弓兵（弓） 4
	 * 骑兵（剑） 8 车兵（枪） 16 策士（策
	 */
	private int para2;
	/**
	 * 参数3 --地形增益后的值 军师技：对于论语，搜刮，则为默认百分比，其他=0 对于特殊技能 无效
	 */
	private int para3;

	/**
	 * 系数4:--普通技能有效 =1 此普通技能效果受特殊技能2/3影响 =0此普通技能效果不受特殊技能2/3影响
	 */
	private int para4;
	/**
	 * 技能效果持续回合数
	 */
	private int round;

	private transient String effTypeStr;

	public int getEffId() {
		return effId;
	}

	public void setEffId(int effId) {
		this.effId = effId;
	}

	public String getEffPic() {
		return effPic;
	}

	public void setEffPic(String effPic) {
		this.effPic = effPic;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public short getEffType() {
		return effType;
	}

	public void setEffType(short effType) {
		this.effType = effType;
	}

	public String getEffKey() {
		return effKey;
	}

	public void setEffKey(String effKey) {
		this.effKey = effKey;
	}

	public int getPara1() {
		return para1;
	}

	public void setPara1(int para1) {
		this.para1 = para1;
	}

	public int getPara2() {
		return para2;
	}

	public void setPara2(int para2) {
		this.para2 = para2;
	}

	public int getPara3() {
		return para3;
	}

	public void setPara3(int para3) {
		this.para3 = para3;
	}

	public int getPara4() {
		return para4;
	}

	public void setPara4(int para4) {
		this.para4 = para4;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public String getEffTypeStr() {
		return effTypeStr;
	}

	public void setEffTypeStr(String effTypeStr) {
		this.effTypeStr = effTypeStr;
	}
}
