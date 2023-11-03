/*
static variable >> 공유자원(heap에 생성된 객체간 공유자원)

객체 생성 이전에 memory 올라가는 자원(클래스 area)
new 없이도 메모리에 올라감

1.class loader 가 분석
2. 클래스 정보를 올림 (클래스)
3. 정보를 올리다 static이 발견되면 메모리에 올림(클래스) - 일반 자원보다 항상 우선됨


 */

public class Ex04_Variable_Scope2 {

	public static void main(String[] args) {
	
	}
}
