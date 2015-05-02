import algs.math.BigInt;

public class p016 {

	public static void main(String[] args) {
		int pow = 1000;
		BigInt prod = BigInt.ONE;
		for (int i = 0; i < pow; i++)
			prod = prod.multiply(2);
		
		int sum = 0;
		for (Integer k : prod.getDigits())
			sum += k;
		System.out.println(sum);
	}

}
