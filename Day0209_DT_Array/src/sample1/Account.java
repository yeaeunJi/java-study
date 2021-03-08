package sample1;
import java.util.Calendar;

public class Account { // 데이터
	private int accid; //계좌번호
	private String name; // 이름
	private int balance; // 잔액
	Calendar newtime ; // 개설 일시

	public Account(int accid, String name, int balance){
		this.setAccid(accid);
		this.setName(name);
		this.setBalance(balance);
		newtime = Calendar.getInstance();
	}
	
	public Account(int accid, String name) {
		this(accid, name, 0);
	}

	public int getAccid() {
		return accid;
	}

	private void setAccid(int accid) {
		this.accid = accid;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	private void setBalance(int balance) {
		this.balance = balance;
	}

	public Calendar getNewtime() {
		return newtime;
	}
	

	public void inputMoney(int money) throws Exception{
		if (money < 0 ) throw new Exception("잘못된 금액을 입력하셨습니다.");
		balance += money;
	}

	public void outputMoney(int money) throws Exception {
		if (money < 0 ) throw new Exception("잘못된 금액을 입력하셨습니다.");
		if (money > balance ) throw new Exception("잔액이 부족합니다.");
		balance -= money;
	}

	public String getDate() {
		String temp = String.format("%04d-%02d-%02d", 
				newtime.get(Calendar.YEAR) ,newtime.get(Calendar.MONTH), newtime.get(Calendar.DAY_OF_MONTH));
		return temp;
	}

	public String getTime() {
		String temp = String.format("%02d:%02d:%02d", 
				newtime.get(Calendar.HOUR_OF_DAY) ,newtime.get(Calendar.MINUTE),  newtime.get(Calendar.SECOND));
		return temp;
	}

	public void println() {		
		System.out.println("**********************************************************************");
		System.out.println(" [계좌번호] " + accid);
		System.out.println(" [이름] " + name);
		System.out.println(" [잔액] " + balance);
		System.out.printf(" [개설일자] %s\n ", getDate());
		System.out.printf(" [개설시간] %s\n" , getTime());
		System.out.println("**********************************************************************");
	}

	public void print() {		
		System.out.println("**********************************************************************");
		System.out.printf(" [%d] %s %s\n ",  accid, name, balance);
		System.out.printf(" [개설일자] %s\n ", getDate());
		System.out.printf(" [개설시간] %s\n" , getTime());
		System.out.println("**********************************************************************");
	}
	
}
