package com.sertac.hackerrank.JavaSingletonPattern;

class Singleton {

	private static Singleton s;
	public String str;

	private Singleton() {
	}

	public static Singleton getSingleInstance() {
		if (s == null) {
			s = new Singleton();
		}
		return s;
	}

}