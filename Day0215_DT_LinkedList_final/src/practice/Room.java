package practice;

public class Room {
	private MyDList waitingRoom ;
	private MyDList gameRoom1 ;
	private MyDList gameRoom2 ;
	private MyDList gameRoom3 ;

	public Room() {
		waitingRoom = new MyDList();
		gameRoom1 = new MyDList(); ;
		gameRoom2 = new MyDList(); ;
		gameRoom3  = new MyDList();;
	}

	// 대기방 입장 메소드
	public boolean insert(int number) {
		if (waitingRoom.push_back(number)) {
			System.out.println(number+"번 회원님이 대기방으로 입장하였습니다. ");
			return true;
		}
		else {
			System.out.println("대기방에 입장하지 못했습니다.");
			return false;
		}
	}

	// 대기방 퇴장 메소드
	public boolean delete(int number, int idx) {
		// number  찾음
		practice.MyDList.DNode del = waitingRoom.select(number);
		if (idx == -1 && waitingRoom.erase_random(del)) {
			System.out.println(number+"번 회원님은 게임을 종료하셨습니다.");
		}
		else if (idx == -1 && ! waitingRoom.erase_random(del)) {
			System.out.println(number+"번 회원님은 대기방에 없는 회원입니다.");
			return false;
		}
		else {
			return waitingRoom.erase_random(del);
		}
		return true;
	}

	// idx방에 number번호가 게임룸으로 입장하는 메서드
	public boolean gameIn(int idx, int number) {
		practice.MyDList.DNode mem = waitingRoom.select(number); 
		if (mem == null ) { 
			System.out.println(number+"번 회원님은 대기방에 없는 회원입니다.");
			return false;
		}
		
		if (idx == 1) {
			gameRoom1.push_back(number);
		}
		else if (idx == 2) {
			gameRoom2.push_back(number);
		}
		else {
			gameRoom3.push_back(number);
		}
		// 2. 대기방에 있던 number를 제거
		System.out.println(number+"번 회원님이 게임방"+idx+"으로 이동하였습니다.");
		waitingRoom.erase_random(mem);
		return true;
}

// idx방에서 number번호가 퇴장하는 메서드
public boolean gameOut(int idx, int number) {
	if (idx == 1) {
		MyDList.DNode del = gameRoom1.select(number); 
		if (del == null) {
			System.out.println(number+"번 회원님은 게임방1에 없는 회원입니다.");
			return false;
		}
		gameRoom1.erase_random(del);
		waitingRoom.push_back(del);
	}
	else if (idx == 2) {
		MyDList.DNode del = gameRoom2.select(number); 
		if (del == null) {
			System.out.println(number+"번 회원님은 게임방2에 없는 회원입니다.");
			return false;
		}
		gameRoom2.erase_random(del);
		waitingRoom.push_back(del);
	}
	else if (idx == 3){
		MyDList.DNode del = gameRoom3.select(number); 
		if (del == null) {
			System.out.println(number+"번 회원님은 게임방3에 없는 회원입니다.");
			return false;
		}
		gameRoom3.erase_random(del);
		waitingRoom.push_back(del);
	}	
	System.out.println(number+"번 회원님이 게임방"+idx+"에서 퇴장하셨습니다.");
	return true;
}

// 출력(연결리스트 4개 출력)
public void printAll() {
	System.out.println("---------------------------------------------------------------------------------------------------");
	System.out.print("대기방 \t"); 	    waitingRoom.selectNextAll();
	System.out.print("게임방1 \t");  	gameRoom1.selectNextAll();
	System.out.print("게임방2 \t");     	gameRoom2.selectNextAll();
	System.out.print("게임방3 \t");     	gameRoom3.selectNextAll();
	System.out.println("---------------------------------------------------------------------------------------------------");
}


}
