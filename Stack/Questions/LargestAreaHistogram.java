class LargestAreaHistogram {
	public static void main(String[] args) {

		int arr[] = { 6, 2, 5, 4, 5, 1, 6 };
		int n = arr.length;
		int res = largestRect(arr, n);
		System.out.println(res + "");
	}

	static int largestRect(int arr[], int n) {

		int[] rb = new int[arr.length]; // nse on the right
		Stack<Integer> st = new Stack<>();

		st.push(arr.length - 1);
		rb[arr.length - 1] = arr.length;
		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
				st.pop();
			}

			if (st.size() == 0) {
				rb[i] = arr.length;
			} else {
				rb[i] = st.peek();
			}

			st.push(i);
		}

		int[] lb = new int[arr.length]; // nse on the left
		st = new Stack<>();

		st.push(0);
		lb[0] = -1;
		for (int i = 1; i < arr.length; i++) {
			while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
				st.pop();
			}

			if (st.size() == 0) {
				lb[i] = -1;
			} else {
				lb[i] = st.peek();
			}

			st.push(i);
		}

		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			int width = rb[i] - lb[i] - 1;
			int area = width * arr[i];
			if (area > max) {
				max = area;
			}
		}

		return max;

	}

	// Another approach
	public static int largestRectangleArea2(int[] heights) {
		Stack<Integer> st = new Stack<>();
		int max = 0;

		st.push(-1);

		for (int i = 0; i <= heights.length; i++) {
			int val = i == heights.length ? 0 : heights[i];

			while (st.peek() >= 0 && heights[st.peek()] >= val) {
				int h = heights[st.pop()];
				int start = st.peek();
				max = Math.max(max, h * (i - start - 1));
			}
			st.push(i);
		}

		return max;
	}

}
