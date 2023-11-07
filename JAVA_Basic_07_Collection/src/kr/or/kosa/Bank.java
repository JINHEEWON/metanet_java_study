package kr.or.kosa;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	private List<Account> accounts;
	private int totalAccount;
	
	public Bank() {
		this.accounts = new ArrayList<>();
		this.totalAccount = 0;
	}
	
	public void addAccount(String accountNo, String name) {
		Account account = new Account(accountNo, name);
		accounts.add(account);
		totalAccount++;
	}
	
	public Account getAccount(String accountNo) {
		Account account = null;
		for (int i = 0; i < totalAccount; i++) {
			if (accounts.get(i).getAccountNo().equals(accountNo)) {
				//System.out.println(accounts.get(i).getAccountNo());
				account = accounts.get(i);
				break;
			}
		}
		
		return account;
	}
	
	public List<Account> findAccounts(String name) {
		List<Account> accountList = new ArrayList<>();
		
		for (int i = 0; i < totalAccount; i++) {
			if (accounts.get(i).getName().equals(name)) {
				accountList.add(accounts.get(i));
			}
		}
		
		return accountList;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public int getTotalAccount() {
		return totalAccount;
	}
}