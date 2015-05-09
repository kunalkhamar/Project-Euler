/*
In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).

It is possible to make £2 in the following way:

    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

How many different ways can £2 be made using any number of coins?

*/


public class p031 {

	public static void main(String[] args) {
		int N = 200;
		int[] avail = { 1, 2, 5, 10, 20, 50, 100, 200 };
		long[] numWays = new long[N + 1];

		// Using dynamic programming
		numWays[0] = 1;
		for (int j = 0; j < avail.length; j++) {
			for (int i = avail[j]; i <= N; i++) {
				numWays[i] += numWays[i - avail[j]];
			}
		}

		System.out.println(numWays[N]);
	}

}
