package kr.or.kosa;

public class MyStack {
	private Object[] stackarr;	//stack 저장소
	private int position;	//배열의 위치정보
	
	public MyStack(int maxsize) {
		this.stackarr = new Object[maxsize];
		this.position = -1;
	}
	
	public void push(Object o) {
		if(full()) {
			//throw new IndexOutOfBoundsException("FULL");
			System.out.println("full");
		} else {
			this.stackarr[++position] = o;
		}
	}
	
	public Object pop() {
		Object value = null;
		if(empty()) {
			System.out.println("empty");
		} else {
			value = this.stackarr[position--];
		}
		return value;
	}
	
	public boolean empty() {
		return (position < 0);
	}
	
	public boolean full() {
		return (position >= stackarr.length-1);
	}
}
