package kr.or.kosa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lotto2 {
	
	private int[] numbers; // 초기화
	private Scanner scanner;
	private Random r; // new Random();

	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;
	
	public Lotto2() { // 초기화 (member field)
		numbers = new int[6];
		scanner = new Scanner(System.in);
		r = new Random();
	}

	// 번호 추출 , 중복값 배제
	private void makeLottoNumbers() {
		for (int i = 0; i < 6; i++) {
			numbers[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) { // j < i (채워진 개수 만큼 비교)
				if (numbers[i] == numbers[j]) {
					i--; // point 같은 방의 값을 바꾸어여 한다
					break;
				}
			}
		}

	}

	// 화면에 출력 (낮은 값)
	private String showLottoNumbers() {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}

		// 출력하기
		StringBuffer buffer = new StringBuffer();
		buffer.append("로또 번호: [");
		for (int i = 0; i < numbers.length; i++) {
			buffer.append(numbers[i]);
			if(i<numbers.length-1)   buffer.append(", ");
		}
		buffer.append("] [");
		
		LocalDateTime now = LocalDateTime.now();
		String date = now.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH:mm"));
		buffer.append(date);
		buffer.append("]").append("\n");
		
		String result = buffer.toString();
		return result;
	}

	// 로또 (로또 번호의 합의 평균 범위 ....) ...아니면 재추출
	private boolean checkAverage() {
		int sum = 0;
		int average = 0;
		for (int num : numbers) {
			sum += num;
		}
		average = sum / numbers.length;
		//System.out.println("평균 : " + average);
		return (average >= 15 && average <= 35); // true (ok) , false(재추출)
	}
	
	//파일 저장
	public void Write() {		
		try {
			do {
				makeLottoNumbers();
			} while (!checkAverage());
			
			fw = new FileWriter("Lotto.txt", true);
			bw = new BufferedWriter(fw);
			
			//buffer line 단위 장점
			String line = showLottoNumbers();
			bw.write(line);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//파일 읽기
	public void Read() {
		
		try {
			fr = new FileReader("Lotto.txt");
			br = new BufferedReader(fr);
			
			//buffer line 단위 장점
			String line = "";
			for(int i=0; (line = br.readLine()) != null; i++) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}