
import java.util.*;

class WildcardMatching {
	// Helper function to check if all characters from index 0 to i in S1 are '*'
	static boolean isAllStars(String S1, int i) {
		for (int j = 0; j <= i; j++) {
			if (S1.charAt(j) != '*')
				return false;
		}
		return true;
	}

	static int wildcardMatchingUtil(String S1, String S2, int i, int j, int[][] dp) {
		// Base Cases
		if (i < 0 && j < 0)
			return 1; // Both strings are empty, and the pattern matches.
		if (i < 0 && j >= 0)
			return 0; // S1 is empty, but there are characters left in S2.
		if (j < 0 && i >= 0)
			return isAllStars(S1, i) ? 1 : 0; // S2 is empty, check if remaining characters in S1 are all '*'.

		if (dp[i][j] != -1)
			return dp[i][j];

		// If the characters match or S1 has a '?', continue matching the rest of the
		// strings.
		if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?')
			return dp[i][j] = wildcardMatchingUtil(S1, S2, i - 1, j - 1, dp);

		else {
			if (S1.charAt(i) == '*') {
				// Two possibilities when encountering '*':
				// 1. '*' matches one or more characters in S2.
				// 2. '*' matches zero characters in S2.
				return dp[i][j] = (wildcardMatchingUtil(S1, S2, i - 1, j, dp) == 1
						|| wildcardMatchingUtil(S1, S2, i, j - 1, dp) == 1) ? 1 : 0;
			} else {
				// Characters don't match, and S1[i] is not '*'.
				return 0;
			}
		}
	}

	static int wildcardMatching_Memorization(String S1, String S2) {
		int n = S1.length();
		int m = S2.length();

		int dp[][] = new int[n][m];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		return wildcardMatchingUtil(S1, S2, n - 1, m - 1, dp);
	}

	static boolean wildcardMatching_Tabulation(String S1, String S2) {
		int n = S1.length();
		int m = S2.length();

		boolean dp[][] = new boolean[n + 1][m + 1];
		dp[0][0] = true;

		// Initialize the first row and column based on wildcard '*' in S1
		for (int j = 1; j <= m; j++) {
			dp[0][j] = false;
		}
		for (int i = 1; i <= n; i++) {
			dp[i][0] = isAllStars(S1, i);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					if (S1.charAt(i - 1) == '*') {
						dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
					} else {
						dp[i][j] = false;
					}
				}
			}
		}

		return dp[n][m];
	}

	static boolean wildcardMatching_Space(String S1, String S2) {
		int n = S1.length();
		int m = S2.length();

		boolean[] prev = new boolean[m + 1];
		boolean[] cur = new boolean[m + 1];

		prev[0] = true;

		for (int i = 1; i <= n; i++) {
			// Initialize the first element of cur based on whether S1 contains '*'
			cur[0] = isAllStars(S1, i);
			for (int j = 1; j <= m; j++) {
				if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?') {
					cur[j] = prev[j - 1];
				} else {
					if (S1.charAt(i - 1) == '*') {
						cur[j] = prev[j] || cur[j - 1];
					} else {
						cur[j] = false;
					}
				}
			}

			prev = cur.clone();
		}

		return prev[m];
	}

	public static void main(String args[]) {
		String S1 = "ab*cd";
		String S2 = "abdefcd";

		if (wildcardMatching_Memorization(S1, S2) == 1)
			System.out.println("String S1 and S2 do match");
		else
			System.out.println("String S1 and S2 do not match");
	}
}
