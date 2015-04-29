import java.util.Arrays;

public class p003 {

	public static void main(String[] args) {
		final long bigNum = 600851475143L;
		final int maxPossibleFactor = (int) (Math.ceil(Math.sqrt(bigNum)));

		// sieve of Eratosthenes
		boolean[] isPrime = new boolean[maxPossibleFactor + 1];
		Arrays.fill(isPrime, true);
		// limit := max possible factor of maxPossibleFactor
		int limit = (int) (Math.ceil(Math.sqrt(maxPossibleFactor)));
		for (int i = 2; i <= limit; i++) {
			if (isPrime[i]) {
				for (int j = i; j <= maxPossibleFactor; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = maxPossibleFactor; i >= 2; i--) {
			if (isPrime[i] && isFactor(bigNum, i)) {
				System.out.println(i);
				break;
			}
		}
	}

	private static boolean isFactor(long dividend, long divisor) {
		return dividend % divisor == 0;
	}

}
