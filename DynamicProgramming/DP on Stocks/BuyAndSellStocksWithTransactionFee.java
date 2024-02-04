
import java.util.*;

class BuyAndSellStocksWithTransactionFee {


	static int getAns(int[] Arr, int ind, int buy, int n, int fee, int[][] dp) {

		if (ind == n) {
			return 0;
		}

		if (dp[ind][buy] != -1) {
			return dp[ind][buy];
		}

		int profit = 0;

		if (buy == 0) { // We can buy the stock
			profit = Math.max(0 + getAns(Arr, ind + 1, 0, n, fee, dp), -Arr[ind] + getAns(Arr, ind + 1, 1, n, fee, dp));
		}

		if (buy == 1) { // We can sell the stock
			profit = Math.max(0 + getAns(Arr, ind + 1, 1, n, fee, dp),
					Arr[ind] - fee + getAns(Arr, ind + 1, 0, n, fee, dp));
		}

		dp[ind][buy] = profit;
		return profit;
	}

	static int maximumProfit_Memorization(int n, int fee, int[] Arr) {
		int dp[][] = new int[n][2];

		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}

		if (n == 0) {
			return 0;
		}

		int ans = getAns(Arr, 0, 0, n, fee, dp);
		return ans;
	}

	static int maximumProfit_Tabulation(int n, int fee, int[] Arr) {

		if (n == 0) {
			return 0;
		}

		int dp[][] = new int[n + 1][2];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				int profit = 0;

				if (buy == 0) {
					profit = Math.max(0 + dp[ind + 1][0], -Arr[ind] + dp[ind + 1][1]);
				}

				if (buy == 1) {
					profit = Math.max(0 + dp[ind + 1][1], Arr[ind] - fee + dp[ind + 1][0]);
				}

				dp[ind][buy] = profit;
			}
		}

		return dp[0][0];
	}

	static long maximumProfit_Space(int n, int fee, int[] Arr) {

		if (n == 0) {
			return 0;
		}

		long ahead[] = new long[2];
		long cur[] = new long[2];

		ahead[0] = ahead[1] = 0;
		long profit = 0;

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 0) {
					profit = Math.max(0 + ahead[0], -Arr[ind] + ahead[1]);
				}

				if (buy == 1) {
					profit = Math.max(0 + ahead[1], Arr[ind] - fee + ahead[0]);
				}
				cur[buy] = profit;
			}

			ahead = (long[]) (cur.clone());
		}
		return cur[0];
	}

	public static void main(String args[]) {
		int prices[] = { 1, 3, 2, 8, 4, 9 };
		int n = prices.length;
		int fee = 2;

		System.out.println("The maximum profit that can be generated is " + maximumProfit_Memorization(n, fee, prices));
	}
}
