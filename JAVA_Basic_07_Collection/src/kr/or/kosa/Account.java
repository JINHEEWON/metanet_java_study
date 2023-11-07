package kr.or.kosa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Account {
	private String accountNo;
	private String name;
	private long balance;
	List<Transaction> transactions;
	
	public Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = 0;
		this.transactions = new ArrayList<Transaction>();
	}
	
	public void deposit(long amount) {
		LocalDateTime now = LocalDateTime.now();
		String nowDate = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
		String nowTime = now.format(DateTimeFormatter.ofPattern("HH시 mm분"));

		this.transactions.add(new Transaction(nowDate, nowTime, "입금", amount, this.balance));
		balance += amount;
	}
	
	public void withdraw(long amount) {
		LocalDateTime now = LocalDateTime.now();
		String nowDate = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
		String nowTime = now.format(DateTimeFormatter.ofPattern("HH시 mm분"));

		this.transactions.add(new Transaction(nowDate, nowTime, "출금", amount, this.balance));
		this.balance -= amount;
	}
	
	public long getBalance() {
		return this.balance;
	}
	
	public List<Transaction> getTransaction() {
		return this.transactions;
	}
}