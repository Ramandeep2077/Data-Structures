
import java.util.*;

class BuyAndSellStocksWithCooldown {

	static int getAns(int[] Arr, int ind, int buy, int n, int[][] dp) {
		// Base case
		if (ind >= n) {
			return 0;
		}

		if (dp[ind][buy] != -1) {
			return dp[ind][buy];
		}

		int profit = 0;

		if (buy == 0) { // We can buy the stock
			profit = Math.max(0 + getAns(Arr, ind + 1, 0, n, dp), -Arr[ind] + getAns(Arr, ind + 1, 1, n, dp));
		}

		if (buy == 1) { // We can sell the stock
			profit = Math.max(0 + getAns(Arr, ind + 1, 1, n, dp), Arr[ind] + getAns(Arr, ind + 2, 0, n, dp));
		}

		dp[ind][buy] = profit;
		return profit;
	}

	static int stockProfit_Memorization(int[] Arr) {
		int n = Arr.length;
		int[][] dp = new int[n][2];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		int ans = getAns(Arr, 0, 0, n, dp);
		return ans;
	}

	static int stockProfit_Tabulation(int[] Arr) {
		int n = Arr.length;
		int dp[][] = new int[n + 2][2];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				int profit = 0;

				if (buy == 0) {
					profit = Math.max(0 + dp[ind + 1][0], -Arr[ind] + dp[ind + 1][1]);
				}

				if (buy == 1) {
					profit = Math.max(0 + dp[ind + 1][1], Arr[ind] + dp[ind + 2][0]);
				}

				dp[ind][buy] = profit;
			}
		}

		return dp[0][0];
	}

	static int stockProfit_Space(int[] Arr) {
		int n = Arr.length;
		int[] cur = new int[2];
		int[] front1 = new int[2];
		int[] front2 = new int[2];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				int profit = 0;

				if (buy == 0) {
					profit = Math.max(0 + front1[0], -Arr[ind] + front1[1]);
				}

				if (buy == 1) {
					profit = Math.max(0 + front1[1], Arr[ind] + front2[0]);
				}

				cur[buy] = profit;
			}

			// Update front1 and front2 arrays
			System.arraycopy(front1, 0, front2, 0, 2);
			System.arraycopy(cur, 0, front1, 0, 2);
		}

		return cur[0];
	}

	public static void main(String args[]) {
		int prices[] = { 4, 9, 0, 4, 10 };

		System.out.println("The maximum profit that can be generated is " + stockProfit_Memorization(prices));
	}
}
