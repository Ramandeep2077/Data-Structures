class ValidateBST {

	TreeNode prev;

	/*
	 * Using InOrder approach Time Complexity: O(N), Where N is the number of nodes
	 * in the tree Auxiliary Space: O(H), Here H is the height of the tree and the
	 * extra space is used due to the function call stack.
	 * 
	 */
	public boolean isValidBST(TreeNode root) {

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
		return helper(root, null, null);
	}

	public boolean helper(TreeNode node, Integer low, Integer high) {
    if (node == null) {
      return true;
    }

    if (low != null && node.val <= low) {
      return false;
    }

    if(high != null && node.val >= high) {
      return false;
    }

    boolean leftTree = helper(node.left, low, node.val);
    boolean rightTree = helper(node.right, node.val, high);

    return leftTree && rightTree;
    
  }