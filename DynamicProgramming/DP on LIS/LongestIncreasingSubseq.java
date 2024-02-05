import java.util.Arrays;

class LongestIncreasingSubseq {

	static int getAns(int arr[], int n, int ind, int prev_index, int[][] dp) {

		if (ind == n) {
			return 0;
		}

		if (dp[ind][prev_index + 1] != -1) {
			return dp[ind][prev_index + 1];
		}

		int notTake = 0 + getAns(arr, n, ind + 1, prev_index, dp);

		int take = 0;

		if (prev_index == -1 || arr[ind] > arr[prev_index]) {
			take = 1 + getAns(arr, n, ind + 1, ind, dp);
		}

		dp[ind][prev_index + 1] = Math.max(notTake, take);

		return dp[ind][prev_index + 1];
	}

	static int longestIncreasingSubsequence_Memorization(int arr[], int n) {
		int dp[][] = new int[n][n + 1];

		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}

		return getAns(arr, n, 0, -1, dp);
	}

	static int longestIncreasingSubsequence_Tabulation(int arr[], int n) {

		int dp[][] = new int[n + 1][n + 1];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int prev_index = ind - 1; prev_index >= -1; prev_index--) {

				int notTake = 0 + dp[ind + 1][prev_index + 1];

				int take = 0;

				if (prev_index == -1 || arr[ind] > arr[prev_index]) {

					take = 1 + dp[ind + 1][ind + 1];
				}

				dp[ind][prev_index + 1] = Math.max(notTake, take);

			}
		}

		return dp[0][0];
	}

	static int longestIncreasingSubsequence_Space(int arr[], int n) {

		int next[] = new int[n + 1];
		int cur[] = new int[n + 1];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int prev_index = ind - 1; prev_index >= -1; prev_index--) {

				int notTake = 0 + next[prev_index + 1];

				int take = 0;

				if (prev_index == -1 || arr[ind] > arr[prev_index]) {

					take = 1 + next[ind + 1];
				}

				cur[prev_index + 1] = Math.max(notTake, take);
			}
			next = cur.clone();
		}

		return cur[0];
	}

	public static void main(String args[]) {
		int arr[] = { 10, 9, 2, 5, 3, 7, 101, 18 };

		int n = arr.length;

		System.out.println("The length of the longest increasing subsequence is "
				+ longestIncreasingSubsequence_Memorization(arr, n));
	}
}