import java.util.Scanner;

public class Bridge {

	static int[][] dp = new int[30][30];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(sc.nextLine());
		for(int i=0; i<t; i++) {
			String[] s = sc.nextLine().split(" "); 
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			sb.append(comb(m, n)).append('\n');
			
		}
		System.out.println(sb.toString());
	}
	
	static int comb(int n, int r) {
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		if(r == 0 || n == r) {
			return dp[n][r] = 1;
		}
		return dp[n][r] = comb(n-1, r-1) + comb(n-1, r);
	}

}
