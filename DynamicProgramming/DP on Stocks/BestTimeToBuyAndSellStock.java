import java.util.*;

class BestTimeToBuyAndSellStock {
	static int maximumProfit(int[] Arr) {

		int maxProfit = 0;
		int mini = Arr[0];

		for (int i = 1; i < Arr.length; i++) {
			int curProfit = Arr[i] - mini;
			maxProfit = Math.max(maxProfit, curProfit);
			mini = Math.min(mini, Arr[i]);
		}
		return maxProfit;
	}

	public static void main(String args[]) {

		int[] Arr = { 7, 1, 5, 3, 6, 4 };

		System.out.println("The maximum profit by selling the stock is " + maximumProfit(Arr));
	}
}