class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {

		int rowIdx = searchPotentialRow(matrix, target);

		return rowIdx == -1 ? false : binarySearchOverRow(rowIdx, matrix, target);
	}

	public int searchPotentialRow(int[][] matrix, int target) {
		int low = 0;
		int high = matrix.length - 1;
		int lIdx = matrix[0].length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;

			if (matrix[mid][0] <= target && target <= matrix[mid][lIdx]) {
				return mid;
			} else if (matrix[mid][0] < target) {
				low = mid + 1;
			} else if (matrix[mid][0] > target) {
				high = mid - 1;
			}
		}
		return -1;
	}

	public boolean binarySearchOverRow(int rowIdx, int[][] matrix, int target) {

		int low = 0;
		int high = matrix[rowIdx].length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (matrix[rowIdx][mid] == target) {
				return true;
			} else if (matrix[rowIdx][mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}

}