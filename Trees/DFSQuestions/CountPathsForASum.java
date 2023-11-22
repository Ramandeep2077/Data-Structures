class Sum_III {
	List<Integer> path = new ArrayList<>();return

	helper(node, sum, path);
}

	int helper(Node node, int sum, List<Integer> path) {
		if (node == null) {
			return 0;
		}

		path.add(node.val);
		int count = 0;
		int s = 0;
// how many paths I can make
		ListIterator<Integer> itr = path.listIterator(path.size());
		while (itr.hasPrevious()) {
			s += itr.previous();

			if (s == sum) {
				count++;
			}
		}

		count += helper(node.left, s, path) + helper(node.right, sum, path);

// backtrack
		path.remove(path.size() - 1);
		return count;

	}
}