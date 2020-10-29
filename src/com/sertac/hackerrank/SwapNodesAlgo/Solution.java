package com.sertac.hackerrank.SwapNodesAlgo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//class Tree {
//	private Child root;
//
//	public Child getRoot() {
//		return root;
//	}
//
//	public void setRoot(Child root) {
//		this.root = root;
//	}
//}
//
//class Child {
//	private Child leftChild;
//	private Child rightChild;
//	private Integer index;
//	private Integer depth;
//
//	public void swap(int K) {
//		if (this.depth % K == 0) {
//			Child c = leftChild;
//			this.leftChild = this.rightChild;
//			this.rightChild = c;
//		}
//		if (this.leftChild != null) {
//			this.leftChild.swap(K);
//		}
//
//		if (this.rightChild != null) {
//			this.rightChild.swap(K);
//		}
//	}
//
//	public void put(int[][] indexes, int i) {
//		if (indexes[i][0] != -1) {
//			Child l = new Child();
//			l.setIndex(indexes[i][0]);
//			l.setDepth(this.depth + 1);
//			this.setLeftChild(l);
//			l.put(indexes, i + 1);
//		}
//
//		if (indexes[i][1] != -1) {
//			Child r = new Child();
//			r.setIndex(indexes[i][1]);
//			r.setDepth(this.depth + 1);
//			this.setRightChild(r);
//			r.put(indexes, i + 2);
//		}
//
//	}
//
//	public Child getLeftChild() {
//		return leftChild;
//	}
//
//	public void setLeftChild(Child leftChild) {
//		this.leftChild = leftChild;
//	}
//
//	public Child getRightChild() {
//		return rightChild;
//	}
//
//	public void setRightChild(Child rightChild) {
//		this.rightChild = rightChild;
//	}
//
//	public Integer getIndex() {
//		return index;
//	}
//
//	public void setIndex(Integer index) {
//		this.index = index;
//	}
//
//	public Integer getDepth() {
//		return depth;
//	}
//
//	public void setDepth(Integer depth) {
//		this.depth = depth;
//	}
//
//}

public class Solution {
//
//	public static void Inorder(Child node, List<Integer> result) {
//		if (node == null) {
//			return;
//		}
//		Inorder(node.getLeftChild(), result);
//
//		// result.add(node.getIndex());
//
//		System.out.println(node.getIndex());
//
//		Inorder(node.getRightChild(), result);
//	}

	static int[][] swapNodes(int[][] indexes, int[] queries) {
//		Tree t = new Tree();
//		Child root = new Child();
//		root.setIndex(1);
//		root.setDepth(1);
//		t.setRoot(root);
//		root.put(indexes, 0);
//
//		int[][] result = new int[queries.length][indexes.length];
//
//		for (int i = 0; i < queries.length; i++) {
//			root.swap(queries[i]);
//			List<Integer> list = new ArrayList<Integer>();
//			Inorder(root, list);
//			/*
//			 * for (int j = 0; j < list.size(); j++) { result[i][j] = list.get(j); }
//			 */
//			System.out.println("-----------");
//		}
//
//		return result;
		return null;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(scanner.nextLine().trim());

		int[][] indexes = new int[n][2];

		for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
			String[] indexesRowItems = scanner.nextLine().split(" ");

			for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
				int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
				indexes[indexesRowItr][indexesColumnItr] = indexesItem;
			}
		}

		int queriesCount = Integer.parseInt(scanner.nextLine().trim());

		int[] queries = new int[queriesCount];

		for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
			int queriesItem = Integer.parseInt(scanner.nextLine().trim());
			queries[queriesItr] = queriesItem;
		}

		int[][] result = swapNodes(indexes, queries);

		for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
			for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
				bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

				if (resultColumnItr != result[resultRowItr].length - 1) {
					bufferedWriter.write(" ");
				}
			}

			if (resultRowItr != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();
	}
}
