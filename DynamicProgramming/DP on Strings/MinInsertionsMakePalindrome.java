
import java.util.*;

class MinInsertionsMakePalindrome {

	static int lcs(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int dp[][] = new int[n + 1][m + 1];

		for (int rows[] : dp)
			Arrays.fill(rows, -1);

		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= m; i++) {
			dp[0][i] = 0;
		}

		for (int ind1 = 1; ind1 <= n; ind1++) {
			for (int ind2 = 1; ind2 <= m; ind2++) {
				if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
					dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
				else
					dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
			}
		}

		return dp[n][m];
	}

	static int longestPalindromeSubsequence(String s) {

		String reversed = new StringBuilder(s).reverse().toString();

		return lcs(s, reversed);
	}

	static int minInsertion_Tabulation(String s) {
		int n = s.length();
		int k = longestPalindromeSubsequence(s);

		// The minimum insertions required is the difference between the string length
		// and its
		// Longest Palindromic Subsequence length
		return n - k;
	}

	static int lcs_Space(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int[] prev = new int[m + 1];
		int[] cur = new int[m + 1];

		for (int ind1 = 1; ind1 <= n; ind1++) {
			for (int ind2 = 1; ind2 <= m; ind2++) {
				if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
					cur[ind2] = 1 + prev[ind2 - 1];
				else
					cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
			}

			// Update prev array to store the current values using a clone of cur
			prev = cur.clone();
		}

		return prev[m];
	}

	public static void main(String args[]) {
		String s = "abcaa";
		System.out.println(
				"The Minimum insertions required to make the string palindrome: " + minInsertion_Tabulation(s));
	}
}
