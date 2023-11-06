package kr.or.kosa;

import java.util.Random;
import java.util.Scanner;

public class Cinema {
	private int[][] seat; // 초기화
	//private int[][] bookNumbers;
	//private int[] booknumber;
	private Scanner scanner;
	private Random r; 
	
	public Cinema() {
		seat = new int[4][5];
		for(int i=0; i<seat.length; i++ ) {
			for(int j=0; j<seat[i].length; j++) {
				seat[i][j] = 0;
			}
		}
		
		scanner = new Scanner(System.in);
	}
	
	//시작
	public void booking() {
		
	}
	
	//예매하기
	public void selectSeat() {
		System.out.println("좌석을 선택해주세요. 예)1-1 \n이미 얘매된 좌석은 \"예매\"라고 표시됩니다.");
		String inputseat = scanner.nextLine();
		
		if(checkSeat(inputseat)) {
			System.out.println("예매 가능합니다. 얘매하시겠습니까? \n네(1), 아니오(2), 초기화면(0)중 하나를 입력해주세요.");
			int select = Integer.parseInt(scanner.nextLine());
			
			switch(select) {
			case 1: 
				String[] stringnum = inputseat.split("-");
				int i = Integer.parseInt(stringnum[0]);
				int j = Integer.parseInt(stringnum[1]);
				
				seat[i][j] = makeBookNumber();
				
				System.out.println("얘매가 완료되었습니다.");
				break;
			case 2:
				System.out.println("취소");
				break;
			case 0:
				break;
			}
			
		}else {
			System.out.println("예매 불가능한 좌석입니다.");
		}
	}
	
	//좌석현황
	private void showSeat() {
		System.out.println("**********좌석현황**********");
		for(int i=0; i<seat.length; i++ ) {
			for(int j=0; j<seat[i].length; j++) {
				if(seat[i][j] == 0) {
					System.out.print("예매");
				} else {
					System.out.printf("[%s-%s]", i+1, j+1);
				}
				//System.out.printf("[%s]", seat[i][j]);	//초기화 시 좌석번호 넣어둘경우
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}
	
	//메뉴
	private void showMenu() {
		boolean b = true;
		
		System.out.println("*********************");
		System.out.println("*****영화 예매 시스템*****");
		System.out.println("*********************");
		System.out.println("1. 예매하기\n");
		System.out.println("2. 예매조회\n");
		System.out.println("3. 예매취소\n");
		
		while(b){
			int select = Integer.parseInt(scanner.nextLine());
			
		
			switch(select) {
			case 1: 
				showSeat();
				selectSeat();
				break;
			case 2:
				showBook();
				break;
			case 3:
				cancel();
			}
		}
		
	}
	
	//에매 가능 확인
	private boolean checkSeat(String seatnum) {
		String[] stringnum = seatnum.split("-");
		int i = Integer.parseInt(stringnum[0]);
		int j = Integer.parseInt(stringnum[1]);
		
		if(seat[i][j] == 0) {
			return true;
		}
		
		return false;
	}
	
	//private int getBookNumber() { return 0; }

	//예매조회
	private void showBook() {
		System.out.println("예매번호를 입력해주세요");
		int number = Integer.parseInt(scanner.nextLine());
		String result = "";
		
		for(int i=0; i<seat.length; i++ ) {
			for(int j=0; j<seat[i].length; j++) {
				if(number == seat[i][j]) {
					//result = seat[i][j];
					result = (i+1) + "-" + (j+1);
					break;
				}
			}
		}
		System.out.printf("고객님이 예매하신 좌석은 %s입니다.", result);
		
	}
	
	//예매취소
	private void cancel() {
		showBook();
		
		
	}
	
	//예매번호 생성
	private int makeBookNumber() {
		int booknumber = (int) (Math.random() * 99999999 + 1);	
		return booknumber;
	}
	
}
