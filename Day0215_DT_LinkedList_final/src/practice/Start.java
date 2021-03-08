package practice;

import java.util.Scanner;

public class Start {
	
	public static void main(String[] args) {
		Room room = new Room();
		new Start().run(room);
	}
	
	void run(Room room) {
		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.println("이중 연결 리스트를 활용한 게임 관리 프로그램");
			System.out.println("---------------------------------------------------------------------------------------------------");
			room.printAll();
			System.out.print(">> ");
			String str = scan.nextLine(); // 문장 하나를 받아들임
			String[] strArr = str.split(" ");

			if (strArr[0].equals("insert")) {
				int value = Integer.parseInt(strArr[1]);
				room.insert(value);
			}
			else if (strArr[0].equals("delete")) {
				int value = Integer.parseInt(strArr[1]);
				room.delete(value, -1);
			}
			else if (strArr[0].equals("gamein")) {
				int idx = Integer.parseInt(strArr[1]);
				int value = Integer.parseInt(strArr[2]);
				room.gameIn(idx, value);
			}
			else if (strArr[0].equals("gameout")) {
				int idx = Integer.parseInt(strArr[1]);
				int value = Integer.parseInt(strArr[2]);
				room.gameOut(idx, value);
			}
			else if (strArr[0].equals("exit")) {
					break;
			}
			System.out.println();
		}

		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("---------------------------------------------------------------------------------------------------");

		scan.close();
	}

}
