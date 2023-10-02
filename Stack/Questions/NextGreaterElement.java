class NextGreaterElement{

	public static void main(String args[]) {

		int arr[] = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
		int[] ans = nextLargerElement(arr, arr.length);
		Arrays.stream(ans).forEach(e -> System.out.print(e + " "));

	}

	// Function to find the next greater element for each element of the array.
	public static int[] nextLargerElement(int[] arr, int n) {

		int nge[] = new int[n];
		Stack<Integer> st = new Stack<>();

		st.push(arr[n - 1]);

		nge[n - 1] = -1;

		for (int i = arr.length - 2; i >= 0; i--) {

			while (st.size() > 0 && arr[i] >= st.peek()) {
				st.pop();

			}

			if (st.size() == 0) {
				nge[i] = -1;
			} else {
				nge[i] = st.peek();
			}
			st.push(arr[i]);

		}

		return nge;

	}
}