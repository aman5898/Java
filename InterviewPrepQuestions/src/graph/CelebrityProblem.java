package graph;

import java.util.*;

class CelebrityProblem {
	public static void main(String[] args) {
		int[][] M = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
		System.out.println(getId(M));
	}

	static int getId(int M[][]) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < M.length; i++) {
			boolean bl = false;
			for (int j = 0; j < M[0].length; j++) {
				if (M[i][j] == 1) {
					bl = true;
					break;
				}
			}
			if (bl == false) {
				list.add(i);
			}
		}

		for (int vertex : list) {
			boolean bl = false;
			for (int i = 0; i < M.length; i++) {
				if (i != vertex) {
					if (M[i][vertex] == 0) {
						bl = true;
						break;
					}
				}
			}
			if (bl == false) {
				return vertex;
			}
		}

		return -1;
	}
}