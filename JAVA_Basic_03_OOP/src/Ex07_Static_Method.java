/*
설계도
static member field : 객체간 공유자원
static method : public static void run() ....

1. 객체 생성 없이 사용하려고
2. 편하게 , 빠르게 
3. 많이 사용하니까 (new 안해도 됨) ex)System.out.println();
4. 설계도: 이 자원은 많이 사용할 것 같아(기능)
5. 자원을 많이 사용할거니까 > 편하게 > new > static 설계

*/

class StaticClass {
	int iv;
	
	static int cv;
	
	static void print() {
		//iv는 사용못함. static 자원만 사용가능. static이 만들어질 때 iv는 메모리에 없음
		//iv = 10;     //일반자원 접근 불가
	}
	
	void printIv() {
		//일반함수는 일반자원 + static 자원 모두 사용
		cv = 100;
		iv = 200;
	}
}

public class Ex07_Static_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
