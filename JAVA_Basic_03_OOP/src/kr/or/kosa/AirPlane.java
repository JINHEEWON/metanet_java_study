package kr.or.kosa;
/*
public class AirPlane {
	private String name;
	private int number;
	//객체간 공유자원
	private static int countairplane;
	
	public void makeAirPlane(String name, int number) {
		this.name = name;
		this.number = number;
		this.countairplane++;
		printAirplaneInfo();
		
	}
	
	private void printAirplaneInfo() {
		System.out.println("비행기 이름 : " + name + " 번호 : " + number);
	}
	
	public void printAirplaneCount() {
		System.out.println("총비행기 수 : " + countairplane);
	}
}
*/

public class AirPlane {
	private String name;
	private int number;
	//객체간 공유자원
	private static int countairplane;
	
	//생성자도 접근자 없으면 defalut class는 접근가능해도 생성자 접근 못함
	public AirPlane(String num, int number) {
		this.name = name;
		this.number = number;
		this.countairplane++;
		printAirplaneInfo();
	}
	
	private void printAirplaneInfo() {
		System.out.println("비행기 이름 : " + name + " 번호 : " + number);
	}
	
	public void printAirplaneCount() {
		System.out.println("총비행기 수 : " + countairplane);
	}
}