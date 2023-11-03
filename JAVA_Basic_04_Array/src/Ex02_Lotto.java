import kr.or.kosa.Lotto;

public class Ex02_Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] numbers = new int[6];
//		
//		for(int i=0 ; i < numbers.length; i++) {
//			numbers[i] = (int)(Math.random() * 45 + 1);
//			for(int j=0; j<i; j++) {
//				if (numbers[i] == numbers[j]) {
//					i--;	
//					break;
//				}
//			}
//		}
//		
//		for(int i=0; i<numbers.length; i++) {
//			for(int j=i+1; j<numbers.length; j++) {
//				if(numbers[i] > numbers[j]) {
//					int temp = numbers[i];
//					numbers[i] = numbers[j];
//					numbers[j] = temp;
//				}
//			}
//		}
//		
//		for(int n : numbers) System.out.println(n);
		
		Lotto lotto = new Lotto();
		lotto.getNumber();
		
		
	}

}
