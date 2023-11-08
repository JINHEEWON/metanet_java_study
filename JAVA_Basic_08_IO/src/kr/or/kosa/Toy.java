package kr.or.kosa;

public class Toy extends Product {
	
	private int age;
	public Toy(String name, int price, String seller, int age) {
		super(name, price, seller);
		this.age = age;
	}
	
	@Override
	public void printDetailInfo() {
		System.out.println("이름: "+name+", 가격: "+price+", 판매자: "+seller+", 적정 연령"+age);
	}

}