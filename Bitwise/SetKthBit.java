class Solution{

	static int setKthBit(int n, int k) {

		int mask = 1 << k;

		return (mask | n);
	}


	public static void main(String arg[]) {
		int n = 10, k = 2;
		System.out.print("Kth bit set number = " + setKthBit(n, k));
	}
}
