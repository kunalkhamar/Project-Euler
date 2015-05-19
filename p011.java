import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class p011 {

	public static void main(String[] args) throws FileNotFoundException {
		final int N = 20;
		Scanner in = new Scanner(new File("./input-files/p011.txt"));
		int[][] data = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] line = in.nextLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(line[j]);
			}
		}
		in.close();
		
		int best = 1;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				best = Math.max(best, getBestProd(data, i, j));
		
		System.out.println(best);
	}
	
	private static  int getBestProd(int[][] arr, int r, int c) {
		return Math.max(getVertical(arr, r, c), 
				 Math.max(getHorizontal(arr, r, c), getDiagonal(arr, r, c)));
	}
	
	private static int getVertical(int[][] arr, int r, int c) {
		int prod = 1;
		for (int i = r; i < r + 4; i++) {
			if (i >= arr.length) break;
			prod *= arr[i][c];
		}
		return prod;
	}
	
	private static int getHorizontal(int[][] arr, int r, int c) {
		int prod = 1;
		for (int j = c; j < c + 4; j++) {
			if (j >= arr[r].length) break;
			prod *= arr[r][j];
		}
		return prod;
	}
	
	private static int getDiagonal(int[][] arr, int r, int c) {
		int diagA = 1;
		for (int d = 0; d < 4; d++) {
			if (r + d >= arr.length || c + d >= arr[r].length)
				break;
			diagA *= arr[r + d][c + d];
		}
		
		int diagB = 1;
		for (int d = 0; d < 4; d++) {
			if (r + d >= arr.length || c - d < 0) break;
			diagB *= arr[r + d][c - d];
		}
		
		return Math.max(diagA, diagB);
	}

}
