import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class QueueTest {

	public static void main(String[] args) {
		int cnt = 1 ;
		String[] menu = {"치킨", "피자", "족발 ", "라면"};

		while(true) {
			System.out.println("좋은 아침 식당입니다. 어떤 음식을 주문하시겠습니까?\n");

			Order order = new Order(cnt);

			order.showMenu();

			Scanner sc = new Scanner(System.in);
			String orders = sc.nextLine();
			String[] orderFood = orders.split(",");

			for(String str : orderFood) { 
				String pattern = "^[0-9]*$"; //숫자만       
				str = str.trim();
				boolean regex = Pattern.matches(pattern, str);

				if (regex) {
					int idx = Integer.parseInt(str)-1;

					if ( menu.length > idx && idx >= 0 ) {
						order.order(menu[idx]);
					}
					else {
						System.out.println(str+"은(는) 없는 메뉴입니다. 다시 확인해주세요.");
					} // end inner if
				} 
			} // end for
			order.getBill();

			System.out.println("더 주문하시겠습니까?(y/n)");

			if (sc.next().trim().equals("y"))
				continue;
			else System.exit(0);
		}

	}

}
