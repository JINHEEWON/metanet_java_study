class Zcar {
	String color;
	String gearType;
	int door;
	
	Zcar() {	//기본 설정
		this("red", "auto", 2);	//생성자를 호출하는 this를 활용하면 할당에 대한 코드량이 감소된다
	}
	Zcar(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	void socarPrint() {
		
	}
}
public class Ex11_this {

	public static void main(String[] args) {
		

	}

}


// 음료수 자판기
// 정의: 음료수를 제공하는 기계
// 시나리오
/*
 음료수 자판기는 음료수와 일련번호, 음료수 개수, 가격을 가지고 있다
 음료수 자판기는 음료수의 개수를 입력받는다
 음료수 자판기는 음료수 개수와 입력받은 개수를 계산한다
 - 입력받은 개수보다 보유개수가 적으면 음료수를 제공하지 않는다
 음료수 자판기는 돈을 입력 받는다
 거스름돈을 계산해 돌려준다
 음료수를 제공한다

 */

