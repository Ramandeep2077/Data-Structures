class Solution {
	public static void isKthBitSet(int n, int k) {

		int mask = 1 << k;
		if ((n & mask) != 0)
			System.out.print("SET");
		else
			System.out.print("NOT SET");
	}

	public static void main(String[] args) {
		int n = 5, k = 1;
		isKthBitSet(n, k);
	}

}
