package com.youxigu.dynasty.combat.domain.combat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description: 寻路算法
 * @author myg
 * @time 2015年12月30日 下午5:01:57
 */
public class PathFinder {

	private static final int MAXLOOPCOUNT = 4000;

	public static final byte MAP_FLAG_NONE = 0;
	public static final byte MAP_FLAG_ONE = 1;
	public static final byte MAP_FLAG_TWO = 2;
	public static final byte MAP_FLAG_THREE = 3;
	/**
	 * 0表示没有障碍的点 ， 1，2都是障碍点，行走者自身包含1或者2的属性，与自身属性相同的表示可穿过不可停留的点 ,不同表示不可穿越不可停留的点
	 * 3表示不可移动到的点
	 */
	private byte[][] map;

	private Node goal;
	private PriorityQueue<Path> paths;
	private HashMap<Integer, Integer> mindists;
	/*
	 * 目标范围，表示距离目标多少个格子就算到达目标
	 */
	private int goalRange;

	// private int maxStep;// 移动的最大距离

	private byte mapFlag;// 1或者2
	// private double lastCost;
	private int expandedCounter;

	private int xstep = 1;
	private int ystep = 1;

	public PathFinder(byte[][] map) {
		this.map = map;
		paths = new PriorityQueue<Path>();
		mindists = new HashMap<Integer, Integer>();
		expandedCounter = 0;
	}

	public List<Node> getAtkPath(Node start, Node goal, int goalRange, int maxStep, byte mapFlag) {
		Path path = computeAtkPath(start, goal, goalRange, maxStep, mapFlag);
		this.clean();
		if (path != null) {
			return path.getNodes();
		} else {
			return null;
		}
	}

	// 这是为城墙单独做的一个方法，主要是目前寻路，不支持一个目标站多个位置
	public List<Node> getAtkPath(Node start, List<Node> goals, int goalRange, int maxStep, byte mapFlag) {
		Path bestP = null;
		for (Node goal : goals) {
			Path path = computeAtkPath(start, goal, goalRange, maxStep, mapFlag);
			this.clean();
			if (bestP == null) {
				bestP = path;
			} else {
				if (path != null && path.depth < bestP.depth) {
					bestP = path;
				}
			}
		}
		if (bestP != null) {
			return bestP.getNodes();
		} else {
			return null;
		}

	}

	/**
	 * 寻找攻击路线
	 * 
	 * @param start
	 * @param goal
	 * @param goalRange
	 * @param maxStep
	 * @param mapFlag
	 * @return
	 */
	public Path computeAtkPath(Node start, Node goal, int goalRange, int maxStep, byte mapFlag) {
		if (goal != null) {
			this.setGoal(goal);
		}
		if (goalRange > 0) {
			this.goalRange = goalRange;
		}
		// if (maxStep>0){
		// this.maxStep = maxStep;
		// }
		if (mapFlag != MAP_FLAG_ONE && mapFlag != MAP_FLAG_TWO) {
			this.mapFlag = MAP_FLAG_ONE;
		} else {
			this.mapFlag = mapFlag;
		}

		if (start.x > goal.x) {
			xstep = -1;
		} else {
			xstep = 1;
		}

		if (start.y > goal.y) {
			ystep = -1;
		} else {
			ystep = 1;
		}

		try {

			Path root = new Path();
			root.setPoint(start);

			if (isGoal(start) && (map[start.x][start.y] != MAP_FLAG_ONE)) {// 不需要移动，当前点就在目标点范围内
				return root;
			}
			/* Needed if the initial point has a cost. */
			f(root, start, start);

			expand(root);

			for (int j = 0; j < MAXLOOPCOUNT; j++) {
				Path p = paths.poll();

				if (p == null) {
					return null;
				}

				if (p.f < 0) {// 该路径不可达，必然有敌方阻挡，则有更合适的目标，放弃当前目标
					continue;
				}

				Node last = p.getPoint();

				if (isGoal(last)) {
					// 停留点不是友军已经停留位置
					if (map[last.x][last.y] == MAP_FLAG_NONE) {
						return p;
					}
				}
				if (p.depth < maxStep) {// 超过最大步数
					expand(p);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// if (log.isDebugEnabled()){
			// log.debug("尝试的节点数:{}"+this.getExpandedCounter());
			// }
		}
		return null;

	}

	/**
	 * 
	 * 移动目标未必可达，只是找可移动到的离目标最近的点
	 * 
	 * @param start
	 * @param goal
	 * @param goalRange
	 *            目标周围goalRange-1格都作为目标
	 * @param maxStep
	 *            移动步数超过maxStep的忽略
	 * @param mapFlag
	 * @return
	 */
	public List<Node> getMovePath(Node start, Node goal, int goalRange, int maxStep, byte mapFlag) {
		Path path = computeMovePath(start, goal, goalRange, maxStep, mapFlag);
		this.clean();
		if (path != null) {
			return path.getNodes();
		} else {
			return null;
		}
	}

	// 这是为城墙单独做的一个方法，主要是目前寻路，不支持一个目标站多个位置
	public List<Node> getMovePath(Node start, List<Node> goals, int goalRange, int maxStep, byte mapFlag) {
		Path bestP = null;
		for (Node goal : goals) {
			Path path = computeMovePath(start, goal, goalRange, maxStep, mapFlag);
			this.clean();
			if (bestP == null) {
				bestP = path;
			} else {
				if (path != null && path.depth < bestP.depth) {
					bestP = path;
				}
			}
		}
		if (bestP != null) {
			return bestP.getNodes();
		} else {
			return null;
		}

	}

	public Path computeMovePath(Node start, Node goal, int goalRange, int maxStep, byte mapFlag) {

		Path bestPath = null;// 最佳路径

		if (goal != null) {
			this.setGoal(goal);
		}
		if (goalRange > 0) {
			this.goalRange = goalRange;
		}
		// if (maxStep>0){
		// this.maxStep = maxStep;
		// }
		if (mapFlag != MAP_FLAG_ONE && mapFlag != MAP_FLAG_TWO) {
			this.mapFlag = MAP_FLAG_ONE;
		} else {
			this.mapFlag = mapFlag;
		}

		if (start.x > goal.x) {
			xstep = -1;
		} else {
			xstep = 1;
		}

		if (start.y > goal.y) {
			ystep = -1;
		} else {
			ystep = 1;
		}

		try {

			Path root = new Path();
			root.setPoint(start);

			if (isGoal(start) && (map[start.x][start.y] != MAP_FLAG_ONE)) {// 不需要移动，当前点就在目标点范围内
				return root;
			}
			/* Needed if the initial point has a cost. */
			f(root, start, start);

			expand(root);
			int j = 0;
			for (j = 0; j < MAXLOOPCOUNT; j++) {
				Path p = paths.poll();

				if (p == null) {
					// System.out.println("=========is null=================");
					break;
				}

				if (p.f < 0) {// 该路径不可达，必然有敌方阻挡，则有更合适的目标，放弃当前目标
					continue;
				}

				if (p.depth == maxStep) {
					// 如果前maxstep都不能站立，则放弃该路径
					boolean valid = false;
					for (Path i = p; i != null && i.parent != null; i = i.parent) {
						if (i.depth <= maxStep) {
							Node tmp = i.getPoint();
							if (map[tmp.x][tmp.y] == MAP_FLAG_NONE) {
								valid = true;
								break;
							}
						}
					}

					if (!valid) {
						continue;
					}
				}

				Node last = p.getPoint();
				// 是目标，并且不是友军站住的位置
				if (isGoal(last) && map[last.x][last.y] != MAP_FLAG_ONE) {
					if (map[last.x][last.y] == MAP_FLAG_NONE) {
						for (Path i = p; i != null && i.parent != null; i = i.parent) {
							if (i.depth <= maxStep) {
								Node tmp = i.getPoint();
								if (map[tmp.x][tmp.y] == MAP_FLAG_NONE) {
									return i;// 只返回能走的最大步数
								}
							}
						}

					}
				}

				// 保留不可达路径中与目标点最近的路径
				if (map[last.x][last.y] == MAP_FLAG_NONE) {
					if (bestPath == null) {
						bestPath = p;
					} else if (p.depth <= maxStep) {
						Node bestNode = bestPath.getPoint();
						if (Math.abs(last.x - goal.x) + Math.abs(last.y - goal.y) < Math.abs(bestNode.x - goal.x)
								+ Math.abs(bestNode.y - goal.y)) {
							bestPath = p;
						}
					}
				}
				expand(p);

			}
			// System.out.println("=========================="+j);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// if (log.isDebugEnabled()){
			// log.debug("尝试的节点数:{}"+this.getExpandedCounter());
			// }
		}

		return bestPath;

	}

	public int getExpandedCounter() {
		return expandedCounter;
	}

	protected int g(Node from, Node to) {

		if (from.x == to.x && from.y == to.y)
			return 0;
		if (map[to.x][to.y] == MAP_FLAG_NONE || map[to.x][to.y] == mapFlag)
			return 1;
		if (isGoal(to))
			return 1;

		return Integer.MIN_VALUE;// 敌方阻挡位置，设置为负值，表示不可到达
	}

	protected int h(Node from, Node to) {
		/* Use the Manhattan distance heuristic. */
		// return new Double(Math.abs(map[0].length - 1 - to.x)
		// + Math.abs(map.length - 1 - to.y));
		return Math.abs(goal.x - to.x) + Math.abs(goal.y - to.y);
	}

	protected int f(Path p, Node from, Node to) {
		int g = g(from, to) + ((p.parent != null) ? p.parent.g : 0);
		int h = h(from, to);

		p.g = g;
		p.f = g + h;

		return p.f;
	}

	private void expand(Path path) {
		Node p = path.getPoint();
		Integer min = mindists.get(path.getPoint().hashCode());

		/*
		 * If a better path passing for this point already exists then don't
		 * expand it.
		 */
		if (min == null || min.intValue() > path.f)
			mindists.put(path.getPoint().hashCode(), path.f);
		else
			return;

		List<Node> successors = generateSuccessors(p);

		for (Node t : successors) {
			if (!mindists.containsKey(t.hashCode())) {
				Path newPath = new Path(path);
				newPath.setPoint(t);
				f(newPath, path.getPoint(), t);
				// System.out.println(newPath.toString());
				paths.offer(newPath);
			}
		}

		expandedCounter++;
	}

	protected Node getGoal() {
		return this.goal;
	}

	protected void setGoal(Node node) {
		this.goal = node;

	}

	protected boolean isGoal(Node node) {
		if (goalRange <= 0) {
			return (node.x == goal.x) && (node.y == goal.y);
		} else {
			return (Math.abs(goal.x - node.x) + Math.abs(goal.y - node.y) <= goalRange);
		}
	}

	protected boolean isGoal(int x, int y) {
		if (goalRange <= 0) {
			return (x == goal.x) && (y == goal.y);
		} else {
			return (Math.abs(goal.x - x) + Math.abs(goal.y - y) <= goalRange);
		}
	}

	protected boolean isBarrier(int x, int y) {
		return (map[x][y] != MAP_FLAG_NONE && map[x][y] != mapFlag);
	}

	protected List<Node> generateSuccessors(Node node) {
		List<Node> ret = new LinkedList<Node>();
		int x = node.x;
		int y = node.y;

		// 先遍历X
		int tmp = x + xstep;
		if (tmp < map.length && tmp >= 0 && !isBarrier(tmp, y))
			ret.add(new Node(tmp, y));

		tmp = y + ystep;
		if (tmp < map[0].length && tmp >= 0 && !isBarrier(x, tmp))
			ret.add(new Node(x, tmp));

		tmp = y - ystep;
		if (tmp < map[0].length && tmp >= 0 && !isBarrier(x, tmp))
			ret.add(new Node(x, tmp));

		tmp = x - xstep;
		if (tmp < map.length && tmp >= 0 && !isBarrier(tmp, y))
			ret.add(new Node(tmp, y));

		return ret;
	}

	public static class Node {
		public int x;
		public int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "(" + x + ", " + y + ") ";
		}

		public int hashCode() {
			// 这里假设x,y都在1000000之内
			return x * 1000000 + y;
		}

	}

	public class Path implements Comparable {
		public Node point;
		public int f;
		public int g;
		public int depth;// 路径的长度
		public Path parent;

		/**
		 * Default c'tor.
		 */
		public Path() {
		}

		/**
		 * C'tor by copy another object.
		 * 
		 * @param p
		 *            The path object to clone.
		 */
		public Path(Path p) {
			// this();
			parent = p;
			g = p.g;
			f = p.f;
			depth = p.depth + 1;
		}

		/**
		 * Compare to another object using the total cost f.
		 * 
		 * @param o
		 *            The object to compare to.
		 * @see Comparable#compareTo()
		 * @return <code>less than 0</code> This object is smaller than
		 *         <code>0</code>; <code>0</code> Object are the same.
		 *         <code>bigger than 0</code> This object is bigger than o.
		 */
		public int compareTo(Object o) {
			Path p = (Path) o;
			return (f < p.f) ? -1 : (f == p.f ? 1 : 2);
		}
		/**
		 * Get the last point on the path.
		 * 
		 * @return The last point visited by the path.
		 */
		public Node getPoint() {
			return point;
		}
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(point.toString());
			Path pa = this.parent;
			while (pa != null) {
				sb.append("<-");
				sb.append(pa.point.toString());
				pa = pa.parent;
			}
			return sb.toString();
		}
		public void setPoint(Node p) {
			point = p;
		}
		public List<Node> getNodes() {
			LinkedList<Node> retPath = new LinkedList<Node>();
			// 去头
			for (Path i = this; i != null && i.parent != null; i = i.parent) {
				retPath.addFirst(i.getPoint());
			}
			return retPath;
		}
	}

	public static void main(String[] args) {
		byte[][] map = new byte[10][3];
		System.out.println("Find a path from the top left corner to the right bottom one.");
		List<Node> nodes = null;
		map[6][1] = 1;
		map[5][1] = 1;
		map[5][2] = 1;
		map[7][1] = 2;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
		long begin = System.currentTimeMillis();
		PathFinder pf = new PathFinder(map);
		nodes = pf.getAtkPath(new PathFinder.Node(5, 2), new PathFinder.Node(7, 1), 1, 2, (byte) 1);
		long end = System.currentTimeMillis();
		System.out.println("Time = " + (end - begin) + " ms");
		if (nodes == null)
			System.out.println("No path");
		else {
			System.out.print("Path = ");
			for (Node n : nodes)
				System.out.print(n);
			System.out.println();
		}
	}

	public void clean() {
		paths.clear();
		mindists.clear();
		expandedCounter = 0;
	}
}
