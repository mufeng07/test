package com.mufeng.utils;

public class AmountConvert {

	private static final String UNIT = "万千佰拾亿千佰拾万千佰拾元角分";
	private static final String DIGIT = "零壹贰叁肆伍陆柒捌玖";
	private static final double MAX_VALUE = 9999999999999.99D;

	public static void main(String[] args) {
		System.out.println(change(0.01));
		System.out.println(change(5.36));
		System.out.println(change(100.00));
		System.out.println(change(8.80));
		System.out.println(change(1000000));
	}

	public static String change(double v) {
		if (v < 0 || v > MAX_VALUE) {
			return "参数非法!";
		}
		long l = Math.round(v * 100);
		if (l == 0) {
			return "零元整";
		}
		String strValue = l + "";
		// i用来控制数
		int i = 0;
		// j用来控制单位
		int j = UNIT.length() - strValue.length();
		StringBuilder rs = new StringBuilder();
		boolean isZero = false;
		for (; i < strValue.length(); i++, j++) {
			char ch = strValue.charAt(i);
			if (ch == '0') {
				isZero = true;
				if (UNIT.charAt(j) == '亿' || UNIT.charAt(j) == '万' || UNIT.charAt(j) == '元') {
					rs.append(UNIT.charAt(j));
					isZero = false;
				}
			} else {
				if (isZero) {
					rs.append("零");
					isZero = false;
				}
				rs.append(DIGIT.charAt(ch - '0')).append(UNIT.charAt(j));
			}
		}
		String result = rs.toString();
		if (!result.endsWith("分")) {
			result = result + "整";
		}
		result = result.replaceAll("亿万", "亿");
		return result;
	}

}
