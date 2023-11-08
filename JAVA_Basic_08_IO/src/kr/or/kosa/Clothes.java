package kr.or.kosa;

public class Clothes extends Product {
	
	private int size;
	public Clothes(String name, int price, String seller, int size) {
		super(name, price, seller);
		this.size = size;
	}
	
	@Override
	public void printDetailInfo() {
		System.out.println("이름: "+name+", 가격: "+price+", 판매자: "+seller+", 크기"+size);
	}

}