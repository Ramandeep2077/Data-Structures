class Solution {
	public List<Integer> findDuplicates(int[] nums) {
		int i = 0;
		int n = nums.length;

		while (i < n) {
			int correct = nums[i] - 1;
			if (nums[i] != nums[correct]) {
				swap(nums, i, correct);
			} else {
				i++;
			}
		}

		List<Integer> ans = new ArrayList<>();
		for (int index = 0; index < nums.length; index++) {
			if (nums[index] != index + 1) {
				ans.add(nums[index]);
			}
		}
		return ans;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
}
