//추상클래스 - 미완성클래스
/*
 추상클래스 - 강제성(이러한 내용은 반드시 구현하도록) - 추상메소드는 반드시 재정의해야함
 
 추상클래스 (상속이 아니면 의미가 없음)
 >> 미완성 클래스 (설계도)
 1. 완성된 코드 + 미완성 코드
 2. 미완성(함수) >> 실행블럭이 없는 함수 >> public void run();  (X){}
 3. 미완성된 클래스 (스스로 객체 생성이 불가능)
 
 설계도를 만드는 입장에서
 >> 미완성 설계도 제작(미완성 함수) >> 의도 >> 
 */

abstract class AbClass {
	int pos;
	void run() {
		pos++;
	}
	//강제하고 싶어요
	abstract void stop();	//실행 블럭이 없어요. 반드시 상속을 통해서 구현해라 >> 재정의
}

class Child5 extends AbClass {

	@Override
	void stop() {
		//마음대로
		this.pos = 0;
		System.out.println("stop : " + this.pos);
		
	}
	
}

public class Ex12_abstract_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
