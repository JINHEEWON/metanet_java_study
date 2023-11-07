import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.Account;
import kr.or.kosa.Bank;
import kr.or.kosa.Transaction;

public class Ex03_Example {
	public static void main(String[] args) {

		Bank bank = new Bank();
		
		bank.addAccount("10071", "백");
		bank.addAccount("890113", "택");
		bank.addAccount("0113", "택");
		bank.addAccount("987654321", "두팔");
		
		System.out.println("= 전체 계좌 목록 =");
		List<Account> accounts = bank.getAccounts();
		for(Account acc: accounts) {
			System.out.println("[계좌번호 :"+acc.getAccountNo()+", 소유자 명 : "+acc.getName()+", 잔액 : "+acc.getBalance());
		}
		System.out.println();
		System.out.println();
		Account account = bank.getAccount("890113");
		System.out.println("= 해당 계좌번호의 계좌정보 =");
		System.out.println("[계좌번호 :"+account.getAccountNo()+", 소유자 명 : "+account.getName()+", 잔액 : "+account.getBalance());
		
		System.out.println();
		System.out.println();
		account.deposit(200000);
		System.out.println("200000원 입금하셨습니다.");
		System.out.println("현재 잔액은 "+account.getBalance()+"원 입니다.");
		System.out.println();
		System.out.println();
		System.out.println("= 해당 계좌번호의 계좌정보 =");
		System.out.println("[계좌번호 :"+account.getAccountNo()+", 소유자 명 : "+account.getName()+", 잔액 : "+account.getBalance());
		System.out.println();
		System.out.println();
		account.deposit(200000);
		System.out.println("200000원 입금하셨습니다.");
		System.out.println("현재 잔액은 "+account.getBalance()+"원 입니다.");
		System.out.println();
		System.out.println();
	
		System.out.println("= 해당 계좌 번호의 계좌정보 =");
		accounts = bank.findAccounts("택");
		for(Account acc: accounts) {
			System.out.println("[계좌번호 :"+acc.getAccountNo()+", 소유자 명 : "+acc.getName()+", 잔액 : "+acc.getBalance());
		}
		System.out.println();
		System.out.println();
		account = bank.getAccount("890113");
		System.out.println("= 해당 계좌번호의 계좌정보 =");
		System.out.println("[계좌번호 :"+account.getAccountNo()+", 소유자 명 : "+account.getName()+", 잔액 : "+account.getBalance());
		System.out.println();
		System.out.println();
		
		account.withdraw(5500);
		System.out.println("5500원 인출하셨습니다.");
		System.out.println("현재 잔액은 "+account.getBalance()+"원 입니다.");
		System.out.println();
		System.out.println();
		System.out.println("= 해당 계좌번호의 계좌정보 =");
		System.out.println("[계좌번호 :"+account.getAccountNo()+", 소유자 명 : "+account.getName()+", 잔액 : "+account.getBalance());
		System.out.println();
		System.out.println();
		
		System.out.println("= 거래 내역 =");
		
		List<Transaction> transactions = account.getTransactions();
		for(Transaction transaction: transactions) {
			System.out.println("[거래 금액 :"+transaction.getAmount()+", 잔액: "+transaction.getBalance()+"/"+transaction.getTransactionDate());
		}
		
	}

}
