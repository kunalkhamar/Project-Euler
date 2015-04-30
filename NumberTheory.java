/**
 * Some of the number theory functions
 * that come up often
 */

import java.util.HashMap;
import java.util.Map;

public class NumberTheory {

	// a prime factorization (p.f.) is of form
	// { (p_1 => count(p_1)), (p_2 => count(p_2)), ... , (p_k => count(p_k)) }
	// where p_1 ... p_k are the prime factors of n
	// 1 and n itself do not appear in the p.f.
	protected static Map<Integer, Integer> getPrimeFactorization(int n) {
		Map<Integer, Integer> factors = new HashMap<>();
		if (n == 1) {
			factors.put(1, 1);
			return factors;
		}
		
		int max = (int) Math.ceil(Math.sqrt(n));
		for (int i = 2; i <= max; i++) {
			int occur = 0;
			while (n % i == 0) {
				n /= i;
				occur++;
			}
			if (occur > 0)
				factors.put(i, occur);
		}
		if (n > 1)
			factors.put(n, 1);
		return factors;
	}

	protected static int getNumFactors(int n) {
		return getNumFactors(getPrimeFactorization(n));
	}

	// pf is a prime factorization
	protected static int getNumFactors(Map<Integer, Integer> pf) {
		int num = 1;
		for (Integer v : pf.values())
			num *= (v + 1);
		return num;
	}

}
