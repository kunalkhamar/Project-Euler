public class p004 {

	public static void main(String[] args) {
		int max = 10201; // 101^2
		
		for (int i = 999; i >= 500; i--) {
			for (int j = i; j >= 100; j--) {
				int prod = i * j;
				if (prod > max && isPalindrome(prod)) {
					max = prod;
				}
			}
		}

		System.out.println(max);
	}
	
	private static boolean isPalindrome(int n) {
		String num = "" + n;
		String reverse = new StringBuffer(num).reverse().toString();
		return reverse.equals(num);
	}
	
}
