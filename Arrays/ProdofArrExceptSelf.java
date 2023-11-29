class ProdofArrExceptSelf {
	public int[] productExceptSelf(int[] nums) {

		int n = nums.length;
		int prod = 1;

		int left[] = new int[n];

		for (int i = 0; i < n; i++) {
			prod = prod * nums[i];
			left[i] = prod;
		}

		prod = 1;

		for (int i = n - 1; i > 0; i--) {

			left[i] = left[i - 1] * prod;
			prod = nums[i] * prod;
		}

		left[0] = prod;

		return left;

	}
}