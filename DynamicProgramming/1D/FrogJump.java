class FrogJump {
	static int solveMemorization(int ind, int[] height, int[] dp) {

		if (ind == 0)
			return 0;
		if (dp[ind] != -1)
			return dp[ind];
		int jumpTwo = Integer.MAX_VALUE;
		int jumpOne = solveMemorization(ind - 1, height, dp) + Math.abs(height[ind] - height[ind - 1]);
		if (ind > 1)
			jumpTwo = solveMemorization(ind - 2, height, dp) + Math.abs(height[ind] - height[ind - 2]);

		return dp[ind] = Math.min(jumpOne, jumpTwo);
	}

	public static int solveTabulation(int n, int heights[], int dp[]) {

		dp[0] = 0;

		for (int i = 1; i < n; i++) {

			int right = Integer.MAX_VALUE;
			int left = dp[i - 1] + Math.abs(heights[i - 1] - heights[i]);

			if (i > 1)
				right = dp[i - 2] + Math.abs(heights[i - 2] - heights[i]);

			dp[i] = Math.min(left, right);

		}

		return dp[n - 1];

	}

	public static int solveUsingSpace(int n, int heights[]) {

		int prev = 0;
		int prev2 = 0;

		for (int i = 1; i < n; i++) {

			int right = Integer.MAX_VALUE;
			int left = prev + Math.abs(heights[i - 1] - heights[i]);

			if (i > 1)
				right = prev2 + Math.abs(heights[i - 2] - heights[i]);

			int curr = Math.min(left, right);
			prev2 = prev;
			prev = curr;

		}

		return prev;

	}

	public static void main(String args[]) {

		int height[] = { 30, 10, 60, 10, 60, 50 };
		int n = height.length;
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		System.out.println(solveMemorization(n - 1, height, dp));
	}
}
