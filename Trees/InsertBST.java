/*
The worst-case time complexity of insert operations is O(h) where h is the height of the Binary Search Tree. 
In the worst case, we may have to travel from the root to the deepest leaf node. The height of a skewed tree may become n and the time complexity of insertion operation may become O(n). 

Auxiliary Space: The auxiliary space complexity of insertion into a binary search tree is O(1)

*/
class InsertBST {
	public TreeNode insertIntoBST(TreeNode root, int val) {

		if (root == null) {
			return new TreeNode(val);
		}

		if (val < root.val) {
			root.left = insertIntoBST(root.left, val);
		}

		if (val > root.val) {
			root.right = insertIntoBST(root.right, val);
		}

		return root;

	}
}