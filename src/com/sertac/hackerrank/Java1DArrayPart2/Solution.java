package com.sertac.hackerrank.Java1DArrayPart2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static HashSet<Integer> visitedIndexes = new HashSet<Integer>();

	private static class Child {
		private int index;
		private boolean canWin = false;
		private List<Child> children = new ArrayList<Child>();

		public List<Child> getChildren() {
			return children;
		}

		public void setChildren(List<Child> children) {
			this.children = children;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public boolean isCanWin() {
			return canWin;
		}

		public void setCanWin(boolean canWin) {
			this.canWin = canWin;
		}

		public boolean canWinRoot() {
			if (canWin) {
				return true;
			}
			boolean canWinRoot = false;

			for (Child child : children) {
				if (child.canWinRoot()) {
					canWinRoot = true;
					break;
				}
			}
			return canWinRoot;
		}
	}

	private static class Root {
		private Child child;

		public Child getChild() {
			return child;
		}

		public void setChild(Child child) {
			this.child = child;
		}

		public boolean canWinRoot() {
			return child.canWinRoot();
		}
	}

	private static void createChild(int leap, int[] game, Child child) {
		if (child.getIndex() + 1 < game.length && game[child.getIndex() + 1] == 0) {
			Child newChild = new Child();
			newChild.setIndex(child.getIndex() + 1);
			newChild.setCanWin(canWinAtIndex(leap, game, child.getIndex() + 1));
			child.getChildren().add(newChild);
			visitedIndexes.add(child.getIndex() + 1);
			createChild(leap, game, newChild);
		}

		if (leap > 0 && child.getIndex() + leap < game.length && game[child.getIndex() + leap] == 0) {
			Child newChild = new Child();
			newChild.setIndex(child.getIndex() + leap);
			newChild.setCanWin(canWinAtIndex(leap, game, child.getIndex() + leap));
			child.getChildren().add(newChild);
			visitedIndexes.add(child.getIndex() + leap);
			createChild(leap, game, newChild);
		}

		if (!visitedIndexes.contains(child.getIndex() - 1) && child.getIndex() - 1 > 0
				&& game[child.getIndex() - 1] == 0) {
			Child newChild = new Child();
			newChild.setIndex(child.getIndex() - 1);
			newChild.setCanWin(canWinAtIndex(leap, game, child.getIndex() - 1));
			child.getChildren().add(newChild);
			visitedIndexes.add(child.getIndex() - 1);
			createChild(leap, game, newChild);
		}

	}

	private static boolean canWinAtIndex(int leap, int[] game, int index) {
		return index == game.length - 1 || index + leap >= game.length;
	}

	public static boolean canWin(int leap, int[] game) {

		Root root = new Root();
		Child child = new Child();
		child.setIndex(0);
		child.setCanWin(canWinAtIndex(leap, game, 0));
		root.setChild(child);
		visitedIndexes = new HashSet<Integer>();
		visitedIndexes.add(0);

		createChild(leap, game, child);

		return root.canWinRoot();

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}

			System.out.println((canWin(leap, game)) ? "YES" : "NO");
		}
		scan.close();
	}
}