package com.vinlen.qz.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串常用处理工具类
 */


public class Strings {
	private static Pattern linePattern = Pattern.compile("_(\\w)");
	private static Pattern humpPattern = Pattern.compile("[A-Z]");

	/**
	 * 蛇形转驼峰
	 *
	 * @param str 需要转换的字符串
	 * @return 转换结果
	 */
	public static String line2Hump(String str) {
		str = str.toLowerCase();
		Matcher matcher = linePattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);
		return upperFirst(sb.toString());
	}

	/**
	 * 驼峰转蛇形
	 *
	 * @param str 待转换字符串
	 * @return 转换结果
	 */
	public static String hump2Line(String str) {
		str = lowerFirst(str);
		Matcher matcher = humpPattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 将字符串首字母小写
	 *
	 * @param s 字符串
	 * @return 首字母小写后的新字符串
	 */
	private static String lowerFirst(CharSequence s) {
		if (null == s)
			return null;
		int len = s.length();
		if (len == 0)
			return "";
		char c = s.charAt(0);
		if (Character.isLowerCase(c))
			return s.toString();
		return String.valueOf(Character.toLowerCase(c)) +
				s.subSequence(1, len);
	}


	/**
	 * 将字符串首字母大写
	 *
	 * @param s 字符串
	 * @return 首字母大写后的新字符串
	 */
	private static String upperFirst(CharSequence s) {
		if (null == s)
			return null;
		int len = s.length();
		if (len == 0)
			return "";
		char c = s.charAt(0);
		if (Character.isUpperCase(c))
			return s.toString();
		return String.valueOf(Character.toUpperCase(c)) +
				s.subSequence(1, len);
	}

	/**
	 * 检查两个字符串的忽略大小写后是否相等.
	 *
	 * @param s1 字符串A
	 * @param s2 字符串B
	 * @return true 如果两个字符串忽略大小写后相等,且两个字符串均不为null
	 */
	public static boolean equalsIgnoreCase(String s1, String s2) {
		return s1 == null ? s2 == null : s1.equalsIgnoreCase(s2);
	}

	/**
	 * 检查两个字符串是否相等.
	 *
	 * @param s1 字符串A
	 * @param s2 字符串B
	 * @return true 如果两个字符串相等,且两个字符串均不为null
	 */
	public static boolean equals(String s1, String s2) {
		return s1 == null ? s2 == null : s1.equals(s2);
	}

	/**
	 * 判断字符串是否以特殊字符开头
	 *
	 * @param s 字符串
	 * @param c 特殊字符
	 * @return 是否以特殊字符开头
	 */
	public static boolean startsWithChar(String s, char c) {
		return null != s && (s.length() != 0 && s.charAt(0) == c);
	}

	/**
	 * 判断字符串是否以特殊字符结尾
	 *
	 * @param s 字符串
	 * @param c 特殊字符
	 * @return 是否以特殊字符结尾
	 */
	public static boolean endsWithChar(String s, char c) {
		return null != s && (s.length() != 0 && s.charAt(s.length() - 1) == c);
	}

	/**
	 * 如果此字符串为 null 或者为空串（""），则返回 true
	 *
	 * @param cs 字符串
	 * @return 如果此字符串为 null 或者为空，则返回 true
	 */
	public static boolean isEmpty(CharSequence cs) {
		return null == cs || cs.length() == 0;
	}

	/*
	 * 将数组输出，并按指定符号分割
	 *
	 * @param objects 数组
	 * @param c 分隔符
	 * @return 拼接完成的字符串
	 */
	public static <T> String join(T[] objects, String c) {
		StringBuilder sb = new StringBuilder();
		if (objects == null || objects.length == 0) {
			return sb.toString();
		}
		sb.append(objects[0]);
		for (int i = 1; i < objects.length; i++) {
			sb.append(c).append(objects[i]);
		}
		return sb.toString();
	}

	/*
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 */
}
