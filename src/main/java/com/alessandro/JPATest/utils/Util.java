package com.alessandro.JPATest.utils;

import java.util.ArrayList;

public class Util {
	public static String prettifyIntegerArrayList(ArrayList<Integer> al) {
		String res = "";
		
		for(Integer i: al) {
			res += i.toString() + ", ";
		}
		
		return res;
	}
}
