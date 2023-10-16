class ValidateBST {

	TreeNode prev;

	/*
	 * Using InOrder approach Time Complexity: O(N), Where N is the number of nodes
	 * in the tree Auxiliary Space: O(H), Here H is the height of the tree and the
	 * extra space is used due to the function call stack.
	 * 
	 */public boolean isValidBST(TreeNode root) {

		if (root == null) {
			return true;
		}

		if (!isValidBST(root.left)) {
			return false;
		}

		if (prev != null && root.val <= prev.val) {
			return false;
		}

		prev = root;
		return isValidBST(root.right);

	}

	/*
	 * Using another approax - Min and Max Time Complexity: O(N), Where N is the
	 * number of nodes in the tree Auxiliary Space: O(1), if Function Call Stack
	 * size is not considered, otherwise O(H) where H is the height of the tree
	 * 
	 */ 
        public boolean isValidBST2(TreeNode root) {

		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

	}

	public boolean isValidBST(TreeNode root, long min, long max) {

		if (root == null)
			return true;

		if (root.val <= min || root.val >= max) {
			return false;
		}

		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);

	}
}
