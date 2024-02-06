class NumberOfLIS {
	public int findNumberOfLIS(int[] arr) {

		int n = arr.length;

		int dp[] = new int[n];
		int count[] = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(count, 1);

		int maxi = 1;

		for (int idx = 0; idx < n; idx++) {
			for (int prevIdx = 0; prevIdx < idx; prevIdx++) {
				if (arr[prevIdx] < arr[idx] && 1 + dp[prevIdx] > dp[idx]) {
					dp[idx] = 1 + dp[prevIdx];
					count[idx] = count[prevIdx];

				} else if (arr[prevIdx] < arr[idx] && 1 + dp[prevIdx] == dp[idx]) {
					count[idx] += count[prevIdx];

				}

			}
			maxi = Math.max(maxi, dp[idx]);

		}

		int nums = 0;
		for (int idx = 0; idx < n; idx++) {
			if (dp[idx] == maxi)
				nums += count[idx];
		}

		return nums;
	}
}