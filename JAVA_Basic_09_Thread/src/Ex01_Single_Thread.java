/*
 프로그램 >> 실행 >> 프로세스 >> 최소 하나의 Thread (최소 하나의 stack 메모리)
 >> JVM >> Thread 하나 생성(stack) >> main 할당
 
 지금까지 >> 싱글 프로세스 >> 싱글쓰레드 >> main 함수만 실행 >> 하나의 stack
 
 동시성: 멀티 작업(프로세스가 동작)을 위해 하나의 코어에서 멀티 스레드가 번갈아 가며 실행하는 성질(실제 동시는 아님, 빠르게 변화해 느끼지 못하는 것)
 병렬성: 멀티 작업을 위해 멀티 코어에서 개별 스레드를 동시에 실행하는 성질 
 */

public class Ex01_Single_Thread {

	public static void main(String[] args) {
		System.out.println("일꾼_1");

		worker();
		worker2();
	}
	static void worker() {
		System.out.println("일꾼_2");
	}
	static void worker2() {
		System.out.println("일꾼_3");
	}

}
