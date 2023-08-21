public class Solution {
	public static void main(String[] args) {
		int number = 42; 
		int i = 2; // Bit position to clear (0-indexed)

		// Create a mask with the i-th bit set to 0 and all other bits set to 1
		int mask = ~(1 << i);

		// Use bitwise AND to clear the i-th bit
		int clearedNumber = number & mask;

		System.out.println("The number after clearing the " + i + "-th bit: " + clearedNumber);
	}
}
