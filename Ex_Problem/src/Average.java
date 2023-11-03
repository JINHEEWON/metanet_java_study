import java.util.Scanner;

public class Average {
	public static void main(String[] args) {
		int studentnum = 0;
		double studentscore[];
		
		Scanner sc = new Scanner(System.in);
		studentnum = Integer.parseInt(sc.nextLine());
		studentscore = new double[studentnum];
		
		for(int i=0; i<studentnum; i++) {
			int avg = 0;
			int count = 0;
			
			//한 반의 전체 점수 입력받음
			String score[] = (sc.nextLine()).split(" ");
			
			//평균
			for(int j=1; j<score.length; j++) {
				avg += Integer.parseInt(score[j]);
			}
			avg /= score.length - 1;
		
			//몇명이 평균 이상인지 비율 계산
			for(int j=1; j<score.length; j++) {
				if(avg < Integer.parseInt(score[j])) {
					count++;
				}
			}
			
			//배열에 넣음
			studentscore[i] = ((double)count / (score.length -1)) * 100; 
		}
		
		for(double s : studentscore) {
			System.out.println(String.format("%.3f", s) + "%");
		}
	}
}
