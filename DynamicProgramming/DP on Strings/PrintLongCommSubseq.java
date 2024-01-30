
import java.util.*;

public class PrintLongCommSubseq {

	public static String findLCS(String s1, String s2) {

		return lcs_Tabulation(s1, s2);

	}

	static String lcs_Tabulation(String s1, String s2) {
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

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		int len = dp[n][m];

		if (len <= 0)
			return "";

		int index = len - 1;

		StringBuilder result = new StringBuilder();

		int i = n, j = m;
		for (int k = 0; k < len; k++) {
			result.append(" "); // Initialize with empty characters
		}

		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				result.setCharAt(index, s1.charAt(i - 1));
				index--;
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {
		String s1 = "abcab", s2 = "cbab";
		String ans = findLCS(s1, s2);
		System.out.println(ans);

	}

}