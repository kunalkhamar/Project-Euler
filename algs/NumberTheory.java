/**
 * Some number theoretic data structures and algorithms
 * that come up often
 */

package algs;

public class NumberTheory {
	
	// Euclidean GCD
	public static int gcd(int a, int b) {
		return (b == 0 ? a : gcd(b, a % b));
	}
	
	public static long combinations(int n, int k) {
		if (k < n - k)
			k = n - k;
		PrimeFact numerator = new PrimeFact(1);
		for (int i = n; i > k; i--)
			numerator = numerator.multiplyPF(new PrimeFact(i));
		
		PrimeFact denominator = new PrimeFact(1);
		for (int i = 1; i <= n - k; i++)
			denominator = denominator.multiplyPF(new PrimeFact(i));
		
		PrimeFact answer = numerator.dividePF(denominator);
		return answer.getNumber();
	}

}
