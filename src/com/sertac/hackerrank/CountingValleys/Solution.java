package com.sertac.hackerrank.CountingValleys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

	/*
	 * Complete the 'countingValleys' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER steps 2. STRING path
	 */

	public static int countingValleys(int steps, String path) {

		char[] pathArray = path.toCharArray();

		int currentPosition = 0;
		boolean inValley = false;
		int valleyCount = 0;

		for (int i = 0; i < pathArray.length; i++) {
			currentPosition += (pathArray[i] == 'D' ? -1 : 1);

			if (!inValley && currentPosition < 0) {
				valleyCount++;
			}

			inValley = currentPosition < 0;

		}

		return valleyCount;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int steps = Integer.parseInt(bufferedReader.readLine().trim());

		String path = bufferedReader.readLine();

		int result = Result.countingValleys(steps, path);
		System.out.println(result);
		/*
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		 */

		bufferedReader.close();
		/* bufferedWriter.close(); */
	}
}
