import java.util.Scanner;

public class Matrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] s = sc.nextLine().split(" ");
		int[][] a = new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
		int[][] b = new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
		int[][] result = new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
		
		for(int i=0; i<a.length; i++) {
			String[] temp = sc.nextLine().split(" ");
			for(int j=0; j<a[i].length; j++) {
				a[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i=0; i<b.length; i++) {
			String[] temp = sc.nextLine().split(" ");
			for(int j=0; j<b[i].length; j++) {
				b[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b[i].length; j++) {
				System.out.print((a[i][j] + b[i][j]) + " ");
			}
			System.out.println();
		}

	}

}
