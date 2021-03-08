package testSrt;

public class User {
	String userId;
	int bal;
	
	public User(String userId, int bal) {
		super();
		this.userId = userId;
		this.bal = bal;
	}
	
	public void  inputMoney(int money) {
		System.out.println("돈을 받았습니다.");
	}
	
	public void  pay(int money) {
		System.out.println("돈을 냈습니다.");
	}
}
