//연산자, 제어문

import java.util.Scanner;
import java.lang.*;

public class Ex03_Operation {

	public static void main(String[] args) {
		//증가감 연산자
		//++, --
		//Point 증가감 연산자가 다른 연산과 결합되면
		
		int i = 5;
		int j = 10;
		int result = i + ++j;
		//j > 11
		
		result = i + j++;
		
		/*
		 byte + short >> 내부적으로 컴파일러가 int + int
		 char + char >> int + int
		 int 보다 작은 정수타입은 >> int로 바꿔서 연산
		 
		 정수 long 예외
		 char + int >> int
		 int + int >> int
		 int + long >> long
		 
		 정수 + 실수 >> 타입 크기와 상관없이 실수가 승자
		 
		 */
		int sum = 0;
		for(int k=0; k<=100; k++) {
			if(k % 2 == 0) {
				sum += k;
			} 
		}
		System.out.println(sum);
		
		if(10 == 10.0f) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		//삼항연산자
		int p = 10;
		int p2 = -10;
		int result2 = (p == p2) ? p : p2;
		
		//javascript === 타입, 값 둘다 같아야 true
		
		int x = 3;
		int y = 5;
		//비트연산   OR
		System.out.println((x | y));
		/*
		 256 128 64 32 16 8 4 2 1
		                  0 0 1 1  >>  3
		                  0 1 0 1  >>  5
		                  0 1 1 1  >>  OR
		                  4+2+1    >>  7
		 */
		
		/*
		 &&  and 연산
		 ||  or  연산
		 if(10 > 0 && -1 > 1 && 100 > 2 && 1 > -1) {}
		 if(10 > 0 || -1 > 1 || 100 > 2 || 1 > -1) {}
		 */
		
		int data=90;
		switch(data) {
			case 100: System.out.println("100"); break;
			case 90: System.out.println("90"); break;
			case 80: System.out.println("80"); break;
			default: System.out.println("default");
		}
		
		int month = 3;
		String res = "";
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: res = "31일";
			break;
		case 4:
		case 6:
		case 9:
		case 11: res = "30일";
			break;
		case 2: res = "29일";
			break;
		default: res = "월이 아니다";
		}
		
		
		////////////////
		int randomnum = 0;
		randomnum = ((int)(Math.random() * 10) + 1) * 100;
		String str = "";
		
		switch(randomnum) {
		case 1000: str += "TV ";
		case 900: str += "Notebook ";
		case 800: str += "냉장고 ";
		case 700: str += "한우세트 ";
		case 600: str += "휴지"; 
			break;
		default: str = "칫솔";
		}
		
		System.out.println("점수: " + randomnum + " 경품: " + str);
	}
	
}
