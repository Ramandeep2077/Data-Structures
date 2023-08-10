class Solution {
	public int missingNumber(int[] nums) {
		int n = nums.length;
		int i = 0;
		while (i < n) {
			int current = nums[i];
			if (current < n && nums[i] != nums[current]) {
				swap(nums, i, current);
			} else {
				i++;
			}
		}
		for (int index = 0; index < n; index++) {
			if (index != nums[index]) {
				return index;
			}
		}
		return n;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}