package com.sertac.hackerrank.JavaSHA256;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] digestByte = messageDigest.digest(string.getBytes());

		BigInteger bigInteger = new BigInteger(1, digestByte);

		System.out.println(String.format("%64s", bigInteger.toString(16)).replace(" ", "0"));

	}
}