public class PartitionSetIntoTwoSubsetsMinAbsSumDiff {

	static int minSubsetSumDifference(int[] arr, int n) {
		int totSum = 0;

		for (int i = 0; i < n; i++) {
			totSum += arr[i];
		}

		boolean[][] dp = new boolean[n][totSum + 1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		if (arr[0] <= totSum) {
			dp[0][totSum] = true;
		}

		for (int ind = 1; ind < n; ind++) {
			for (int target = 1; target <= totSum; target++) {

				boolean notTaken = dp[ind - 1][target];

				boolean taken = false;
				if (arr[ind] <= target) {
					taken = dp[ind - 1][target - arr[ind]];
				}

				dp[ind][target] = notTaken || taken;
			}
		}

		int mini = Integer.MAX_VALUE;

		// Find the minimum absolute difference between two subsets
		for (int i = 0; i <= totSum; i++) {
			if (dp[n - 1][i]) {
				int diff = Math.abs(i - (totSum - i));
				mini = Math.min(mini, diff);
			}
		}
		return mini;
	}

	static int minSubsetSumDifference_Space(int[] arr, int n) {
		int totSum = 0;

		for (int i = 0; i < n; i++) {
			totSum += arr[i];
		}

		boolean[] prev = new boolean[totSum + 1];

		prev[0] = true;

		if (arr[0] <= totSum) {
			prev[totSum] = true;
		}

		for (int ind = 1; ind < n; ind++) {
			boolean[] curr = new boolean[totSum + 1];
			curr[0] = true;

			for (int target = 1; target <= totSum; target++) {

				boolean notTaken = prev[target];

				boolean taken = false;
				if (arr[ind] <= target) {
					taken = prev[target - arr[ind]];
				}

				curr[target] = notTaken || taken;
			}
			prev = curr;
		}

		int mini = Integer.MAX_VALUE;

		// Find the minimum absolute difference between two subsets
		for (int i = 0; i <= totSum; i++) {
			if (prev[i]) {
				int diff = Math.abs(i - (totSum - i));
				mini = Math.min(mini, diff);
			}
		}
		return mini;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int n = arr.length;

		System.out.println("The minimum absolute difference is: " + minSubsetSumDifference_Space(arr, n));

		System.out.println("The minimum absolute difference is: " + minSubsetSumDifference(arr, n));
	}
}
