/*
 생성자 함수
 
 일반 함수와 다른점
 1. 함수 이름이 고정(class 이름 동일)
 2. return type 없음
 3. member field 다음 실행
 4. return type 생략
 
 생성되는 객체마다 강제적으로 member field 초기화 하고 싶음
 
 생성자 함수는 overloading 가능 (강제구현)
 */

class Car {
	String carname = "포니";
	//구현하지 않으면 컴파일러가 자동으로 생성자를 만듦.
	//Car(){}	default
	Car() {
		System.out.println("기본생성자");
	}
	
	
}

class Car2 {
	String carname;
	Car2() {
		
	}
	Car2(String name) {
		carname = name;
	}
}

class Car3 {
	String carname;

	//overloading 생성자 >> 강제성
	Car3(String name) {	//overloading 생성자 함수가 하나라도 있다면 default는 자동 생성되지 않음. 개발자의 의도는 Car3 객체 생성시 무조건(강제적으로) 이름을 넣어라
		carname = name;
	}
}

public class Ex09_Constructor {

	public static void main(String[] args) {
		Car car = new Car();
		
		//Car3 car3 = new Car3();
		Car3 car3 = new Car3("강제이름");

	}

}
