import java.util.Scanner;

public class Ex02_String_Class {
	
	public static boolean checkLength(String number) {
		return (number.length() == 15) ? true : false;
	}
		
	public static boolean boolcheckNumber(String number) {
		int num = (int)number.charAt(7) - '0';
		boolean result = true;
		if(num <1 || num > 4) {
			result = false;
		}
		return result;
	}
	
	public static void printNumber(String number) {
		int num = (int)number.charAt(7) - '0';
		if(num == 1 || num == 3) {
			System.out.println("남자");
		}
		else if(num == 2 || num == 4) {
			System.out.println("여자");
		}
	} 
		
	public static void main(String[] args) {
		String number = "";
		Scanner scanner = new Scanner(System.in);
		
		do {
			number = scanner.nextLine();
			
		}while((checkLength(number) || boolcheckNumber(number)));
			
		printNumber(number);	
		
	}
	
	

}
