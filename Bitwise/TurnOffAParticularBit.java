class Solution
{
	// Function to returns a number that has all bits same as n
	// except the k'th bit which is made 0
	static int turnOffK(int n, int k)
	{
		// k must be greater than 0
		if (k <= 0)
			return n;

		// Do & of n with a number with all set bits except
		// the k'th bit
                int offMask = ~(1 << (k - 1));
		return (n & offMask);
	}
	
	
	public static void main (String[] args)
	{
		int n = 15;
		int k = 4;
		System.out.println(turnOffK(n, k));
	}
}
// Contributed by Pramod Kumar
