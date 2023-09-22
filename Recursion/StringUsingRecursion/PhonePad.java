class PhonePad {

	public static void main(String args[]) {

		System.out.println(letterCombinations("23"));

		int count = countLetterCombinations("", "23");
		System.out.println(count);
	}

	public static List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();
		if (digits.isEmpty()) {
			return ans;
		}

		ans = helper("", digits);
		return ans;
	}

	public static List<String> helper(String p, String up) {
		List<String> ans = new ArrayList<>();
		if (up.isEmpty()) {
			List<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		int digit = up.charAt(0) - '0';
		if (digit >= 2 && digit <= 6) {
			// loop for digits 2 to 6
			for (int i = (digit - 2) * 3; i <= ((digit - 1) * 3) - 1; i++) {
				char ch = (char) ('a' + i);
				ans.addAll(helper(p + ch, up.substring(1)));
			}
		} else if (digit == 7) {
			// for 7
			for (int i = (digit - 2) * 3; i < ((digit - 1) * 3) + 1; i++) {
				char ch = (char) ('a' + i);
				ans.addAll(helper(p + ch, up.substring(1)));
			}
		} else if (digit == 9) {
			// for 9
			for (int i = (digit - 2) * 3 + 1; i <= ((digit - 1) * 3) + 1; i++) {
				char ch = (char) ('a' + i);
				ans.addAll(helper(p + ch, up.substring(1)));
			}
		} else {
			// for 8
			for (int i = (digit - 2) * 3 + 1; i < ((digit - 1) * 3) + 1; i++) {
				char ch = (char) ('a' + i);
				ans.addAll(helper(p + ch, up.substring(1)));
			}
		}

		return ans;
	}

	public static int countLetterCombinations(String p, String up) {

		if (up.isEmpty()) {

			return 1;
		}
		int digit = up.charAt(0) - '0';

		int count = 0;
		if (digit >= 2 && digit <= 6) {
			// loop for digits 2 to 6
			for (int i = (digit - 2) * 3; i <= ((digit - 1) * 3) - 1; i++) {
				char ch = (char) ('a' + i);

				count += countLetterCombinations(p + ch, up.substring(1));
			}
		} else if (digit == 7) {
			// for 7
			for (int i = (digit - 2) * 3; i < ((digit - 1) * 3) + 1; i++) {
				char ch = (char) ('a' + i);
				count += countLetterCombinations(p + ch, up.substring(1));
			}
		} else if (digit == 9) {
			// for 9
			for (int i = (digit - 2) * 3 + 1; i <= ((digit - 1) * 3) + 1; i++) {
				char ch = (char) ('a' + i);

				count += countLetterCombinations(p + ch, up.substring(1));
			}
		} else {
			// for 8
			for (int i = (digit - 2) * 3 + 1; i < ((digit - 1) * 3) + 1; i++) {
				char ch = (char) ('a' + i);
				count += countLetterCombinations(p + ch, up.substring(1));
			}
		}
		return count;
	}
}