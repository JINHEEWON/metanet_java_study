import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StackEx {

	public static void main(String[] args) {
		List<Integer> lstack = new ArrayList<Integer>();
		int positon = -1;
		
		Scanner scanner = new Scanner(System.in);
		int input = Integer.parseInt(scanner.nextLine());
		
		for(int i=0; i<input; i++) {
			String[] temp = scanner.nextLine().split(" ");
			int select = Integer.parseInt(temp[0]);
			
			switch (select) {
			case 1:
				lstack.add(Integer.parseInt(temp[1]));
				positon++;
				break;
			case 2:
				if(positon>=0) {
					System.out.println(lstack.get(positon--));
				}else {
					System.out.println(1);
				}
				break;
			case 3:
				System.out.println(lstack.size());
				break;
			case 4:
				if(positon<0) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
			case 5:
				if(positon>=0) {
					System.out.println(lstack.get(positon));
				} else {
					System.out.println(-1);
				}
				break;
			}
		}
	}
}
