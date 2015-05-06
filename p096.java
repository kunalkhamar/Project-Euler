import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import algs.math.Sudoku;

public class p096 {

	public static void main(String[] args) throws FileNotFoundException {
		int N = 50;
		Scanner in = new Scanner(new File("./input-files/p096_sudoku.txt"));

		int sum = 0;
		char[][] puzzle;
		for (int grid = 0; grid < N; grid++) {
			puzzle = new char[9][9];

			in.nextLine();
			for (int i = 0; i < 9; i++)
				puzzle[i] = in.nextLine().trim().toCharArray();

			Sudoku s = new Sudoku(puzzle);
			s.solve();
			char[][] sol = s.getSolution();
			sum += 100 * Character.getNumericValue(sol[0][0]) + 
					10 * Character.getNumericValue(sol[0][1]) + 
						 Character.getNumericValue(sol[0][2]);
		}
		
		System.out.println(sum);
		in.close();
	}

}