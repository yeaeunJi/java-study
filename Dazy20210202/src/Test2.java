
 class Bank {

		private int balance = 1;
		private int account_id = 3;
		private int acount_ps =123456;
		public String Bank_name = "Korea";


	public void Balance_Check() {
		System.out.println(balance);
	}
	public void Print_ID() {
		System.out.println(account_id);
	}

}
public class Test2 {

	public static void main(String[] args) {
		Bank user = new Bank();
		user.Balance_Check();
		user.Print_ID();
//		user.acount_ps;
		System.out.println(user.Bank_name);
	}


}
