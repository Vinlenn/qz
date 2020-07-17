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
	public static String lowerFirst(CharSequence s) {
		if (null == s)
			return null;
		int len = s.length();
		if (len == 0)
			return "";
		char c = s.charAt(0);
		if (Character.isLowerCase(c))
			return s.toString();
		return new StringBuilder(len).append(Character.toLowerCase(c))
				.append(s.subSequence(1, len))
				.toString();
	}


	/**
	 * 将字符串首字母大写
	 *
	 * @param s 字符串
	 * @return 首字母大写后的新字符串
	 */
	public static String upperFirst(CharSequence s) {
		if (null == s)
			return null;
		int len = s.length();
		if (len == 0)
			return "";
		char c = s.charAt(0);
		if (Character.isUpperCase(c))
			return s.toString();
		return new StringBuilder(len).append(Character.toUpperCase(c))
				.append(s.subSequence(1, len))
				.toString();
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
