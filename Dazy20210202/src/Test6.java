import java.util.Scanner;

class Test6 {

	public static void main(String[] args) {
		int input = -1;
		int balance = 0;
		int money = 0;
		
		Scanner c = new Scanner(System.in);
		Account a = new Account("12345", "철수", 5000);
		
		while (input != 4) {
			
			balance = a.getBalance();
			input = printMenu(c);
			
			if (input !=5 && input != 4) {
				System.out.println("현재 금액 : "+ a);
				System.out.print("금액 입력 :" );
				money = c.nextInt();
			}
			
			switch(input) {
				case  1  :		 // 입급
					balance += money;
					a.setBalance(balance);
					System.out.println("현재 금액 : "+ a);
					break;				
				case  2 :  // 출금
					a.withdraw(money);
					System.out.println("현재 금액 : "+ a);
					break;
				case 3 :  // 잔액조회
					System.out.println("현재 금액 : "+ a);
					break;
				case 4 : // 종료
					System.out.println("종료합니다.");
					break;
				default :
					System.out.println("잘못된 선택을 하셨습니다.");
					break;
			}			
		}
		c.close();
	}

	
	public static int printMenu(Scanner c) {
		System.out.println("[1] 입금");
		System.out.println("[2] 출금");
		System.out.println("[3] 잔액조회");		
		System.out.println("[4] 종료");
		System.out.print("원하는 거래 선택 : ");
		return c.nextInt();
	}
}
