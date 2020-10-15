package com.sertac.hackerrank.JavaBitSet;

import java.util.BitSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();

		String[] stringArray = s.split(" ");

		BitSet B1 = new BitSet(Integer.parseInt(stringArray[0]));
		BitSet B2 = new BitSet(Integer.parseInt(stringArray[0]));

		for (int i = 0; i < Integer.parseInt(stringArray[1]); i++) {
			String operationString = in.nextLine();
			String[] parsedOperation = operationString.split(" ");

			String operation = parsedOperation[0];
			Integer firstValue = Integer.parseInt(parsedOperation[1]);
			Integer secondValue = Integer.parseInt(parsedOperation[2]);

			switch (operation) {
			case "AND":
				(firstValue == 1 ? B1 : B2).and(secondValue == 1 ? B1 : B2);
				break;
			case "SET":
				(firstValue == 1 ? B1 : B2).set(secondValue);
				break;
			case "FLIP":
				(firstValue == 1 ? B1 : B2).flip(secondValue);
				break;
			case "OR":
				(firstValue == 1 ? B1 : B2).or(secondValue == 1 ? B1 : B2);
				break;
			case "XOR":
				(firstValue == 1 ? B1 : B2).xor(secondValue == 1 ? B1 : B2);
				break;
			default:
				break;
			}

			System.out.println(B1.cardinality() + " " + B2.cardinality());

		}

	}
}