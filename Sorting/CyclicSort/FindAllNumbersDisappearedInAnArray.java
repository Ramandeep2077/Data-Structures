class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {

		int n = nums.length;
		int i = 0;
		while (i < n) {
			int current = nums[i] - 1;
			if (nums[i] != nums[current]) {
				swap(nums, i, current);
			} else {
				i++;
			}
		}

		List<Integer> ans = new ArrayList<>();

		for (int idx = 0; idx < n; idx++) {
			if (nums[idx] != idx + 1) {
				ans.add(idx + 1);
			}
		}

		return ans;

	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
