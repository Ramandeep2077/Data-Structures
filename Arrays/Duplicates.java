// Two approaches
public class Duplicates{

	// First Approach
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; ++i) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0)
				res.add(Math.abs(nums[i]));
			nums[index] = -nums[index];
		}
		return res;
	}

	// Second approach
	public static List<Integer> findDuplicates2(int[] arr) {
		List<Integer> duplicates = new ArrayList<>();
		int n = arr.length;

		// First check all the values that are present in
		// the array then go to those values as indices and
		// increment by the size of the array
		for (int i = 0; i < n; i++) {
			int index = arr[i] % n;
			arr[index] += n;
		}

		// Now check which value exists more than once by
		// dividing with the size of the array
		for (int i = 0; i < n; i++) {
			if (arr[i] / n >= 2) {
				duplicates.add(i);
			}
		}
		return duplicates;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 6, 3, 1, 3, 6, 6 };

		System.out.println("The repeating elements are: ");
		List<Integer> ans = findDuplicates(arr);
		for (int x : ans) {
			System.out.print(x + " ");
		}
	}
}
