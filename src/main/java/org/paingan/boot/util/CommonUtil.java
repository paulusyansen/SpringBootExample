package org.paingan.boot.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtil {
	
	public static boolean nvl(Boolean bo) {
		return bo == null ? false : bo;
	}
	
	public static Date nvl(Date dt) {
		return dt == null ? new Date() : dt;
	}
	
	public static Double nvl(Double db) {
		return db == null ? 0.0 : db;
	}
	
	public static Integer nvl(Integer in) {
		return in == null ? 0 : in;
	}
	
	public static Long nvl(Long lo) {
	    return lo == null ? 0 : lo;
	}
	
	public static String nvl(String st) {
	    return st == null ? "" : st;
	}
	
	public static String toLowCase(String st) {
	    return st == null ? null : st.toLowerCase();
	}
	
	public static String toUpCase(String st) {
	    return st == null ? null : st.toUpperCase();
	}
	
	public static <K, V> Map<K, V> nvl(Map<K, V> map) {
		return map == null ? new HashMap<>() : map;
	}
	
	public static <T> List<T> nvl(List<T> list) {
		return list == null ? new ArrayList<T>() : list;
	}
}
