/*
Find the unique positive integer whose square has the form 1_2_3_4_5_6_7_8_9_0,
where each “_” is a single digit.
 */

public class p206 {

	public static void main(String[] args) {
		for (long i = 1200000000; i < 1400000000; i += 10) {
			if (isMatching(i * i)) {
				System.out.println(i);
				break;
			}
		}
	}
	
	private static boolean isMatching(long n) {
		int[] digits = { 1,2,3,4,5,6,7,8,9,0 };
		String s = Long.toString(n);
		boolean match = true;
		for (int i = 0, ind = 0, len = s.length(); i < digits.length && match; i++, ind += 2) {
			if (ind >= len || s.charAt(ind) != (char) (digits[i] + '0')) {
				match = false;
				break;
			}
		}
		return match;
	}

}
