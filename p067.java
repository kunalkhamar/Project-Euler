import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class p067 {

	private static int[] getIntArray(String[] arr) {
		int[] ints = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ints[i] = Integer.parseInt(arr[i]);
		}
		return ints;
	}

	static int[][] dp;
	static int[][] tri;

	public static void main(String[] args) throws FileNotFoundException {
		int R = 100;
		dp = new int[R][];
		tri = new int[R][];

		Scanner in = new Scanner(new File("./input-files/p067_triangle.txt"));
		for (int i = 0; i < R; i++) {
			String[] line = in.nextLine().trim().split(" ");
			tri[i] = getIntArray(line);
			dp[i] = new int[tri[i].length];
		}
		in.close();

		dp[0][0] = tri[0][0];
		int max = 0;
		for (int j = 0; j < R; j++) {
			max = Math.max(max, getMax(R - 1, j));
		}
		System.out.println(max);
	}

	private static int getMax(int r, int c) {
		if (dp[r][c] > 0)
			return dp[r][c];
		if (c == r) {
			dp[r][c] = tri[r][c] + getMax(r - 1, c - 1);
		} else if (c == 0) {
			dp[r][c] = tri[r][c] + getMax(r - 1, c);
		} else {
			dp[r][c] = tri[r][c]
					+ Math.max(getMax(r - 1, c - 1), getMax(r - 1, c));
		}
		return dp[r][c];
	}

}
