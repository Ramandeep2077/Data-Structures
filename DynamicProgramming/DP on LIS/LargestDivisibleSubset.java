class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] arr) {

		// Write Your Code Here
		int n = arr.length;
		int dp[] = new int[n];

		int hash[] = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(hash, 1);

		Arrays.sort(arr);

		for (int idx = 0; idx <= n - 1; idx++) {
			hash[idx] = idx;
			for (int prevIdx = 0; prevIdx <= idx - 1; prevIdx++) {

				if (arr[idx] % arr[prevIdx] == 0 && 1 + dp[prevIdx] > dp[idx]) {

					dp[idx] = 1 + dp[prevIdx];
					hash[idx] = prevIdx;
				}

			}
		}

		int lastIdx = -1;
		int ans = -1;

		for (int i = 0; i <= n - 1; i++) {
			if (dp[i] > ans) {
				ans = dp[i];
				lastIdx = i;
			}
		}

		List<Integer> temp = new ArrayList<>();
		temp.add(arr[lastIdx]);

		while (hash[lastIdx] != lastIdx) {
			lastIdx = hash[lastIdx];
			temp.add(arr[lastIdx]);
		}
		Collections.reverse(temp);

		return temp;

	}
}