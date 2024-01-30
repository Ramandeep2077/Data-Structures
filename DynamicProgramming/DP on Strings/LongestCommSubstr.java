
import java.util.*;

class LongestCommSubstr {

	static int lcs_Tabulation(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int[][] dp = new int[n + 1][m + 1];
		int ans = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					int val = 1 + dp[i - 1][j - 1];
					dp[i][j] = val;
					ans = Math.max(ans, val); // Update the maximum LCS length
				} else {
					dp[i][j] = 0; // Reset LCS length if characters don't match
				}
			}
		}

		return ans;
	}

	static int lcs_Space(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int prev[] = new int[m + 1];
		int cur[] = new int[m + 1];

		int ans = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					int val = 1 + prev[j - 1];
					cur[j] = val;
					ans = Math.max(ans, val); // Update the maximum LCS length
				} else {
					cur[j] = 0; // Reset LCS length if characters don't match
				}
			}
			// Update the 'prev' array to the values of 'cur' for the next iteration
			prev = cur.clone();
		}

		return ans;

	}

	public static void main(String args[]) {
		String s1 = "abcjklp";
		String s2 = "acjkp";

		System.out.println("The Length of Longest Common Substring is " + lcs_Tabulation(s1, s2));
	}
}
