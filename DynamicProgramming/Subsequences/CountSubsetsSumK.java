
import java.util.*;

class CountSubsetsSumK {

	static int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {

		if (ind == 0) {
			if (target == 0 && arr[0] == 0)
				return 2;
			if (target == 0 || target == arr[0])
				return 1;
			return 0;
		}

		if (dp[ind][target] != -1)
			return dp[ind][target];

		int notTaken = findWaysUtil(ind - 1, target, arr, dp);

		int taken = 0;
		if (arr[ind] <= target)
			taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);

		return dp[ind][target] = notTaken + taken;
	}

	static int findWays_Memorization(int[] num, int k) {
		int n = num.length;
		int dp[][] = new int[n][k + 1];

		for (int row[] : dp)
			Arrays.fill(row, -1);

		return findWaysUtil(n - 1, k, num, dp);
	}

	static int findWays_Tabulation(int[] num, int k) {
		int n = num.length;

		int[][] dp = new int[n][k + 1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}

		for (int j = 1; j <= k; j++)
			dp[0][j] = (j == num[0]) ? 1 : 0;

		for (int ind = 1; ind < n; ind++) {
			for (int target = 1; target <= k; target++) {

				int notTaken = dp[ind - 1][target];

				int taken = 0;
				if (num[ind] <= target) {
					taken = dp[ind - 1][target - num[ind]];
				}

				dp[ind][target] = notTaken + taken;
			}
		}

		return dp[n - 1][k];
	}

	static int findWays_Space(int[] num, int k) {
		int n = num.length;

		int[] prev = new int[k + 1];

		prev[0] = 1;

		for (int j = 1; j <= k; j++)
			prev[j] = (j == num[0]) ? 1 : 0;

		for (int ind = 1; ind < n; ind++) {

			int[] cur = new int[k + 1];

			cur[0] = 1;

			for (int target = 1; target <= k; target++) {

				int notTaken = prev[target];

				int taken = 0;
				if (num[ind] <= target) {
					taken = prev[target - num[ind]];
				}

				cur[target] = notTaken + taken;
			}

			prev = cur;
		}

		return prev[k];
	}

	public static void main(String args[]) {
		int arr[] = { 1, 2, 2, 3 };
		int k = 3;

		System.out.println("The number of subsets found are " + findWays_Memorization(arr, k));
	}
}
