/*

설계도를 재사용하는 것이 우리의 목적 

캡슐화: 모든 자원에 대해 직접할당을 막고 간접할당을 통해 데이터를 보호하는 방법
다형성: 하나의 타입으로 여러개 객체의 주소를 가질 수 있는 것.

method >> overloading
System.out.println() -> overloading

오버로딩과 성능은 상관없음
편하게 사용하기 위함. 개발자가
오버로딩을 사용하지 않아도 문제 되지 않음

return type은 보지 않음
parameter의 순서가 다름을 인정
ex) m(int i, String s), m(String s, int i)
 */

class Human {
	String name;
	int age;
}

class OverT {
	int add(int i) {
		return 100 + i;
	}
	
	//void add(int i2) {
		
	//}
	
	void add(String s, int i) {
		
	}
	void add(int i, String s) {	//순서가 다름을 인정
		
	}
	void add(Human human) {
		
	}
}
public class Ex08_Method_Overloading {

	public static void main(String[] args) {
		System.out.println();

	}

}
