class Solution {
	static int singleElement(int[] nums, int N) {

		int ones = 0;
		int twos = 0;
		for (int i : nums) {
			// add it to the ones if it is not there in ones and twos.(first occurance)
			// remove it from the ones if it is already there. (second occurance)
			ones = (ones ^ i) & ~twos;
			// add it to the twos if it is not there in twos and ones(second occurance)
			// remove it from the twos if it is already there(third occurance)
			twos = (twos ^ i) & ~ones;
		}
		return ones;
	}

	public static void main(String args[]) {

		int N = 4;
		int arr[] = { 2, 2, 3, 2 };

		System.out.println(singleElement(arr, N));

	}

}