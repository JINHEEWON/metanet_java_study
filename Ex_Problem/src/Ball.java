import java.util.Scanner;

public class Ball {
	
	public static void main(String[] args) {
		int[] basket;
		int count = 0;
		Scanner scanner = new Scanner(System.in);
		
		String[] temp = scanner.nextLine().split(" ");
		basket = new int[Integer.parseInt(temp[0])];
		count = Integer.parseInt(temp[1]);
		for(int i=0; i<basket.length; i++) {
			basket[i] = 0;
		}
		
		for(int i=0; i<count; i++) {
			String[] strnum = scanner.nextLine().split(" ");
			int begin = Integer.parseInt(strnum[0])-1;
			int end = Integer.parseInt(strnum[1])-1;
			int number = Integer.parseInt(strnum[2]);
			
			for(int j=begin; j<=end; j++) {
				basket[j] = number;
			}
		}
		
		for(int n : basket) {
			System.out.print(n + " ");
		}
	}
}
