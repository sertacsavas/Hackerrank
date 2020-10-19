package com.sertac.hackerrank.JavaExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.println(a / b);
		} catch (InputMismatchException e) {
			System.out.println(e.getClass().getName());
		} catch (ArithmeticException e) {
			System.out.println(e.getClass().getName() + ": / by zero");
		}
		scan.close();

	}
}