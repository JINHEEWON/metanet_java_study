//클래스 == 설계도 == 데이터 타입
import kr.or.kosa.Emp;

class Test{
	int data;   //instance variable - 객체가 생성될 때마다 객체가 가지는 변수
				//초기화 하지 않아도 됨. default 값을 가짐(정수(0))  ->  왜? 객체마다 다른 값을 가질 수 있어서...
}

public class Ex01_Variable {

	public static void main(String[] args) {
		int value;
		value = 100; //초기화,  할당
		
		int age = 99;    //지역변수는 선언과 동시에 할당하는 것이 좋음
		
		//초기화 정의: 변수의 초기화: 변수가 처음 값을 갖는 것 (할당을 통해서)
		
		Test test = new Test();
		System.out.println(test.data);
		
		Emp emp;   //emp라는 지역변수는 Emp 클래스 객체의 주소를 받을 준비가 되어있음.
		emp = new Emp();
		emp.setEmpno(100);
		int empnodate = emp.getEmpno();
		System.out.println(emp);	//kr.or.kosa.Emp@5e91993f
		Emp emp2 = emp;
		System.out.println(emp2 == emp);
		
		int a,b,c;
		//같은 타입 나열(개발자 입장에선 반복된 코드) > array > int[] a;
		//초기화 X
		a = 100;
		b = 200;
		c = 300;
		
		//int age = 200;	같은 지역 같은 변수 안됨
		
		int result = a + b;
		
		int k = 100;
		int y = k;
		y = 200;
	}

}
/*
 클래스의 종류 - 실행 가능한 클래스. 실행 불가능한 클래스
 1. class Car() > main 함수를 가지고 있지 않은 클래스 > 독자적 실행이 불가능 > 다른 클래스에 도움을 주는 클래스(lib)
 2. class Car() {public static void main()}> main 함수를 가지고 있는 클래스 > 독자적으로 실행 가능
 3. 현재는 main 함수를 가지고 있는 클래스가 있어야 결과를 확인할 수 있다
 4. public static void main(String[] args) >> static (new 없이도 메모리에 생성) >> 함수의 이름
 
 변수 : variable
 데이터 (지료) 담을 수 있는 공간(메모리)의 이름
 공간(크기) >> 데이터 타입(자료형) >> 메모리의 공간이 한정 >> 최소한의 공간 최대한 데이터 표현
 
 변수가 선언되는 위치(scope : 유효범위)
 1. instance variable: 객체변수(클래스 안)
 2. local variable: 지역변수(함수 안)
 3. static variable: 공유자원(객체간) >> 써야하는 이유 - ex) 자동차 공장의 누적 자동차 개수를 알고싶은 경우, 단점: 한 객체가 건드리면 모든 객체에 영향이 갈 수 있음
 4. 함수안에 있는 제어블럭 안에 있는 변수(if, for) 블럭변수 >> class Car(void run() {for(int i=0...)})
 4. 
  */
