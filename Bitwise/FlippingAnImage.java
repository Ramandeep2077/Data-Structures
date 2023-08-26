class Solution {
	public static void main(String[] args) {

		int[][] mat = { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } };

		int[][] matrix = flipped_Invert_Image(mat);
		for (int[] matele : matrix) {
			System.out.print(Arrays.toString(matele));
		}
	}

	public static int[][] flipped_Invert_Image(int[][] A) {
		int C = A[0].length;
		for (int[] row : A)
			for (int i = 0; i < (C + 1) / 2; ++i) {
				int tmp = row[i] ^ 1;
				row[i] = row[C - 1 - i] ^ 1;
				row[C - 1 - i] = tmp;
			}

		return A;
	}
}