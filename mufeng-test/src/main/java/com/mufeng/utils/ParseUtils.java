package com.mufeng.utils;

import java.math.BigDecimal;
import java.util.Map;

public class ParseUtils {

	public static boolean parseBoolean(Object data, boolean def) {
		if (data != null) {
			try {
				return (data instanceof Boolean) ? (Boolean) data : Boolean.valueOf(data.toString());
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
		return def;
	}

	public static boolean parseBoolean(Object data) {
		return parseBoolean(data, false);
	}

	public static int parseInt(Object data, int def) {
		if (data != null) {
			try {
				return (data instanceof Integer) ? ((Integer) data).intValue() : Integer.valueOf(String.valueOf(data));
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
		return def;
	}

	public static int parseInt(Object data) {
		return parseInt(data, 0);
	}

	public static BigDecimal parseBigDecimal(Object data) {
		try {
			return MathUtils.roundHalfUp(new BigDecimal(data.toString()));
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static long parseLong(Object data, long def) {
		if (data != null) {
			try {
				return (data instanceof Long) ? ((Long) data).longValue() : Long.valueOf(String.valueOf(data));
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
		return def;
	}

	public static long parseLong(Object data) {
		return parseLong(data, 0);
	}

	public static double parseDouble(Object data, double def) {
		if (data != null) {
			try {
				double value = def;
				if (data instanceof BigDecimal) {
					value = ((BigDecimal) data).doubleValue();
				} else if (data instanceof Double) {
					value = ((Double) data).doubleValue();
				} else {
					value = Double.valueOf(String.valueOf(data));
				}
				return value == 0 ? 0 : MathUtils.roundHalfUp(value).doubleValue();
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
		return def;
	}

	public static double parseDouble(Object data) {
		return parseDouble(data, 0);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getMapValue(Map<String, ?> dataMap, String key) {
		Object value = dataMap.get(key);
		return value == null ? null : (T) value;
	}

	public static <T> T getArrayValue(T[] t, int index) {
		if (t != null) {
			try {
				return t[index];
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
		return null;
	}
}
