package com.sertac.hackerrank.FrequencyQueries;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
	static HashMap<Integer, Integer> mapValue = new HashMap<Integer, Integer>();
	static HashMap<Integer, HashSet<Integer>> mapFrequency = new HashMap<Integer, HashSet<Integer>>();

	private static void handleAddRemove(Integer value, boolean isAdd) {
		Integer inMapFrequency = mapValue.get(value);
		Integer newMapFrequency = inMapFrequency == null ? 0 : inMapFrequency;
		if (isAdd) {
			newMapFrequency += 1;
		} else {
			newMapFrequency -= 1;
		}

		if ((isAdd) || (!isAdd && inMapFrequency != null && inMapFrequency > 0)) {
			mapValue.put(value, newMapFrequency);

			HashSet<Integer> mapFrequencyValues = mapFrequency.get(newMapFrequency);
			if (mapFrequencyValues != null) {
				mapFrequencyValues.add(value);
			} else {
				HashSet<Integer> newSet = new HashSet<Integer>();
				newSet.add(value);
				mapFrequency.put(newMapFrequency, newSet);
			}

			HashSet<Integer> oldMapFrequencyValues = mapFrequency.get(inMapFrequency);
			if (oldMapFrequencyValues != null) {
				oldMapFrequencyValues.remove(value);
			}
		}
	}

	// Complete the freqQuery function below.
	static List<Integer> freqQuery(List<List<Integer>> queries) {

		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < queries.size(); i++) {
			List<Integer> query = queries.get(i);
			Integer operation = query.get(0);
			Integer value = query.get(1);

			if (operation == 1) {

				handleAddRemove(value, true);

			} else if (operation == 2) {
				handleAddRemove(value, false);

			} else if (operation == 3) {
				HashSet<Integer> set = mapFrequency.get(value);
				result.add(set != null && set.size() > 0 ? 1 : 0);
			}

		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> queries = new ArrayList<>();

		for (int i = 0; i < q; i++) {
			String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			List<Integer> queriesRowItems = new ArrayList<>();

			for (int j = 0; j < 2; j++) {
				int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
				queriesRowItems.add(queriesItem);
			}

			queries.add(queriesRowItems);
		}

		List<Integer> ans = freqQuery(queries);

		for (int i = 0; i < ans.size(); i++) {
			bufferedWriter.write(String.valueOf(ans.get(i)));

			if (i != ans.size() - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
