package com.sertac.hackerrank.JavaAnagrams;

import java.util.Scanner;

public class Solution {

	static boolean isAnagram(String a, String b) {
		if (a.length() == b.length()) {

			String aLower = a.toLowerCase();
			String bLower = b.toLowerCase();

			byte[] bBytes = bLower.getBytes();
			java.util.List<Byte> byteList = new java.util.LinkedList<Byte>();
			for (byte bByte : bBytes) {
				byteList.add(bByte);
			}

			for (byte aByte : aLower.getBytes()) {
				int indexOf = byteList.indexOf(new Byte(aByte));
				if (indexOf >= 0) {
					byteList.remove(indexOf);
				} else {
					return false;
				}
			}

			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}
}
