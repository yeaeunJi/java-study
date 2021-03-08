import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Test01 {

	public static void main(String[] args) {
		// 잔고를 입력 받음
		Scanner sc = new Scanner(System.in);
		System.out.println("잔고를 입력해주세요 . ");
		int balance = sc.nextInt();
		Product product = new Product();
		
		while(balance >= 100) {
				System.out.println("구매할 물품을 선택해주세요. 1. TV 2.Computer");
				
				String  idx = sc.next();
				
				if (idx.equals("1")) {
					TV tv = new TV();
					product.order("TV");
					System.out.println(tv.toString());
					balance -= tv.getPrice();
				}else {
					Computer com = new Computer();
					product.order("Computer");
					System.out.println(com.toString());
					balance -= com.getPrice();
				}
				System.out.println("현재 잔액 : "+balance);
				
		}
		
		System.out.println("잔액이 부족하여 구매할 수 없습니다.");
		System.out.println("총 구매 리스트");
		for(String str : product.getOrderList()) {
			System.out.print(str+"  ");
			
		}
		
		System.out.println("총 구매 금액 : "+product.getTotalPrice());
	}
}