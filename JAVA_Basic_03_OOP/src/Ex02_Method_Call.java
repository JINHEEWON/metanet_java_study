import kr.or.kosa.Tv;

/*
모든 함수는 호출에 의해서만 동작한다

자바 함수 종류 4가지
void, parameter(O)
void, parameter(X)
return type, parameter(O)
return type, parameter(X)

함수의 return type으로 Array, class, interface, Collection도 가능

void print(Car c){}     //Car 타입을 가지는 객체의 주소

print(new Car());		//여기서만 쓰임

Car c = new Car();	//c라는 변수를 다른 곳에서 쓸 수 있음
print(c);

함수는 이름을 길게
사원테이블에서 사원의 모든 정보를 가지고 오는 함수
void getEmpAllList()

void getEmpListByEmpno()
*/

class Fclass {
	
	private int subSum(int i) {	//의도: 클래스 내에서만 ... 공통함수, 다른 함수 도와주는 함수
		return i + 100;
	}
	
	public int max(int n1, int n2) {
		return (n1 > n2) ? n1 : n2;
	}
}

public class Ex02_Method_Call {

	public static void main(String[] args) {
		Tv tv = new Tv();
		tv.company = "삼성";
		tv.upChannel();
		tv.upChannel();
		tv.upChannel();
		tv.tvInfo();
		tv.downChannel();
		tv.tvInfo();
	}

}
