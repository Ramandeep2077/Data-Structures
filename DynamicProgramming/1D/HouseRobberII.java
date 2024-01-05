class HouseRobberII {
	public int rob(int[] nums) {

		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		Arrays.fill(dp1, -1);
		Arrays.fill(dp2, -1);

		// return solveSpace(nums);

		int max1 = solve(0, n - 2, dp1, nums);
		int max2 = solve(1, n - 1, dp2, nums);
		return Math.max(max1, max2);

	}

	public int solve(int start, int end, int[] dp, int[] arr) {
		if (start > end) {
			return 0;
		}
		if (dp[start] != -1) {
			return dp[start];
		}
		int pick = arr[start] + solve(start + 2, end, dp, arr);
		int notpick = 0 + solve(start + 1, end, dp, arr);

		return dp[start] = Math.max(pick, notpick);
	}

	public int solveSpace(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		Arrays.fill(dp1, -1);
		Arrays.fill(dp2, -1);

		/*
		 * Calculate the maximum amount of money that can be robbed when excluding the
		 * first house
		 */
		int prev2 = 0;
		int prev = nums[1];
		for (int i = 2; i < n; i++) {
			int curr = Math.max(prev2 + nums[i], prev);
			prev2 = prev;
			prev = curr;
		}

		int ans1 = prev;

		prev = 0;
		// Calculate the maximum amount of money that can be robbed when excluding the
		// last house
		prev2 = nums[0];
		prev = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n - 1; i++) {
			int curr = Math.max(prev2 + nums[i], prev);
			prev2 = prev;
			prev = curr;

		}

		// Return the maximum amount of money between the two cases return
		return Math.max(ans1, prev);

	}

	public int solveTabulataion(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		Arrays.fill(dp1, -1);
		Arrays.fill(dp2, -1);

		/*
		 * Calculate the maximum amount of money that can be robbed when excluding the
		 * first house
		 */
		dp1[0] = 0;
		dp1[1] = nums[1];
		for (int i = 2; i < n; i++) {
			dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
		}

		// Calculate the maximum amount of money that can be robbed when excluding the
		// last house
		dp2[0] = nums[0];
		dp2[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n - 1; i++) {
			dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
		}

		// Return the maximum amount of money between the two cases return
		return Math.max(dp1[n - 1], dp2[n - 2]);

	}
}