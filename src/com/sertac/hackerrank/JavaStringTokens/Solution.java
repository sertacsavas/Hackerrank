package com.sertac.hackerrank.JavaStringTokens;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		// Write your code here.
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				index = i;
				break;
			}
		}

		String[] sArray = s.substring(index).split("[ !,?._'@]+");

		System.out.println(sArray.length);
		for (String string : sArray) {
			System.out.println(string);
		}

		scan.close();
	}
}
