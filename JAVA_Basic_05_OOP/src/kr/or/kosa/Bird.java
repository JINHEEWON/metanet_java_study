package kr.or.kosa;

public class Bird {
	//공통기능
	public void fly() {
		System.out.println("flying");
	}
	//설계자 고민
	//Bird 상속하는 당신은 moveFast()
	protected void moveFast() {
		fly();
		
		//개발자: 새가 나는 새만 있나..? 날지 못하는 새도 만들고 싶은데??  >>  protected 재정의
	}
}
