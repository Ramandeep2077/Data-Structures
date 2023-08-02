class Solution {
	// Function to find minimum number of pages.
	public static int findPages(int[] A, int N, int M) {
		// Your code here
		int start = 0;
		int end = 0;

		for (int i : A) {
			start = Math.max(start, i);
			end = end + i;
		}

		if (M > N)
			return -1;

		int ans = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (isPossible(A, mid, M)) {
				end = mid - 1;
				ans = mid;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

	public static boolean isPossible(int[] A, int mid, int k) {
		int sum = 0;
		int st = 1;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];

			if (sum > mid) {
				sum = A[i];
				st++;
			}

		}

		return st <= k;

	}

}