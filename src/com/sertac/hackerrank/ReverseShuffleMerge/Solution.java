package com.sertac.hackerrank.ReverseShuffleMerge;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the reverseShuffleMerge function below.
	static String reverseShuffleMerge(String s) {

//		char[] arr = s.toCharArray();
//
//		List<String> resultList = new ArrayList<String>();
//
//		Map<Character, Long> frequency = s.chars().mapToObj(c -> (char) c)
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//		SortedMap<Character, Long> required = new TreeMap<Character, Long>();
//		Iterator<Entry<Character, Long>> it = frequency.entrySet().iterator();
//
//		while (it.hasNext()) {
//			Map.Entry<Character, Long> pair = it.next();
//			required.put(pair.getKey(), pair.getValue() / 2);
//		}
//
//		int wordLength = arr.length / 2;
//
//		for (int i = arr.length - 1; i >= wordLength - 1; i--) {
//			StringBuilder sB = new StringBuilder();
//			Map<Character, Long> tempFrequency = new HashMap<Character, Long>(frequency);
//			// System.out.println(s.substring(i - worldLength + 1, i + 1));
//			boolean isValid = true;
//			for (int j = 0; j < wordLength; j++) {
//				Long value = tempFrequency.get(arr[i - j]);
//				if (value == null || value < 2) {
//					isValid = false;
//					break;
//				} else {
//					tempFrequency.put(arr[i - j], value - 2);
//				}
//				sB.append(arr[i - j]);
//			}
//			if (isValid) {
//				resultList.add(sB.toString());
//			}
//			// System.out.println(sB.toString());
//			// System.out.println("---");
//		}
//		Collections.sort(resultList);

		return "?";// resultList.get(0);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		String result = reverseShuffleMerge(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
