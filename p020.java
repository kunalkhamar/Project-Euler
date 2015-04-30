/**
 * Factorial digit sum
 * 
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class p020 {

	public static void main(String[] args) {
		final int N = 100;
		int countTwo = 0, countFive = 0;
		
		Map<Integer, Integer> pf = new HashMap<>();
		for (int i = 2; i <= N; i++) {
			Map<Integer, Integer> pf_i = NumberTheory.getPrimeFactorization(i);
			for (Map.Entry<Integer, Integer> e : pf_i.entrySet()) {
				if (pf.containsKey(e.getKey())) {
					pf.put(e.getKey(), e.getValue() + pf.get(e.getKey()));
				} else {
					pf.put(e.getKey(), e.getValue());
				}
				if (e.getKey().intValue() == 2)
					countTwo += e.getValue();
				if (e.getKey().intValue() == 5)
					countFive += e.getValue();
			}
		}

		int numTrailingZeroes = Math.min(countTwo, countFive);
		pf.put(5, pf.get(5) - numTrailingZeroes);
		pf.put(2, pf.get(2) - numTrailingZeroes);
		
		BigInteger p = BigInteger.ONE;
		for (Map.Entry<Integer, Integer> e : pf.entrySet()) {
			BigInteger base = new BigInteger("" + e.getKey());
			p = p.multiply(base.pow(e.getValue()));
		}
		
		System.out.println(getDigitSum(p.toString()));
	}

	private static int getDigitSum(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++)
			sum += (int) (str.charAt(i) - '0');
		return sum;
	}

}
