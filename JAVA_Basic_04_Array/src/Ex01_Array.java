/*
 배열은 객체다
 정적배열(고정배열) <> 동적배열(Collection : API 클래스)
 Collection도 내부적으로 정적배열을 씀
*/

import kr.or.kosa.Emp;

class Car {
	
}

class Person {
	String name;
}

public class Ex01_Array {

	public static void main(String[] args) {
		
		// 배열 만드는 법 3가지
		int[] arr = new int[5];	//heap
		int[] arr2 = new int[] {1, 2, 3, 4, 5};
		int[] arr3 = {1, 2, 3, 4, 5};	//new 생략 -> 컴파일러가 알아서 new를 붙임

		//Tip)js
		//const arr = [1,2,3,4,5];	let arr=[]; -> 이상적  arr.push(10)
		//javascript는 동적배열 ...
		
		//객체 배열
		Car[] cararr = new Car[3];
		cararr[0] = new Car();
		
		//향상된 for문
		//JAVA: for(Type 변수명 : 배열 or 컬렉션) {}
		//C#: for(Type 변수명 in 배열 or 컬렉션) {}
		//Javascript : for(Type 변수명 in 배열) {}
		
		int[] arr4 = {5,6,7,8,9};
		for(int value: arr4) {
			System.out.println(value);
		}
		
		//Person을 3명 만들어라
		Person[] people = new Person[3];
		Person[] people2 = {new Person(), new Person()};  // ->   가장 효율적
		
		//사원 3명을 만들어라 (Array)
		//1000, 김
		//2000, 박
		//3000, 이
		//결과를 개선된 for문으로 사번, 이름 모두 출력
		Emp[] emps = {new Emp(1000, "김"), new Emp(2000, "박"), new Emp(3000, "이")};
		for(Emp e: emps) {
			e.empInfoPrint();
		}
		
	}

}
