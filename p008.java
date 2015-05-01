import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class p008 {

	public static void main(String[] args) throws FileNotFoundException {
		int[] bigNum = new int[1000];

		Scanner in = new Scanner(new File("./input-files/p008.txt"));
		int index = 0;
		while (in.hasNextLine()) {
			String input = in.nextLine().trim();
			int[] ints = getIntArray(input.toCharArray());
			for (int i = 0; i < ints.length; i++) {
				bigNum[index++] = ints[i];
			}
		}
		in.close();

		long max = 1;
		for (int i = 0; i < 1000 - 13; i++) {
			long cur = 1;
			for (int j = i; j < i + 13; j++)
				cur *= bigNum[j];
			if (cur > max)
				max = cur;
		}

		System.out.println(max);
	}

	private static int[] getIntArray(char[] arr) {
		int[] a = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[i] = arr[i] - '0';
		}
		return a;
	}

}
