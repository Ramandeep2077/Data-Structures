
import java.util.*;

class DistinctSubseq {
	static int prime = (int) (Math.pow(10, 9) + 7);

	static int countUtil_Memorization(String s1, String s2, int ind1, int ind2, int[][] dp) {

		if (ind2 < 0)
			return 1;

		if (ind1 < 0)
			return 0;

		if (dp[ind1][ind2] != -1)
			return dp[ind1][ind2];

		if (s1.charAt(ind1) == s2.charAt(ind2)) {
			int leaveOne = countUtil_Memorization(s1, s2, ind1 - 1, ind2 - 1, dp);
			int stay = countUtil_Memorization(s1, s2, ind1 - 1, ind2, dp);

			// Add the two possibilities and take modulo prime to avoid integer overflow.
			return dp[ind1][ind2] = (leaveOne + stay) % prime;
		} else {
			return dp[ind1][ind2] = countUtil_Memorization(s1, s2, ind1 - 1, ind2, dp);
		}
	}

	static int subsequenceCounting(String s1, String s2, int lt, int ls) {

		int dp[][] = new int[lt][ls];
		for (int rows[] : dp)
			Arrays.fill(rows, -1);

		return countUtil_Memorization(s1, s2, lt - 1, ls - 1, dp);
	}

	static int subsequenceCounting_Tabulation(String s1, String s2, int n, int m) {

		int dp[][] = new int[n + 1][m + 1];

		// Initialize the first column with 1 because there's one empty subsequence in
		// any string.
		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = 1;
		}

		// Initialize the first row (except dp[0][0]) with 0 because there's no way to
		// form s2 from an empty string.
		for (int i = 1; i < m + 1; i++) {
			dp[0][i] = 0;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % prime;
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][m];
	}

	static int subsequenceCounting_Space(String s1, String s2, int n, int m) {

		int[] prev = new int[m + 1];

		prev[0] = 1;

		for (int i = 1; i < n + 1; i++) {
			for (int j = m; j >= 1; j--) { // Reverse direction for updating

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					prev[j] = (prev[j - 1] + prev[j]) % prime;
				} else {
					// If the characters don't match, we can only exclude this character.
					prev[j] = prev[j]; // This statement is not necessary, as it doesn't change the value.
				}
			}
		}

		return prev[m];
	}

	public static void main(String args[]) {
		String s1 = "babgbag";
		String s2 = "bag";

		System.out.println(
				"The Count of Distinct Subsequences is " + subsequenceCounting(s1, s2, s1.length(), s2.length()));
	}
}
