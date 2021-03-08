import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		
		while(true) {

			System.out.println("========= 사용자 입력 ========= ");
			System.out.println("사용자의 아이디를 입력해주세요");
			String id = sc.next();
			
			System.out.println("사용자의 비민번호를 입력해주세요");
			String pw = sc.next();
			
			User user = new User(id, pw);	
			user.signUP(user);
			System.out.println("등록이 완료되었습니다.");
			user.printAllUsers();
		
			System.out.println("========================== ");
			System.out.println("종료 하시겠습니까? (y/n)");
			String input = sc.next();
			
			if (input.equals("y")) {
				System.exit(0);
			} else {
				continue;
			} 
	    }			// end while
	}  // end main
}

