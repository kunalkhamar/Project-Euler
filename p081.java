import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class p081 {

	public static void main(String[] args) throws FileNotFoundException {
		int N = 80;
		
		Scanner in = new Scanner(new File("./input-files/p081_matrix.txt"));
		int[][] input = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] line = in.nextLine().trim().split(",");
			for (int j = 0; j < line.length; j++) {
				input[i][j] = Integer.parseInt(line[j].trim());
			}
		}
		in.close();

		// use dynamic programming
		int[][] pathSum = new int[N][N];
		pathSum[0][0] = input[0][0];

		// init left-most column
		for (int i = 1; i < N; i++)
			pathSum[i][0] = pathSum[i - 1][0] + input[i][0];
		// init top-most row
		for (int j = 1; j < N; j++)
			pathSum[0][j] = pathSum[0][j - 1] + input[0][j];
		
		// rest of the table
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				pathSum[i][j] = input[i][j] + Math.min(pathSum[i - 1][j], pathSum[i][j - 1]);
			}
		}

		System.out.println(pathSum[N - 1][N - 1]);
	}

}
