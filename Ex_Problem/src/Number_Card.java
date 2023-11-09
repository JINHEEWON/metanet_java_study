import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Number_Card {
	public static void main(String[] args) {
			
		Scanner scanner = new Scanner(System.in);
		int count = Integer.parseInt(scanner.nextLine());
		
		String[] temp = scanner.nextLine().split(" ");
		Set<String> numbercards = new HashSet<String>(Arrays.asList(temp));
		
		count = Integer.parseInt(scanner.nextLine());
		
		String[] temp2 = scanner.nextLine().split(" ");
		
		for(int i=0; i<count; i++) {
			System.out.print(numbercards.contains(temp2[i]) ? 1 + " " : 0 + " ");
		}

	}

}
