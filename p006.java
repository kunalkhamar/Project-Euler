
public class p006 {

	public static void main(String[] args) {
		int N = 100;
		int smaller = sumOfFirstNSquares(N);
		int larger = sumOfFirstN(N);
		larger *= larger;
		
		System.out.println(larger - smaller);
	}

	private static int sumOfFirstN(int n) {
		return (n * (n + 1)) / 2;
	}
	
	private static int sumOfFirstNSquares(int n) {
		return (n * (n + 1) * (2 * n + 1)) / 6;
	}
}
