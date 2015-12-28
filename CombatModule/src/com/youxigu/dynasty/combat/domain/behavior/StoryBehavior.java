package com.youxigu.dynasty.combat.domain.behavior;

/**
 * @Description: 剧情类
 * @author myg
 * @time 2015年12月28日 上午11:45:39
 */
public class StoryBehavior extends AbstractCombatBehavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1546226854909943755L;

	/**
	 * 剧情id
	 */
	protected int storyId;

	public int getStoryId() {
		return storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}
}
