import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Numbers {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		Set<Integer> result = new HashSet<Integer>();
		
		Scanner sc = new Scanner(System.in);
		String[] temp = sc.nextLine().split(",");
		
		for(String s : temp) {
			numbers.add(Integer.parseInt(s));
		}
		
		for(int i=0; i< numbers.size()-1; i++) {
			for(int j=i+1; j<numbers.size(); j++) {
				result.add(numbers.get(i) + numbers.get(j));
			}
		}
		
		List<Integer> sortnum = new ArrayList<Integer>(result);
		sortnum.sort(Comparator.naturalOrder());
		for(int n : sortnum) {
			System.out.print(n + ",");
		}
	}
}
