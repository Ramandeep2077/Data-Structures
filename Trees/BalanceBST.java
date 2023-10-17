class BalanceBST{
	List<TreeNode> list = new ArrayList<>();

	public TreeNode balanceBST(TreeNode root) {
		inOrder(root);

		return construct(0, list.size() - 1);

	}

	public TreeNode construct(int start, int end) {

		if (start > end)
			return null;

		int mid = start + (end - start) / 2;
		TreeNode root = list.get(mid);

		root.left = construct(start, mid - 1);
		root.right = construct(mid + 1, end);

		return root;

	}

	public void inOrder(TreeNode root) {
		if (root == null)
			return;

		inOrder(root.left);
		list.add(root);
		inOrder(root.right);

	}
}