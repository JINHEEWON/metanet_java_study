import java.util.Scanner;

public class DP_2 {

	static int[][] DP;
	static int[] number;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		
		DP = new int[num][3];
		
		String[] str = sc.nextLine().split(" ");
		for(int i=0; i<3; i++) {
			DP[0][i] = Integer.parseInt(str[i]);
		}
		
		for(int i=1; i<num; i++) {
			str = sc.nextLine().split(" ");
			number = new int[str.length];
			
			for(int j=0; j<number.length; j++) {
				number[j] = Integer.parseInt(str[j]);
			}
			
			DP[i][0] = Math.max(Math.max(DP[i][0], DP[i-1][0] + number[1]), DP[i-1][0] + number[2]);
			DP[i][1] = Math.max(Math.max(DP[i][1], DP[i-1][1] + number[0]), DP[i-1][1] + number[2]);
			DP[i][2] = Math.max(Math.max(DP[i][2], DP[i-1][2] + number[1]), DP[i-1][2] + number[0]);
		}
		
		int result = 0;
		for(int i=0; i<3; i++) {
			result = Math.max(result, DP[num-1][i]);
		}
		
		System.out.println(result);
	}

}
