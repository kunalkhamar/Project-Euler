/*
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */


import java.math.BigInteger;

public class p048 {

	public static void main(String[] args) {
		final int N = 1000;
		
		BigInteger mod = new BigInteger("10000000000"); // 10 digits
		BigInteger sum = BigInteger.ZERO;
		
		for (int i = 1; i <= N; i++) {
			BigInteger t = new BigInteger(Integer.toString(i));
			t = t.modPow(t, mod);
			sum = sum.add(t);
		}
		
		sum = sum.mod(mod);
		System.out.println(sum);
	}

}
