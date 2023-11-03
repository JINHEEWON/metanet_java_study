package kr.or.kosa;

public class Person {
	public String name;		//null
	public int age;			//0
	public boolean power;	//false
	//초기값을 쓰지 않는 이유는 생성되는 객체마다 다른 값을 가질 수 있어서
	//생성자를 통해서
	
	public void personPrint() {
		System.out.printf("이름 %s 나이는 %d 파워는 %s 입니다 \n", name, age, power);
	}
}
