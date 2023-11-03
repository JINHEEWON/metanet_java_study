import java.util.Scanner;

public class Ex04_Operation {

	public static void main(String[] args) {
		/*
		 for
		 while
		 do ~while 일단 한번은 강제적으로 수행 ... 그 다음 조건을 보고 판단
		 메뉴 구성
		 do{실행블럭} while(조건판단)
		 ex) 메뉴 구성
		 점심 메뉴를 선택하세요
		 1. 짜장
		 2. 짬뽕
		 3. ....
		 입력
 		 */
		
		/*Scanner sc = new Scanner(System.in);
		int inputdata = 0;
		do {
			System.out.println("숫자 입력 (0-9)");
			inputdata = Integer.parseInt(sc.nextLine());
		}while(inputdata >= 10);	//조건 결과가 true do문 실행
									// 9 >= 10 false -> do 탈출
		
		System.out.println("당신이 입력한 숫자는: " + inputdata);
		
		
		//함수를 종료하는 방법: return, System.exit(0), 논리 종료
		// while(true) { 특정조건 break; }
		
		int balance = 0;
		int num = 0;
		
		do {
			System.out.println("1. 예금");
			System.out.println("2. 출금");
			System.out.println("3. 잔액");
			System.out.println("4. 종료");
			
			Scanner sc2 = new Scanner(System.in);
			num = Integer.parseInt(sc2.nextLine());
			
			switch(num) {
			case 1:
				System.out.print("금액: ");
				balance += Integer.parseInt(sc2.nextLine()); break;
			case 2: 
				System.out.print("금액: ");
				balance -= Integer.parseInt(sc2.nextLine()); break;
			case 3: 
				System.out.println("잔액: " + balance);
			}
			System.out.println();
			
		}while(num != 4);
		*/
		
		
		/*int random = 0; 
		int input = 0;
        boolean auto = true;
		Scanner sc3 = new Scanner(System.in);
		
		while(auto) {
			System.out.println("*********************************");
			System.out.println("가위바위보");
			System.out.println("1. 가위 | 2. 바위 | 3. 보 | 4. 끝내기");
			System.out.println("*********************************");
			
			System.out.print("선택: ");
			input = Integer.parseInt(sc3.nextLine());
			random = (int)(3*Math.random()+1); //1 <= random < 4;
			
			if(input == 4) {
				System.out.println("종료");
				auto = false;  //논리를 이용해서 while(false) 탈출
				break;
			}
			
			int result = input - random;
			switch(result) {
				case 0  : 
					System.out.println("플레이어:"+ input +" 컴퓨터:"+ random +" 결과:무승부");
				    break; //switch 탈출
				case -2 :
				case 1  : 
					System.out.println("플레이어:"+ input +" 컴퓨터:"+ random +" 결과:플레이어 승");
				    break; //switch 탈출
				case -1 :
				case 2  :
					System.out.println("플레이어:"+ input +" 컴퓨터:"+ random +" 결과:컴퓨터 승");
					break; //switch 탈출
				default : System.out.println("올바른 메뉴를 선택하세요");					
			}
				
			System.out.println();
		}*/
		
		int unit = 10000;
		int num = 0;
		int sw = 0;
		int money = 0;
		
		Scanner sc = new Scanner(System.in);
		money = Integer.parseInt(sc.nextLine());
		
		while(unit >= 1) {
			num = (int)(money/unit);
			System.out.println(unit + " " + num + "개");
			
			money -= unit * num;
			
			if(sw==0) {
				unit = unit/2;
				sw = 1;
			} else {
				unit = unit/5;
				sw = 0;
			}
		} 
		
	}

}
