import java.util.Arrays;


public class p010 {

	public static void main(String[] args) {
		int N = 2000000;
		
		// sieve of Eratosthenes
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		
		int limit = (int) (Math.ceil(Math.sqrt(N)));
		long sum = 0;
		for (int i = 2; i <= limit; i++) {
			if (isPrime[i]) {
				sum += i;
				for (int j = i; j <= N; j += i)
					isPrime[j] = false;
			}
		}
		
		for (int i = limit + 1; i <= N; i++) {
			if (isPrime[i])
				sum += i;
		}
		
		System.out.println(sum);
	}

}
