package sample1;

import java.util.Calendar;

public class AccountIO {
	private int accid;
	private int input;
	private int output;
	private int balance;
	Calendar cd;
	
	public AccountIO(int accid, int input, int output, int balance) {
		this.accid = accid;
		this.input = input;
		this.output = output;
		this.balance = balance;
		cd = Calendar.getInstance();
	}
	
	//get메서드
	public int getAccid() {
		return this.accid;
	}
	
	public String getDate() {
		String temp = String.format("%04d-%02d-%02d", 
				cd.get(Calendar.YEAR) ,cd.get(Calendar.MONTH), cd.get(Calendar.DAY_OF_MONTH));
		return temp;
	}

	public String getTime() {
		String temp = String.format("%02d:%02d:%02d", 
				cd.get(Calendar.HOUR_OF_DAY) ,cd.get(Calendar.MINUTE),  cd.get(Calendar.SECOND));
		return temp;
	}
	
	//출력 기능(단일출력)
	public void print() {
		System.out.println("**********************************************************************");
		System.out.printf(" [%d] input %s\toutput %s\tbalance %d\t%s\t%s\n ",  accid, input, output, balance, getDate(), getTime());
		System.out.println("**********************************************************************");
	}	
}
