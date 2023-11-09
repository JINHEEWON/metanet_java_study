import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		System.out.println(fac(num));
	}
	
	public static int fac(int num) {
		return (num != 0) ? num * fac(num-1) : 1;
	}
}
