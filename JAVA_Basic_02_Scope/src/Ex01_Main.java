/*
클래스 == 설계도 == 데이터 타입(사용자 정의)

클래스 구성요소 (설계도라고 판단 근거, 최소한의 무엇이)
속성 + 기능
필드 + 메서드 (생성자 함수 : member field의 초기화가 목적 (생성되는 객체마다 다른값으로 집어넣기 위해))

필드(member field) >> 데이터, 자료(정보) 담고 있는 것 >> [고유정보], [상태정보], [부품정보]

class 설계도 이름 {
	고유정보 : 제조회사 = 현대, 이름, 주민번호 등
	상태정보 : 자동차 설계도 > 속도
	부품정보 : 자동차 설계도 > 다른 클래스 > 엔진 클래스
	
	+
	기능(행위)
	+
	생성자 함수
}

class Engine {

}

class Car {
	String companyname;
	int speed;
	Engine e;
}


클래스, 필드, 생성자함수, 메서드 : 영역(범위) >> 생성되는 장소(위치) or 접근자(한정자, 수정자)

장소(위치) : 폴더(package) 기반으로  클래스 내부, 함수 내부, 제어문 내부
접근자 : public, private, default, protected

*/

class Emp {	//연습할때만..
	
}
class Dept {  //컴파일러가 default class Dept라고 해석 -> default는 같은 패키지 내에서만 쓰겠다
	int deptno; //컴파일러가 default int deptno라고 해석
	public String dname; //public을 붙일 필요가 없음. class가 default이기 때문에 다른 폴더(패키지)에서 접근 불가. 에러는 안나지만 의미없음
	private int count;	//캡슐화 (은닉)   >>  클래스 내부에서만 쓰겠다
						// 설계자의 의도 : 클래스 내부에서만 사용, 직접할당을 막고 간접할당을 하겠다
	//특수한 목적의 함수
	// getter(읽기전용), setter(쓰기전용)
	int getCount() {
		return this.count;
	}
	void setCount(int count) {
		if(count < 0) {
			this.count = 0;
		}else {
			this.count = count;
		}	
	}
}

public class Ex01_Main {

	public static void main(String[] args) {
		
		Dept dept = new Dept();
		dept.deptno = 10;
		dept.dname = "인사팀";
		dept.setCount(-1);
		System.out.println(dept.getCount());
		
		
	}

}
