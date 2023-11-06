import kr.or.kosa.Bird;

class Bi extends Bird {
	
	//moveFast를 사용하려면 재정의를 해야 사용할 수 있음
	@Override
	protected void moveFast() {
		super.moveFast();	//public 상속관계에서
	}
	
	
	
	
}

//날지 못하고 달리는 새
class Ostrich extends Bird {
	//특수화, 구체화
	void run() {
		System.out.println("run.....");
	}

	@Override
	protected void moveFast() {
		run();
	}
	
	
}

public class Ex07_Inherit_Protected {
	public static void main(String[] args) {
		Bi bi = new Bi();
		bi.fly();
		bi.moveFast();
		
		Ostrich o = new Ostrich();
		o.moveFast();
	}
}
