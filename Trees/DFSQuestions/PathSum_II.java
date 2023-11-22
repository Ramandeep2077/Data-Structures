class PathSum_II {

	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<Integer> path = new ArrayList<>();

		if (root == null) {
			return ans;
		}

		return helper(root, targetSum, path);
	}

	List<List<Integer>> helper(TreeNode root, int targetSum, List<Integer> path) {

		if (root == null) {
			return null;
		}

		path.add(root.val);

		if (root.val == targetSum && root.left == null && root.right == null) {
			ans.add(new ArrayList<>(path));
		} else {

			helper(root.left, targetSum - root.val, path);
			helper(root.right, targetSum - root.val, path);

		}

		path.remove(path.size() - 1);

		return ans;

	}

}