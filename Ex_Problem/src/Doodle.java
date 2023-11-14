import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Doodle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		List<String> input = new ArrayList<String>();
				
		for(int i=0; i<5; i++) {
			input.add(sc.nextLine());
		}
		
		int max = 0;
		for(int i=0; i<input.size(); i++) {
			max = Math.max(max, input.get(i).length());
		}
		
		for(int i=0; i<max; i++) {
			for(int j=0; j<input.size(); j++) {
				try {
					sb.append(input.get(j).charAt(i));
				} catch (Exception e) {
					
				}
			}
		}
		System.out.println(sb.toString());
	}
}
