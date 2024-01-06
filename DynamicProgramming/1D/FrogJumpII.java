class FrogJumpII {

	static int solveUtilMemorization(int ind, int[] height, int[] dp, int k) {
		if (ind == 0)
			return 0;

		if (dp[ind] != -1)
			return dp[ind];

		int mmSteps = Integer.MAX_VALUE;

		for (int j = 1; j <= k; j++) {
			if (ind - j >= 0) {
				int jump = solveUtilMemorization(ind - j, height, dp, k) + Math.abs(height[ind] - height[ind - j]);
				mmSteps = Math.min(jump, mmSteps);
			}
		}

		return dp[ind] = mmSteps;
	}

	static int solveUtilTabulation(int n, int[] height, int[] dp, int k) {
		dp[0] = 0;

		for (int i = 1; i < n; i++) {
			int mmSteps = Integer.MAX_VALUE;

			for (int j = 1; j <= k; j++) {
				if (i - j >= 0) {
					int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
					mmSteps = Math.min(jump, mmSteps);
				}
			}
			dp[i] = mmSteps;
		}
		return dp[n - 1];
	}

	static int solve(int n, int[] height, int k) {
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		return solveUtilTabulation(n, height, dp, k);
	}

	public static void main(String args[]) {
		int height[] = { 30, 10, 60, 10, 60, 50 };
		int n = height.length;
		int k = 2;
		System.out.println(solve(n, height, k));
	}
}
