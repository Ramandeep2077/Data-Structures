class Solution {
	
	static void quickSort(int arr[], int low, int high) {
		if (low < high) {

			int p = partition(arr, low, high);

			quickSort(arr, low, p - 1);
			quickSort(arr, p + 1, high);

		}
	}

	static int partition(int arr[], int low, int high) {
		int i = low;
		int j = low;
		int pivot = arr[high];
		while (i <= high) {
			if (arr[i] <= pivot) {
				swap(arr, i, j);
				j++;
			}
			i++;
		}
		return j - 1;
	}

	static void swap(int arr[], int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
