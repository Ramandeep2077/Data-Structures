class NumArray {
	int[] segmentTree;
	int n;

	/*
	 * Time complexity: O(n) Space complexity: O(n)
	 */
	private void build(int[] nums, int[] segTree, int indexOfRoot, int left, int right) {
		// base case
		if (left == right) {
			segTree[indexOfRoot] = nums[left];
			return;
		}

		// hypothesis
		int mid = left + (right - left) / 2;
		build(nums, segTree, 2 * indexOfRoot + 1, left, mid); // build left subtree
		build(nums, segTree, 2 * indexOfRoot + 2, mid + 1, right); // build right subtree

		// induction
		// for non-leaf nodes, the value equals sum of left child and right child nodes.
		segTree[indexOfRoot] = segTree[2 * indexOfRoot + 1] + segTree[2 * indexOfRoot + 2];
	}

	public NumArray(int[] nums) {
		n = nums.length;
		int count = 0;

		// initialize a segment tree
		segmentTree = new int[4 * n];

		// build the segment tree
		build(nums, segmentTree, 0, 0, n - 1);
	}

	private void updateTree(int[] segTree, int indexOfRoot, int left, int right, int idx, int val) {
		// base case
		if (left == right) {
			segTree[indexOfRoot] = val;
			return;
		}

		// hypothesis
		int mid = left + (right - left) / 2;
		if (idx <= mid)
			updateTree(segTree, 2 * indexOfRoot + 1, left, mid, idx, val);
		else
			updateTree(segTree, 2 * indexOfRoot + 2, mid + 1, right, idx, val);

		// induction step - updating the parent as the children got updated
		segTree[indexOfRoot] = segTree[2 * indexOfRoot + 1] + segTree[2 * indexOfRoot + 2];
	}

	/*
	 * Time complexity: O(logn) Space complexity: O(1)
	 */
	public void update(int index, int val) {
		updateTree(segmentTree, 0, 0, n - 1, index, val);
	}

	public int sumRangeTree(int[] segTree, int indexOfRoot, int low, int high, int left, int right) {
		// base cases
		// if the node [low, high] completely lies in the range [left, right]
		if (low >= left && high <= right)
			return segTree[indexOfRoot];

		// if the node [low, high] doesn't lie in the range [left, right]
		if (high < left || low > right)
			return 0;

		// hypothesis
		// now we know the node [low, high] overlaps with the range [left, right]
		int mid = low + (high - low) / 2;

		int leftSum = sumRangeTree(segTree, 2 * indexOfRoot + 1, low, mid, left, right);
		int rightSum = sumRangeTree(segTree, 2 * indexOfRoot + 2, mid + 1, high, left, right);

		// induction
		return leftSum + rightSum;
	}

	/*
	 * Time complexity: O(logn) Space complexity: O(1)
	 */
	public int sumRange(int left, int right) {
		return sumRangeTree(segmentTree, 0, 0, n - 1, left, right);
	}
}