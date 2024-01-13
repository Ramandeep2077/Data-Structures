
import java.util.*;

class UniquePathsII {
	static int mazeObstaclesMemorizationUtil(int i, int j, int[][] maze, int[][] dp) {
		if (i >= 0 && j >= 0 && maze[i][j] == -1)
			return 0;

		if (i == 0 && j == 0)
			return 1;

		if (i < 0 || j < 0)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int up = mazeObstaclesMemorizationUtil(i - 1, j, maze, dp);
		int left = mazeObstaclesMemorizationUtil(i, j - 1, maze, dp);

		return dp[i][j] = up + left;
	}

	static int mazeObstaclesMemorization(int n, int m, int[][] maze) {
		int dp[][] = new int[n][m];

		for (int row[] : dp)
			Arrays.fill(row, -1);

		return mazeObstaclesMemorizationUtil(n - 1, m - 1, maze, dp);
	}

	static int mazeObstaclesTabulationUtil(int n, int m, int[][] maze, int[][] dp) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (i > 0 && j > 0 && maze[i][j] == -1) {
					dp[i][j] = 0;
					continue;
				}
				if (i == 0 && j == 0) {
					dp[i][j] = 1;
					continue;
				}

				int up = 0;
				int left = 0;

				if (i > 0)
					up = dp[i - 1][j];

				if (j > 0)
					left = dp[i][j - 1];

				dp[i][j] = up + left;
			}
		}

		return dp[n - 1][m - 1];
	}

	static int mazeObstaclesTabulation(int n, int m, int[][] maze) {
		int dp[][] = new int[n][m];

		for (int row[] : dp)
			Arrays.fill(row, -1);

		return mazeObstaclesTabulationUtil(n, m, maze, dp);
	}

	static int mazeObstaclesSpace(int n, int m, int[][] maze) {

		int prev[] = new int[n];

		for (int i = 0; i < n; i++) {

			int temp[] = new int[m];

			for (int j = 0; j < m; j++) {

				if (i > 0 && j > 0 && maze[i][j] == -1) {
					temp[j] = 0;
					continue;
				}
				if (i == 0 && j == 0) {
					temp[j] = 1;
					continue;
				}

				int up = 0;
				int left = 0;

				if (i > 0)
					up = prev[j];

				if (j > 0)
					left = temp[j - 1];

				temp[j] = up + left;
			}

			prev = temp;
		}

		return prev[n - 1];
	}

	public static void main(String args[]) {

		int[][] maze = { { 0, 0, 0 }, { 0, -1, 0 }, { 0, 0, 0 } };

		int n = maze.length;
		int m = maze[0].length;

		System.out.println(mazeObstaclesMemorization(n, m, maze));
	}
}
