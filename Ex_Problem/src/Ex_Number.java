import java.util.Scanner;

public class Ex_Number {
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		boolean swap = false;
		String result;
		
		Scanner sc = new Scanner(System.in);
		num1 = Integer.parseInt(sc.next());
		num2 = Integer.parseInt(sc.next());
		
		if(num1 > num2) {
			swap = true;
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		if(num2 % num1 == 0) {
			System.out.println(swap ? "multiple" : "factor");
		} else {
			System.out.println("neither");
		}
	}
}
