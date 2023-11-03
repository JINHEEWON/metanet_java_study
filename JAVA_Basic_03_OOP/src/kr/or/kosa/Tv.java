package kr.or.kosa;

public class Tv {
	public int channel;
	public String company;
	
	public void upChannel() {
		this.channel++;
	}
	public void downChannel() {
		this.channel--;
	}
	public void tvInfo() {
		System.out.printf("브랜드 이름: [%s], 채널: [%d] \n", company, channel);
	}
}
