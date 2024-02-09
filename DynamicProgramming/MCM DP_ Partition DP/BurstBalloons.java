import java.util.Arrays;

class BurstBalloons {
	public int maxCoins(int[] nums) {
		int n = nums.length;
		int temp[] = new int[n + 2];

		for (int i = 0; i < n; i++) {
			temp[i + 1] = nums[i];
		}
		temp[0] = 1;
		temp[n + 1] = 1;

		int dp[][] = new int[n + 2][n + 2];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		 return helper(1, n, temp, dp);
		//return helper_Tabulation(n, temp);
	}

	public int helper_Tabulation(int n, int arr[]) {

		int dp[][] = new int[n + 2][n + 2];
		for (int row[] : dp)
			Arrays.fill(row, 0);

		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= n; j++) {
				if (i > j)
					continue;
				int maxi = Integer.MIN_VALUE;

				for (int k = i; k <= j; k++) {
					int cost = arr[i - 1] * arr[k] * arr[j + 1] + dp[i][k - 1] + dp[k + 1][j];

					maxi = Math.max(maxi, cost);

				}

				dp[i][j] = maxi;

			}
		}

		return dp[1][n];
	}

	public int helper_Memorization(int i, int j, int arr[], int dp[][]) {

		if (i > j)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int maxi = Integer.MIN_VALUE;

		for (int k = i; k <= j; k++) {
			int cost = arr[i - 1] * arr[k] * arr[j + 1] + helper_Memorization(i, k - 1, arr, dp)
					+ helper_Memorization(k + 1, j, arr, dp);

			maxi = Math.max(maxi, cost);

		}

		return dp[i][j] = maxi;
	}
}