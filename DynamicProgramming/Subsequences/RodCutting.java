import java.util.*;

public class RodCutting {
	public static int cutRod(int price[], int n) {
		// Write your code here.

		int dp[][] = new int[n][n + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		return helper(n - 1, n, price, dp);

		// return helper_1DSpace(n, price);
	}

	public static int helper_1DSpace(int n, int price[]) {
		int prev[] = new int[n + 1];

		for (int N = 0; N <= n; N++) {
			prev[N] = N * price[0];
		}

		for (int idx = 1; idx < n; idx++) {

			for (int N = 0; N <= n; N++) {
				int notTake = prev[N];

				int take = Integer.MIN_VALUE;

				int rodLength = idx + 1;

				if (rodLength <= N)
					take = price[idx] + prev[N - rodLength];

				prev[N] = Math.max(take, notTake);

			}

		}

		return prev[n];

	}

	public static int helperSpace(int n, int price[]) {
		int prev[] = new int[n + 1];

		for (int N = 0; N <= n; N++) {
			prev[N] = N * price[0];
		}

		for (int idx = 1; idx < n; idx++) {
			int curr[] = new int[n + 1];

			for (int N = 0; N <= n; N++) {
				int notTake = prev[N];

				int take = Integer.MIN_VALUE;

				int rodLength = idx + 1;

				if (rodLength <= N)
					take = price[idx] + curr[N - rodLength];

				curr[N] = Math.max(take, notTake);

			}
			prev = curr;
		}

		return prev[n];

	}

	public static int helperMem(int n, int price[]) {
		int dp[][] = new int[n][n + 1];

		for (int N = 0; N <= n; N++) {
			dp[0][N] = N * price[0];
		}

		for (int idx = 1; idx < n; idx++) {
			for (int N = 0; N <= n; N++) {
				int notTake = dp[idx - 1][N];

				int take = Integer.MIN_VALUE;

				int rodLength = idx + 1;

				if (rodLength <= N)
					take = price[idx] + dp[idx][N - rodLength];

				dp[idx][N] = Math.max(take, notTake);

			}
		}

		return dp[n - 1][n];

	}

	public static int helper(int idx, int n, int price[], int dp[][]) {

		if (idx == 0) {
			return n * price[0];
		}

		if (dp[idx][n] != -1)
			return dp[idx][n];

		int notTake = helper(idx - 1, n, price, dp);

		int take = Integer.MIN_VALUE;

		int rodLength = idx + 1;

		if (rodLength <= n)
			take = price[idx] + helper(idx, n - rodLength, price, dp);

		return dp[idx][n] = Math.max(take, notTake);

	}
}