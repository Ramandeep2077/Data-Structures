
public class FrogJumpII {
	public static int solveTabulation(int n, int k, int[] height) {
		// Write your code here.
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for (int idx = 1; idx < n; idx++) {
			int mmSteps = Integer.MAX_VALUE;

			for (int j = 1; j <= k; j++) {
				if (idx - j >= 0) {
					int left = dp[idx - j] + Math.abs(height[idx] - height[idx - j]);

					mmSteps = Math.min(left, mmSteps);
				}

			}
			dp[idx] = mmSteps;

		}
		return dp[n - 1];

	}

	public static int solveMemorization(int idx, int k, int[] height, int dp[]) {

		if (idx == 0)
			return 0;

		if (dp[idx] != -1)
			return dp[idx];

		int mmSteps = Integer.MAX_VALUE;

		for (int j = 1; j <= k; j++) {
			if (idx - j >= 0) {
				int left = solveMemorization(idx - j, k, height, dp) + Math.abs(height[idx] - height[idx - j]);

				mmSteps = Math.min(left, mmSteps);
			}

		}

		return dp[idx] = mmSteps;

	}

	public static void main(String args[]) {
		int height[] = { 30, 10, 60, 10, 60, 50 };
		int n = height.length;
		int k = 2;

		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		System.out.println(solveMemorization(n - 1, k, height, dp));
	}
}