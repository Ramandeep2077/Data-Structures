class RotateArray {
	public void rotate(int[] nums, int k) {

		k = k % nums.length;
		int n = nums.length - 1;

		reverse(nums, 0, n);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n);

	}

	public void reverse(int nums[], int s, int e) {

		while (s < e) {
			int temp = nums[s];
			nums[s] = nums[e];
			nums[e] = temp;
			s++;
			e--;
		}
	}
}