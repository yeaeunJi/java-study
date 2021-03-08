

import java.util.ArrayList;

public class App {
	private Manager man = new Manager();


	public App() {
		Init();
	}

	private void Init() {
		BitGlobal.logo();
	}

	public void run() {

		while (true) {
			try {
				BitGlobal.main_Menu();
				// 명령어를 받아서 나눈다.
				String input = BitGlobal.InputString("명령어 입력");
				String[] sp = input.split(" ");

				switch (sp[0]) {

				case "1":
						String memberid = BitGlobal.InputString("회원번호");
						String name =  BitGlobal.InputString("이름");
						if (man.MakeUser(memberid, name)) {
							System.out.println("회원 등록 성공");
						}else System.out.println("회원 등록 실패");
						
					break;

				case "2":
					man.SelectAllUser();
					break;

				case "3":
					String drinkname = BitGlobal.InputString("음료수명");
					int drinkcost=  BitGlobal.InputNumber("가격");
					if (man.InsertDrink(drinkname, drinkcost)) {
						System.out.println("음료수 등록 성공");
					}else System.out.println("음료수 등록 실패");
					
					break;
				case "4":
					man.SelectAllDrink();
					break;

				case "5":
					man.SelectAllLevel();
					break;
				case "6":
					man.SelectAllBuyDrink();
					break;

				case "7":
					memberid = BitGlobal.InputString("회원번호");
					int drinkid = BitGlobal.InputNumber("음료수번호");
					int count = BitGlobal.InputNumber("구매수");
					man.InsertBuyDrink(memberid, drinkid, count);
					man.UpdatememberLevel(memberid);
					break;

				case "8":
					memberid = BitGlobal.InputString("회원번호");
					man.SelectMemberBuy(memberid);
					break;

				case "9":
					man.SelectMostPopularDrink();
					break;

				case "0":
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
				default :
					break;
				}
			}catch(Exception ex) {
				System.out.println("잘못 입력하셨습니다." + ex.getMessage());
			}
		}
	}
}

