import java.util.Arrays;

class MinCostToCutStick {
	public static int minCost(int n, int[] cuts) {
		int c = cuts.length;
		int temp[] = new int[c + 2];
		for (int i = 0; i < c; i++) {
			temp[i + 1] = cuts[i];
		}
		temp[0] = 0;
		temp[c + 1] = n;
		Arrays.sort(temp);

		int dp[][] = new int[c + 2][c + 2];

		for (int row[] : dp)
			Arrays.fill(row, -1);
		// return helperTab(c, temp);
		return helper_Memorization(1, c, temp, dp);

	}

	public static int helperTab(int c, int cuts[]) {
		int dp[][] = new int[c + 2][c + 2];
		for (int i = c; i >= 1; i--) {
			for (int j = i; j <= c; j++) {
				int mini = Integer.MAX_VALUE;
				for (int k = i; k <= j; k++) {
					int ans = cuts[j + 1] - cuts[i - 1] + dp[i][k - 1] + dp[k + 1][j];
					mini = Math.min(mini, ans);
				}

				dp[i][j] = mini;

			}
		}

		return dp[1][c];

	}

	public static int helper_Memorization(int i, int j, int cuts[], int dp[][]) {

		if (i > j)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int mini = Integer.MAX_VALUE;
		for (int k = i; k <= j; k++) {
			int ans = cuts[j + 1] - cuts[i - 1] + helper_Memorization(i, k - 1, cuts, dp)
					+ helper_Memorization(k + 1, j, cuts, dp);
			mini = Math.min(mini, ans);
		}

		return dp[i][j] = mini;
	}

	public static void main(String[] args) {
		int cuts[] = { 3, 5, 1, 4 };
		int c = cuts.length;
		int n = 7;

		System.out.println("The minimum cost incurred: " + minCost(n, cuts));
	}
}