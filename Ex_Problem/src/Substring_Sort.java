import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Substring_Sort {
	public static void main(String[] args) {		
		
		Scanner sc = new Scanner(System.in);
		List<Integer> numberlist = new ArrayList<Integer>();
		
		String[] numbers = sc.nextLine().split(",");
		for(String s: numbers) {
			numberlist.add(Integer.parseInt(s));
		}
		
		String[] select = sc.nextLine().split(",");
		int i = Integer.parseInt(select[0])-1;
		int j = Integer.parseInt(select[1]);
		int k = Integer.parseInt(select[2])-1;
		
		numberlist = numberlist.subList(i, j);
		Collections.sort(numberlist);
		
		System.out.println(numberlist.get(k));
	}
}
