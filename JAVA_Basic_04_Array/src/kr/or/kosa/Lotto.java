package kr.or.kosa;

import java.util.Random;
import java.util.Scanner;

public class Lotto {
	private int[] numbers;
	private Scanner scanner; //생성자 초기화 -> 원칙
	private Random r;
	
	public Lotto() {
		this.numbers = new int[6];
	}
	
	private void inputNumber() {
		for(int i=0 ; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 45 + 1);
			for(int j=0; j<i; j++) {
				if (numbers[i] == numbers[j]) {
					i--;	
					break;
				}
			}
		}
	}
	
	private void sortNumber() {
		for(int i=0; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				if(numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	}
	
	public void getNumber() {
		inputNumber();
		sortNumber();
		for(int num : numbers) {
			System.out.println(num);
		}
	}
}