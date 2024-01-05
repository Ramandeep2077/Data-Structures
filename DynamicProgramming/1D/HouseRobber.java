class HouseRobber {
	public int rob(int[] nums) {

		int n = nums.length;
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		// return helper(n, nums, dp);
		return helperUsingTabulation(n, nums, dp);

	}
        
	public int helperUsingTabulation(int n, int[] nums, int dp[]) {

		dp[0] = nums[0];
		for (int i = 1; i < n; i++) {
			int pick = nums[i];

			if (i > 1)
				pick += dp[i - 2];

			int nonPick = dp[i - 1];

			dp[i] = Math.max(pick, nonPick);

		}

		return dp[n - 1];

	}

	public int helperUsingSpace(int n, int[] nums, int dp[]) {

		int prev = nums[0];
		int prev2 = 0;
		for (int i = 1; i < n; i++) {
			int pick = nums[i];

			if (i > 1)
				pick += prev2;

			int nonPick = prev;

			int curr_i = Math.max(pick, nonPick);
			prev2 = prev;
			prev = curr_i;

		}

		return prev;

	}

	public int helper(int idx, int[] nums, int dp[]) {

		if (idx == 0)
			return nums[idx];

		if (idx < 0)
			return 0;

		if (dp[idx] != -1)
			return dp[idx];

		int pick = nums[idx] + helper(idx - 2, nums, dp);

		int nonPick = helper(idx - 1, nums, dp);

		return Math.max(pick, nonPick);

	}
}