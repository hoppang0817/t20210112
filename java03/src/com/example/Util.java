package com.example;

public class Util {
	public static int sum(int[] arr) {
		int s = 0;
		for(int i=0;i<arr.length;i++) {
			s +=arr[i];
		}
		return s;
	}

	
	
	public static float avg(int[] arr) {
		int s =0;
		for (int i=0;i<arr.length;i++) {
			s +=arr[i];
		}
		return s /(float) arr.length;
	}
}



