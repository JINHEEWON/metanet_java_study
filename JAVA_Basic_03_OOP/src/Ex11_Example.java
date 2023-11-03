class DrinkMachine {
	private static int count;
	private int number;
	private int drinkprice;
	private int drinknum;
	private int money;
	
	DrinkMachine() {
		this(100, 10, 10000);
	}
	
	DrinkMachine(int drinkprice, int drinknum, int money) {
		this.drinkprice = drinkprice;
		this.drinknum = drinknum;
		this.money = money;
		this.number = ++count;
	}
	
	//음료수 개수와 지불한 금액 입력받음
	public void input(int num, int price) {
		if(!checkNum(num)) {
			System.out.println("수량이 부족합니다");
			return;
		}
		int totalPrice = calPrice(num);
		int balance = calBalance(price, totalPrice);
		printInfo(num, balance);
	}
	
	//총금액 계산
	public int calPrice(int num) {
		return num * drinkprice;
	}
	
	//입력받은 개수와 보유개수 계산
	public boolean checkNum(int num) {
		return (drinknum > num) ? true : false;
	}
	
	//거스름돈 계산
	public int calBalance(int price, int totalPrice) {
		money += price - (price - totalPrice);
		return price - totalPrice;
	}
	
	//음료수 제공
	public void printInfo(int num, int balance) {
		System.out.printf("주문하신 개수: [%d] \n거스름돈: [%d]\n 현재 음료수 개수: [%d]\n 보유금액: [%d]", num, balance, drinknum, money);
	}
}

public class Ex11_Example {
	public static void main(String[] args) {
		DrinkMachine dm = new DrinkMachine();	
		dm.input(2, 1000);
	}
}
