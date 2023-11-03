import kr.or.kosa.AirPlane;

public class Ex05_Static {

	public static void main(String[] args) {
		/*AirPlane air101 = new AirPlane();
		air101.makeAirPlane("대한항공", 707);
		
		AirPlane air102 = new AirPlane();
		air101.makeAirPlane("대한항공", 708);
		
		AirPlane air103 = new AirPlane();
		air101.makeAirPlane("대한항공", 709);
		
		air101.printAirplaneCount();*/
		
		AirPlane air101 = new AirPlane("대한항공", 707);
		air101.printAirplaneCount();
	}

}
