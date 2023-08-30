//Java program to toggle
//k-th bit of a number

class Solution {
	static int toggleKthBit(int n, int k) {
		int b = 1 << (k - 1);

		return (n ^ b);
	}

	public static void main(String[] args) {
		int n = 5, k = 1;
		System.out.println(toggleKthBit(n, k));
	}
}
