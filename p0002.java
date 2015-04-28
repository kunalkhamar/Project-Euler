public class p0002 {

	public static void main(String[] args) {
		final int MAX_FIB = 4000000;
		int fibOne = 1;
		int fibTwo = 2;

		int sum = 0;
		for (int i = 0; fibTwo <= MAX_FIB; i++) {
			// even fibs are at positions congruent to 1 (mod 3)
			if (i % 3 == 0)		// if position is 0 (mod 3), then fibTwo will be at 1 (mod 3)
				sum += fibTwo;
			
			int nextFib = fibOne + fibTwo;
			fibOne = fibTwo;
			fibTwo = nextFib;
		}
		
		System.out.println(sum);
	}

}
