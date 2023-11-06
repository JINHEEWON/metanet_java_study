/*
현업 개발
한개의 클래스로 설계 경우 (x)

설계도 1장 모든 업무를 구현 .. 현실적으로 불가능
설계도를 여러개로 나눈다 ...문제 발생 (기준 , 논리 )

쇼핑몰
결제관리 , 배송관리 , 재고관리 , 회원관리 , 상품관리 , 판매처 관리 , 카드 관리 ... >> 각각의 업무별로 설계도

****** 기준 *********
여러개의 설계도가 있을때 관계 ... 만들어주는 기준

1. 상속 :  is  ~ a  : 은(는) ~ 이다  >> 상속의 관계 (부모를 뒤에)
2. 포함 :  has ~ a  : 은(는) ~ 가지고 있다 >> 

원은 도형이다 
경찰은 권총이다 (x)
경찰은 권총을 가지고 있다

원은 도형이다
원 extends 도형
삼각형은 도형이다
삼각형 extends 도형


원  ,  점  관계
원은 점이다 (x)

원은 점을 가지고 있다 (0)
has ~ a (부품정보)
>> class 원 { 점이라는 부품이 member field 구현   점 원의점; }
>> class 점 { x,y}

경찰 권총
경찰은 권총이다 (x)
경찰은 권총을 가지고 있다(0)
class 권총 {}
class 경찰 { 권총 member field  }

원은 도형이다
삼각형은 도형이다
사각형은 도형이다

도형 분모 (공통적) 자원 : 추상화 , 일반화  >> 그리다 , 색상
원은 : 구체화 , 특수화(자신만이 가지는 특징) >> 반지름 , 한점

점 : 좌표값 (x,y)
원은 점을 가지고 있다
삼각형은 점을 가지고 있다
사각형은 점을 가지고 있다

------------------------------
class Shape{ 그리다 , 색상 }  >> 상속관계 부모 >> 원, 삼각형 ,사각형
class Point {좌표값}  >> 포함관계  >> (부품)

구체화 , 특수화 : Circle , Triangle

*/

class Shape {
	String color = "gold";
	void draw() {
		System.out.println("도형을 그리다");
	}
}

class Point {
	int x;
	int y;
	
	Point() {
		//this.x = 1;
		//this.y = 1;
		this(1,1);
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

//원 만들기 ->  원은 한점과 반지름을 가지고 있다
//1. 원은 도형이다 (is-a) : Shape
//2. 원은 점을 가지고 있다(has-a) : Point
//3. 원의 특수화되고 구체화된 것 : 반지름
// 원은 반지름 초기값 10을 가진다
// 점의 좌표는 10,15이다
// 초기값을 설정하지 않으면 반지름과 점의 값을 입력받을 수 있다
class Circle extends Shape{
	Point point;	//포함 > 부품	
	int radius;	//구체화, 특수화
	
	Circle() {
		//this.radius = 10;
		//this.point = new Point(10, 15);
		this(10, new Point(10, 15));
	}
	
	Circle(int radius, Point point) {	//Point 객체의 주소값
		this.radius = radius;
		this.point = point;
	}
	
}

class Triangle extends Shape {
	Point points[];
	
	Triangle() {
		this(new Point(0,0), new Point(10,10), new Point(20,20));
	}
	
	Triangle(Point point1, Point point2, Point point3) {		//배열로
		this.points = new Point[3];
		this.points[0] = point1;
		this.points[1] = point2;
		this.points[2] = point3;
	}
	void draw() {
		System.out.println("삼각형을 그리다");
		for(Point p : points) {
			System.out.printf("(%d, %d) ", p.x, p.y);
		}
	}
}

public class Ex02_Inherit_Composition {
	
	public static void main(String[] args) {
		Circle circle = new Circle();
		System.out.println(circle.radius);
		System.out.println(circle.color);
		System.out.println(circle.point.x); 	//주소값.주소값.field
		System.out.println(circle.point.y); 	//주소값.주소값.field
		
		Circle circle2 = new Circle(5, new Point(1,2));
		
		Triangle triangle = new Triangle();
		System.out.println(triangle.color);
		triangle.draw();
	}
}
