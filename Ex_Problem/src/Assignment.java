import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Assignment {

	public static void main(String[] args) {
		int[] numbers = new int[31];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<28; i++) {
			int n = Integer.parseInt(sc.nextLine());
			numbers[n] = 1;
		}
		
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] != 1 && i != 0)
				System.out.println(i);
		}
	}

}
