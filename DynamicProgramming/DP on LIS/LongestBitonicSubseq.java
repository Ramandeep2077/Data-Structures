import java.util.*;

public class LongestBitonicSubseq {
	public static int longestBitonicSequence(int[] arr, int n) {
		// Write your code here.

		int dp1[] = new int[n];
		int dp2[] = new int[n];
		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);

		for (int idx = 0; idx < n; idx++) {

			for (int prevIdx = 0; prevIdx < idx; prevIdx++) {

				if (arr[prevIdx] < arr[idx] && 1 + dp1[prevIdx] > dp1[idx]) {
					dp1[idx] = 1 + dp1[prevIdx];
				}
			}
		}

		int maxi = 0;
		for (int idx = n - 1; idx >= 0; idx--) {

			for (int prevIdx = n - 1; prevIdx > idx; prevIdx--) {

				if (arr[prevIdx] < arr[idx] && 1 + dp2[prevIdx] > dp2[idx]) {
					dp2[idx] = 1 + dp2[prevIdx];

				}

			}
		}

		for (int idx = 0; idx < n; idx++) {
			maxi = Math.max(maxi, dp1[idx] + dp2[idx] - 1);
		}

		return maxi;
	}
}
