import java.util.Arrays;

class BuyAndSellStock_II {

	static int getMaximumProfitUtil(int[] Arr, int ind, int buy, int n, int[][] dp) {

		if (ind == n)
			return 0;

		if (dp[ind][buy] != -1)
			return dp[ind][buy];

		int profit;

		if (buy == 0) { // We can buy the stock
			profit = Math.max(0 + getMaximumProfitUtil(Arr, ind + 1, 0, n, dp),
					-Arr[ind] + getMaximumProfitUtil(Arr, ind + 1, 1, n, dp));
		} else { // We can sell the stock
			profit = Math.max(0 + getMaximumProfitUtil(Arr, ind + 1, 1, n, dp),
					Arr[ind] + getMaximumProfitUtil(Arr, ind + 1, 0, n, dp));
		}

		dp[ind][buy] = profit;
		return profit;
	}

	static int getMaximumProfit(int[] Arr, int n) {

		int[][] dp = new int[n][2];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		if (n == 0)
			return 0;

		int ans = getMaximumProfitUtil(Arr, 0, 0, n, dp);
		return ans;
	}

	static int getMaximumProfit_Tabulation(int[] Arr, int n) {

		int[][] dp = new int[n + 1][2];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		// Base condition: If we have no stocks to buy or sell, profit is 0
		dp[n][0] = dp[n][1] = 0;

		int profit = 0;

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 0) { // We can buy the stock
					profit = Math.max(0 + dp[ind + 1][0], -Arr[ind] + dp[ind + 1][1]);
				}

				if (buy == 1) { // We can sell the stock
					profit = Math.max(0 + dp[ind + 1][1], Arr[ind] + dp[ind + 1][0]);
				}

				dp[ind][buy] = profit;
			}
		}
		return dp[0][0];
	}

	static int getMaximumProfit_Space(int[] Arr, int n) {
		// Create arrays 'ahead' and 'cur' to store the maximum profit ahead and current
		// profit
		int[] ahead = new int[2];
		int[] cur = new int[2];

		// Base condition: If we have no stocks to buy or sell, profit is 0
		ahead[0] = ahead[1] = 0;

		int profit = 0;

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 0) { // We can buy the stock
					profit = Math.max(0 + ahead[0], -Arr[ind] + ahead[1]);
				}

				if (buy == 1) { // We can sell the stock
					profit = Math.max(0 + ahead[1], Arr[ind] + ahead[0]);
				}
				cur[buy] = profit;
			}

			// Update the 'ahead' array with the current profit values
			System.arraycopy(cur, 0, ahead, 0, 2);
		}
		return cur[0];
	}

	public static void main(String[] args) {
		int n = 6;
		int[] Arr = { 7, 1, 5, 3, 6, 4 };

		System.out.println("The maximum profit that can be generated is " + getMaximumProfit(Arr, n));
	}
}
