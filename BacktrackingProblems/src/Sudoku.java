public class Sudoku {

	public static boolean solveSudoku(int[][] board, int n) {
		int row = -1;
		int col = -1;
		boolean isFilled = true;
		outer: for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;
					isFilled = false;
					break outer;
				}
			}
		}
		if (isFilled) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					System.out.print(board[i][j] + "\t");
				}
				System.out.println();
			}
			return true;
		}

		for (int k = 1; k <= 9; k++) {
			if (isSafe(k, row, col, board) == true) {
				board[row][col] = k;
				if (solveSudoku(board, n) == true) {
					return true;
				} else {
					board[row][col] = 0; // replace it
				}
			}
		}

		return false;
	}

	private static boolean isSafe(int k, int row, int col, int[][] board) {
		for (int i = 0; i <= row; i++) {
			if (board[i][col] == k) {
				return false;
			}
		}

		for (int j = 0; j <= col; j++) {
			if (board[row][j] == k) {
				return false;
			}
		}

		int sqrt = (int) Math.sqrt(board.length);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;

		for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
			for (int d = boxColStart; d < boxColStart + sqrt; d++) {
				if (board[r][d] == k) {
					return false;
				}
			}
		}

		return true;
	}

	public static void printPath(int row, int col, int[][] maze, String psf,
			boolean[][] check) {

		if (row < 0) {
			return;
		}
		if (col < 0) {
			return;
		}
		if (row >= maze.length) {
			return;
		}
		if (col >= maze.length) {
			return;
		}
		if (row == maze.length / 2 && col == maze.length / 2) {
			System.out.println(psf + "(" + row + "," + col + ")");
			return;
		}

		if (check[row][col]) {
			return;
		}
		check[row][col] = true;
		printPath(row + maze[row][col], col, maze, psf + "(" + row + "," + col
				+ ")=>", check);
		printPath(row - maze[row][col], col, maze, psf + "(" + row + "," + col
				+ ")=>", check);
		printPath(row, col + maze[row][col], maze, psf + "(" + row + "," + col
				+ ")=>", check);
		printPath(row, col - maze[row][col], maze, psf + "(" + row + "," + col
				+ ")=>", check);
		check[row][col] = false;
	}

	public static int findLongestPathUtil(int row, int col, int[][] path,
			boolean[][] visited, int drow, int dcol) {

		if (row == drow && col == dcol) {
			return 0;
		}

		int m1 = Integer.MIN_VALUE, m2 = Integer.MIN_VALUE, m3 = Integer.MIN_VALUE, m4 = Integer.MIN_VALUE;
		visited[row][col] = true;
		if (row != path.length - 1) {
			if (visited[row + 1][col] == false && path[row + 1][col] != 0) {
				m1 = findLongestPathUtil(row + 1, col, path, visited, drow,
						dcol);
			}
		}
		if (row != 0) {
			if (visited[row - 1][col] == false && path[row - 1][col] != 0) {
				m2 = findLongestPathUtil(row - 1, col, path, visited, drow,
						dcol);
			}
		}
		if (col != path[0].length - 1) {
			if (visited[row][col + 1] == false && path[row][col + 1] != 0) {
				m3 = findLongestPathUtil(row, col + 1, path, visited, drow,
						dcol);
			}
		}
		if (col != 0) {
			if (visited[row][col - 1] == false && path[row][col - 1] != 0) {
				m4 = findLongestPathUtil(row, col - 1, path, visited, drow,
						dcol);
			}
		}
		visited[row][col] = false;
		return 1 + Math.max(Math.max(m1, m2), Math.max(m3, m4));
	}

	public static boolean dictionaryContains(String word) {
		String dictionary[] = { "mobile", "samsung", "sam", "sung", "man",
				"mango", "icecream", "and", "go", "i", "love", "ice", "cream" };

		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i].equals(word)) {
				return true;
			}
		}
		return false;
	}

	public static void wordBreakUtil(String str, int n, String asf) {
		if (str.length() == 0) {
			System.out.println(asf);
			return;
		}
		for (int i = 1; i <= str.length(); i++) {
			String subs = str.substring(0, i);
			if (dictionaryContains(subs) == true) {
				wordBreakUtil(str.substring(i, str.length()), n, asf + " "
						+ subs);
			}
		}
	}

	public static boolean isKPartitionPossibleRec(int arr[], int subsetSum[],
			boolean taken[], int subset, int K, int N) {
		int arr_sum = 0;
		boolean check=false;
		for (int i = 0; i < arr.length; i++) {
			arr_sum += arr[i];
			if(taken[i]==false){
				check=true;
			}
		}
		
		if(check==false){
			return true;
		}
		
		
		
		boolean ans = false;
		for (int i = 0; i < arr.length; i++) {
			if (taken[i] == false) {
				for (int j = 0; j < subset; j++) {
					if (subsetSum[j] != arr_sum / K) {
						subsetSum[j] += arr[i];
						taken[i] = true;
						ans = isKPartitionPossibleRec(arr, subsetSum, taken,
								subset, K, N);
						if (ans == true) {
							return ans;
						}
						subsetSum[j] -= arr[i];
						taken[i] = false;
						break;
					}
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		// int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		// { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
		// { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		//
		// boolean[][] visited = new boolean[mat.length][mat[0].length];
		//
		// // find longest path with source (0, 0) and
		// // destination (1, 7)
		// int x = findLongestPathUtil(0, 0, mat, visited, 1, 7);
		// System.out.println(x);
		// int[][] board = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
		// { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
		// { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
		// { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
		// { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		// int N = board.length;
		//
		// solveSudoku(board, N);
		wordBreakUtil("ilovesamsungmobile", 5, "");

	}

}
