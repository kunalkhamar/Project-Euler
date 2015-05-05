import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class p022 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("./input-files/p022_names.txt"));
		
		String[] names = in.nextLine().split("\",\"");
		in.close();

		int len = names.length;
		names[0] = names[0].substring(1, names[0].length());
		names[len - 1] = names[len - 1].substring(0, names[len - 1].length() - 1);
		Arrays.sort(names);

		long score = 0;
		for (int i = 0; i < len; i++)
			score += (i + 1) * score(names[i]);
		System.out.println(score);
	}
	
	private static int score(String s) {
		int scr = 0;
		for (int i = 0, len = s.length(); i < len; i++) {
			scr += (int) (s.charAt(i) - 'A' + 1);
		}
		return scr;
	}

}
