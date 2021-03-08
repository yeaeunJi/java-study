package sample2;
import java.util.Scanner;

public class Start {
	private Room room = new Room();
	private Scanner scan = new Scanner(System.in);	
	
	private void Init() {
		System.out.println("-------------------------------------------------");
		System.out.println(" ���α׷��� �����մϴ�.");
		System.out.println("-------------------------------------------------");
	}
	
	private void Exit() {
		System.out.println("-------------------------------------------------");
		System.out.println(" ���α׷��� �����մϴ�.");
		System.out.println("-------------------------------------------------");
	}
	
	private void Insert(int number) {
		if( room.Insert(number))
			System.out.printf("%d�� ȸ���� �������� �����Ͽ����ϴ�.\n", number);						
	}
	
	private void Delete(int number) {
		if( room.Delete(number))
			System.out.printf("%d�� ȸ���� ���濡�� �����߽��ϴ�.\n", number);	
		else
			System.out.printf("%d�� ȸ���� ���濡 �������� �ʽ��ϴ�.\n", number);	
	}
	
	private void GameRoomIn(int roomnumber, int number) {
		if( room.GameIn(roomnumber, number))
			System.out.printf("%d�� ȸ���� ���ӹ�%d�� �̵��Ͽ����ϴ�.\n", number, roomnumber);
		else
			System.out.printf("%d�� ȸ���� ���濡 �����ϴ�.\n", number);			
	}
	
	private void GameRoomOut(int roomnumber, int number) {
		if( room.GameOut(roomnumber, number))
			System.out.printf("%d�� ȸ���� �������� �̵��Ͽ����ϴ�.\n", number);
		else
			System.out.printf("%d�� ȸ���� ���ӹ�%d�� �����ϴ�.\n", number, roomnumber);		
	}
		
	
	public void Run() {
		Init();
		
		while(true) {			
			room.PrintAll();

			System.out.print(">> ");
			String str = scan.nextLine();
			String[] sp = str.split(" ");
			if( sp[0].equals("insert")){   //insert 10
				Insert(Integer.parseInt(sp[1]));
			}
			else if(sp[0].equals("delete")) { //delete 10
				Delete(Integer.parseInt(sp[1]));
			}
			else if(sp[0].equals("gamein")) {  //gamein 1 30 
				int roomnumber = Integer.parseInt(sp[1]);
				int value = Integer.parseInt(sp[2]);
				GameRoomIn(roomnumber, value);
			}
			else if(sp[0].equals("gameout")) {	//gameout 1 30
				int roomnumber = Integer.parseInt(sp[1]);
				int value = Integer.parseInt(sp[2]);
				GameRoomOut(roomnumber, value);
			}
			else if(sp[0].equals("exit")) {
					break;
			}
		}
		
		Exit();
	}

	public static void main(String[] args) {
		new Start().Run();  //����ü (������ ���ÿ� �� �ѹ��� �޼��带 ����� ���)
	}
}
