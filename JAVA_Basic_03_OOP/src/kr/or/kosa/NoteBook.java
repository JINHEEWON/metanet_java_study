package kr.or.kosa;
/*
 노트북은 색상을 가지고 있다
 노트북은 생산년도를 가지고 있다
 노트북은 마우스를 가지고 있다
 >>마우스를 필요에 따라 사용할 수 있다 (handleMouse()참고)
*/

//마우스는 부품정보 > 별도의 클래스
/*
class Mouse {
	int x;
	int y;
	
	void setX(int x) {
		this.x = x;
	}
	void setY(int y) {
		this.y = y;
	}
	
	void getReadMouseData() {
		System.out.println("x : " + x + " y : " + y);
	}
}
*/
public class NoteBook {
	private String color;
	private int year;
	//private Mouse mouse;	//부품,   주입받는 방법
	//private Mouse mouse = new Mouse();   //컴포지션, Notebook과 Mouse는 생명주기(lifecycle) 동일  (노트북이 출고되며 마우스 같이, 없어지면 마우스도 없어짐)
	
	public void setColor(String color) {
		this.color = color;
	}
	public void setYear(int year) {
		this.year = year;
	}
//	public void setMouse(Mouse mouse) {		//노트북이 없어도 마우스는 존재할 수 있음
//		this.mouse = mouse;
//	}
	
	public void handleMouse(Mouse mouse) {	//의존관계(dependency)
		mouse.setX(100);
		mouse.setY(200);
		mouse.getReadMouseData();
	}
}

/*
NoteBook note = new NoteBook();
Mouse m = new Mouse();
//note.setMouse(m);
>>
note.handleMouse(m);

*/
