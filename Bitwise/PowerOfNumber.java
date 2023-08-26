public class Solution {
	public static void main(String[] args) {
		int base = 2;
		int power = 3;
		int ans = 1;
		while (power > 0) {
			if ((power & 1) == 1) {
				// if == 0 there is no point to calculate ans
				ans = ans * base;
			}
			base = base * base;
			// keep dividing power by 2 using right shift
			power = power >> 1;
		}
		System.out.println(ans);
	}
}
