public class BubbleSort{

	static void bubbleSort(int arr[], int n) {

		if (n == 1)
			return;

		int count = 0;

		for (int i = 0; i < n - 1; i++)
			if (arr[i] > arr[i + 1]) {
				// swap arr[i], arr[i+1]
				swap(arr, i, i + 1);
				count = count + 1;
			}

		// Check if any recursion happens or not
		// If any recursion is not happen then return
		if (count == 0)
			return;

		// Largest element is fixed,
		// recur for remaining array
		bubbleSort(arr, n - 1);
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };

		bubbleSort(arr, arr.length);

		System.out.println("Sorted array : ");
		System.out.println(Arrays.toString(arr));
	}
}
