class Solution {
	static int computeXOR(int n) {

		if (n % 4 == 0)
			return n;

		if (n % 4 == 1)
			return 1;

		if (n % 4 == 2)
			return n + 1;

		// If n%4 gives remainder 3
		return 0;

	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(computeXOR(n));
	}
}
