public class SudokuSolver {
	public static void display(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void solveSudoku(int[][] board, int i, int j) {
		if (i == board.length) {
			display(board);
			return;
		}

		int ni = 0;
		int nj = 0;

		if (j == board[0].length - 1) {
			ni = i + 1;
			nj = 0;
		} else {
			ni = i;
			nj = j + 1;
		}

		if (board[i][j] != 0) {
			solveSudoku(board, ni, nj);
		} else {
			for (int val = 1; val <= 9; val++) {
				if (isSafe(board, i, j, val)) {
					board[i][j] = val;
					solveSudoku(board, ni, nj);
					board[i][j] = 0;
				}
			}
		}
	}

	public static boolean isSafe(int board[][], int row, int col, int c) {

		for (int i = 0; i < 9; i++) {
			if (board[row][i] == c) {
				return false;
			}
			if (board[i][col] == c) {
				return false;
			}

			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
				return false;
			}

		}

		return true;

	}

	public static void main(String[] args) throws Exception {
		  int[][] board = new int[][]{
              {3, 0, 6, 5, 0, 8, 4, 0, 0},
              {5, 2, 0, 0, 0, 0, 0, 0, 0},
              {0, 8, 7, 0, 0, 0, 0, 3, 1},
              {0, 0, 3, 0, 1, 0, 0, 8, 0},
              {9, 0, 0, 8, 6, 3, 0, 0, 5},
              {0, 5, 0, 0, 9, 0, 6, 0, 0},
              {1, 3, 0, 0, 0, 0, 2, 5, 0},
              {0, 0, 0, 0, 0, 0, 0, 7, 4},
              {0, 0, 5, 2, 0, 6, 3, 0, 0}
      };


		solveSudoku(board, 0, 0);
	}
}