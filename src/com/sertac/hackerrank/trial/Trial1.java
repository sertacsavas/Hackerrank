package com.sertac.hackerrank.trial;

import java.math.BigInteger;

class Book {
	void method() {
		System.out.println("Book");
	}
}

class Novel extends Book {

	@Override
	void method() {
		System.out.println("Novel");
	}
}

public class Trial1 {

	private static BigInteger factorial(BigInteger a) {
		if (a.compareTo(BigInteger.ONE) <= 0) {
			return BigInteger.ONE;
		}
		return a.multiply(factorial(a.subtract(BigInteger.ONE)));
	}

	public static void main(String[] args) {
		// System.out.println(factorial(new BigInteger("5001")));

		int[] values = new int[10];
		for (int i = 0; i < 10; ++i) {
			values[i] = i;
		}
		System.out.println(values[3]);

		int a = -3;
		System.out.println(a);

		String s1 = "asd";
		String s2 = s1;

		s1 = "qwe";

		System.out.println(s1);
		System.out.println(s2);

		Novel n = new Novel();
		n.method();

		Book b = new Novel();
		b.method();

		Book c = new Book();
		c.method();

		// Integer i = new Integer(null);

//		System.out.println(i);

		System.out.println(Math.log(125) / Math.log(5));
		System.out.println(Math.log(27) / Math.log(3));

		long d = 125;
		long e = 5;

		int opPow = 0;

		while (d >= e) {
			d /= e;
			opPow++;
		}

		System.out.println(opPow);

		for (int i = 0; i < 0; i++) {
			System.out.println("asd");
		}
	}

}
