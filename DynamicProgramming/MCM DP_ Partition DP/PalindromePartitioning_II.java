import java.util.Arrays;

public class PalindromePartitioning_II {
	static boolean isPalindrome(int i, int j, String s) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	static int f(int i, int n, String str, int[] dp) {
		// Base case:
		if (i == n)
			return 0;

		if (dp[i] != -1)
			return dp[i];
		int minCost = Integer.MAX_VALUE;
		// String[i...j]
		for (int j = i; j < n; j++) {
			if (isPalindrome(i, j, str)) {
				int cost = 1 + f(j + 1, n, str, dp);
				minCost = Math.min(minCost, cost);
			}
		}
		return dp[i] = minCost;
	}

	static int palindromePartitioning_Memorization(String str) {
		int n = str.length();
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		return f(0, n, str, dp) - 1;
	}

	static int palindromePartitioning_Tabulation(String str) {
		int n = str.length();
		int[] dp = new int[n + 1];
		dp[n] = 0;
		for (int i = n - 1; i >= 0; i--) {
			int minCost = Integer.MAX_VALUE;
			// String[i...j]
			for (int j = i; j < n; j++) {
				if (isPalindrome(i, j, str)) {
					int cost = 1 + dp[j + 1];
					minCost = Math.min(minCost, cost);
				}
			}
			dp[i] = minCost;
		}
		return dp[0] - 1;
	}

	public static void main(String[] args) {
		String str = "BABABCBADCEDE";
		int partitions = palindromePartitioning_Memorization(str);
		System.out.println("The minimum number of partitions: " + partitions);
	}
}
