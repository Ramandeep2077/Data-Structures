
import java.util.Arrays;

public class BuyAndStockSell_IV {

	public static int maximumProfit_Memorization(int[] prices, int n, int k) {

		int[][][] dp = new int[n][2][k + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		return getAns(prices, n, 0, 0, k, dp);
	}

	public static int getAns(int[] prices, int n, int ind, int buy, int cap, int[][][] dp) {

		if (ind == n || cap == 0) {
			return 0;
		}

		if (dp[ind][buy][cap] != -1) {
			return dp[ind][buy][cap];
		}

		int profit;

		if (buy == 0) { // We can buy the stock
			profit = Math.max(0 + getAns(prices, n, ind + 1, 0, cap, dp),
					-prices[ind] + getAns(prices, n, ind + 1, 1, cap, dp));
		} else { // We can sell the stock
			profit = Math.max(0 + getAns(prices, n, ind + 1, 1, cap, dp),
					prices[ind] + getAns(prices, n, ind + 1, 0, cap - 1, dp));
		}

		dp[ind][buy][cap] = profit;
		return profit;
	}

	public static int maximumProfit_Tabulation(int[] prices, int n, int k) {

		int[][][] dp = new int[n + 1][2][k + 1];

		// As dp array is initialized to 0, we have already covered the base case

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				for (int cap = 1; cap <= k; cap++) {
					if (buy == 0) {
						dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][0][cap], -prices[ind] + dp[ind + 1][1][cap]);
					} else {
						dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][1][cap], prices[ind] + dp[ind + 1][0][cap - 1]);
					}
				}
			}
		}

		return dp[0][0][k];
	}

	public static int maxProfit_Space(int[] prices, int n, int k) {

		int[][] ahead = new int[2][k + 1];
		int[][] cur = new int[2][k + 1];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				for (int cap = 1; cap <= k; cap++) {
					if (buy == 0) {
						cur[buy][cap] = Math.max(0 + ahead[0][cap], -prices[ind] + ahead[1][cap]);
					} else {
						cur[buy][cap] = Math.max(0 + ahead[1][cap], prices[ind] + ahead[0][cap - 1]);
					}
				}
			}

			for (int i = 0; i < 2; i++) {
				System.arraycopy(cur[i], 0, ahead[i], 0, k + 1);
			}
		}

		return ahead[0][k];
	}

	public static void main(String[] args) {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int n = prices.length;
		int k = 2;

		System.out.println("The maximum profit that can be generated is " + maximumProfit_Memorization(prices, n, k));
	}
}
