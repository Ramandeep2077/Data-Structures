class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {

		int top = 0;
		int left = 0;
		int right = matrix[0].length - 1;
		int bottom = matrix.length - 1;

		List<Integer> ans = new ArrayList<>();

		while (left <= right && top <= bottom) {

			// top
			for (int i = left; i <= right; i++) {
				ans.add(matrix[top][i]);
			}
			top++;
			// down
			for (int i = top; i <= bottom; i++) {
				ans.add(matrix[i][right]);
			}
			right--;

			// left
			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					ans.add(matrix[bottom][i]);
				}
				bottom--;

			}

			// up
			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					ans.add(matrix[i][left]);
				}
				left++;
			}
		}
		return ans;
	}
}