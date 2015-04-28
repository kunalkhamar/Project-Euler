import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class p013 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("p013.txt"));
		BigInteger[] nums = new BigInteger[100];
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < 100; i++) {
			String input = in.nextLine().trim();
			nums[i] = new BigInteger(input);
			sum = sum.add(nums[i]);
		}
		in.close();
		System.out.println(sum.toString().substring(0, 10));
	}

}
