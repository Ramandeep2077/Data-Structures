class Solution{

	public static int countSetBits(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n &= (n - 1);
		}
		return count;
	}

	public static int FlippedCount(int a, int b) {
		// Return count of set bits in
		// a XOR b
		return countSetBits(a ^ b);
	}

	// Driver code
	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		System.out.print(FlippedCount(a, b));
	}
}