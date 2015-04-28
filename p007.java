import java.util.HashSet;
import java.util.Set;


public class p007 {

	public static void main(String[] args) {
		int N = 10001;
		
		// there are about x/ln(x) primes smaller than x
		// x/ln(x) = N = 10001
		// We search for x such that x/ln(x) >= 2*N
		int x = N;
		while ((x / Math.log(x)) < 2 * N) {
			x += N;  // add N for quicker approximate
		}
//		System.out.println("x = " + x);
		
		// sieve of Eratosthenes, set form
		Set<Integer> composites = new HashSet<Integer>();
		
		int limit = (int) (Math.ceil(Math.sqrt(x)));
		int latestPrime = 2;
		int numPrimes = 0;
		for (int i = 2; i < limit && numPrimes < N; i++) {
			if (!composites.contains(i)) {
				numPrimes++;
				latestPrime = i;
				for (int j = i; j <= x; j += i) {
					composites.add(j);
				}
			}
		}
		
		for (int i = limit; i <= x && numPrimes < N; i++) {
			if (!composites.contains(i)) {
				latestPrime = i;
				numPrimes++;
			}
		}
		System.out.println(latestPrime);
	}

}
