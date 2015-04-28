public class p005 {

	public static void main(String[] args) {
		int ans = 1;
		
		for (int i = 2; i <= 20; i++) {
			ans = lcm(i, ans);
		}

		System.out.println(ans);
	}

	// Euclidean GCD
	private static int gcd(int a, int b) {
		return (b == 0 ? a : gcd(b, a % b));
	}

	private static int lcm(int a, int b) {
		return (a / gcd(a, b)) * b;
	}
}
