
public class test4 {

	public static void main(String[] args) {
		Account account = new Account("12345", "철수", 10000);

		System.out.println("account : "+account);
		Account adam = new Account("987", "adam", 20000);
		System.out.println("adam : "+adam);
		
		account.transfer(4000, adam);
		System.out.println("account : "+account);
		System.out.println("adam : "+adam);
		
		System.out.println("만들어진 계좌 수 : "+account.getCountUser());
	}
}
