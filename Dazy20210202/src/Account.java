
public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	private static int count = 0;
	
	public Account(String no, String name, int bal) {
		this.accountNo = no;
		this.ownerName = name;
		this.balance = bal;
		count += 1;
	}

//	public void deposit(int amount) {
//		balance += amount;
//	}
	
	public int withdraw(int amount) {
		
		if( amount > balance) {
			System.out.println("잔액이 부족합니다.");
			return amount;
		}
		
		this.balance -= amount;
		return amount;
	}
	
	public boolean transfer(int amount, Account user) {
		if( amount > balance) {
			System.out.println("잔액이 부족합니다.");
			return false;
		}
		
		balance -= amount;
		user.setBalance(amount);
		return true;
	}
	
	public int getCountUser() {
		return count;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int bal) {
		this.balance = bal;
	}
	
	public  String  toString() {
		return balance+"입니다.";
	}
}
