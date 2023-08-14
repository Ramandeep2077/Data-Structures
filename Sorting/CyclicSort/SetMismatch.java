class Solution {
	public int[] findErrorNums(int[] nums) {
		int i = 0;
		int n = nums.length;
		while (i < n) {
			int current = nums[i] - 1;

			if (nums[i] != nums[current]) {
				swap(nums, i, current);
			} else {
				i++;
			}
		}

		for (int idx = 0; idx < n; idx++) {
			if (nums[idx] != idx + 1) {
				return new int[] { nums[idx], idx + 1 };
			}
		}
		return new int[] { -1, -1 };
	}

	public void swap(int nums[], int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}