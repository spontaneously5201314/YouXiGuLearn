package com.youxigu.se.help;

/**
 * @Description
 * @author Spontaneously
 * @time 2016年1月15日 下午4:45:58
 */
public class HelpOne {

	public static void main(String[] args) {
		String s = "NM_022552(DNMT3A):c.2645GGF>AT(p.R882H)";
		int length = s.lastIndexOf("(") - s.lastIndexOf(">") - 1;
		int l = s.lastIndexOf(">") - length - 1;
		if (s.charAt(l) >= 'A' && s.charAt(l) <= 'Z') {
			System.out.println(false);
		} else if (s.charAt(l + 1) >= 'A' && s.charAt(l + 1) <= 'Z') {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		// String s = "NM_022552(DNMT3A):c.2645GGF>AT(p.R882H)";
		// int length = s.lastIndexOf("(") - s.lastIndexOf(">") - 1;
		// int l = s.lastIndexOf(">") - length;
		// if (l < 0) {
		// System.out.println(false);
		// } else if (s.charAt(l) >= 'A' && s.charAt(l) <= 'Z') {
		// System.out.println(true);
		// } else {
		// System.out.println(false);
		// }
	}
}
