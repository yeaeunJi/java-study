import java.util.Iterator;

public class Manager {
	// ****************************************************************************************************************
	// 싱글톤 패턴 코드
	// ****************************************************************************************************************
	private static Manager singleton = new Manager();

	private Manager() {
		arr = new BitArray(inputMax());
	}

	public static Manager getInstance() {
		return singleton;
	}
	// ****************************************************************************************************************

	private BitArray arr; // 회원 정보

	// 메서드
	public int inputMax() {
		return BitGlobal.inputNumber("저장 개수를 입력하세요.");
	}

	// 기능 메서드
	public void selectAll() {
		//1. 저장 개수 출력
		System.out.printf("[저장개수]  %d개\n", arr.getSize() );

		//2. 전체 데이터 정보를 출력[배열 알고리즘] - 전체 순회 
		for(int i =0; i<arr.getSize(); i++){
			Member mem = (Member)arr.getData(i); // Down Casting 문법 적용 ==> 객체가 Member가 아닐 때 문제가 발생할 수 있므로 instanceof로 확인 후 다운 캐스팅 필요
			mem.print();
		}
	}

	public void insert() {
		try {
			//1. 변수 선언(IN 변수, OUT 변수)
			//2. 초기화(IN 변수는 초기화의 대상, OUT 변수는 기본 초기화)
			int number = BitGlobal.inputNumber("회원번호");
			String name = BitGlobal.inputString("이름");
			String phone = BitGlobal.inputString("전화번호");
			char gender = BitGlobal.inputChar("성별");


			//3. 연산 (연산에 사용되는 변수 : IN, 연산의 결과값 : OUT)
			Member mem = new Member(number, name, phone, gender);
			arr.insert(mem); // pushback  알고리즘(새로운 자료가 뒤로 들어감)

			//4. 결과 출력
			System.out.println("저장되었습니다.");
			mem.print();

		} catch (Exception e) {
			//			System.out.println(e.getMessage())
			System.out.println("[저장 실패]" + e.getMessage());
			//			e.printStackTrace();
		}
	}

	//검색 알고리즘(순차 검색) --> number 기준
	//회원번호를 전달 --> 배열의 idx를 반환(실패 : -1) 
	private int numberToIdx(int number) {
		for(int i=0; i<arr.getSize(); i++) {
			Member mem = (Member)arr.getData(i);
			if(mem.getNumber() == number) {
				return i;
			} // end if
		} // end for
		return  -1;
	}

	// 회원의 이름을 전달 --> 회원을 반환(실패 : 예외 발생)
	private Member nameToMember(String name) throws Exception{
		for(int i=0; i<arr.getSize(); i++) {
			Member mem = (Member)arr.getData(i);
			if(mem.getName().equals(name)) {
				return mem;
			}
		} 
		throw  new Exception("없는 회원입니다.");
	}

	public void select() {
		int number =  BitGlobal.inputNumber("회원번호");
		int idx = numberToIdx(number);
		if (idx != -1 ) {
			Member mem = (Member)arr.getData(idx);
			mem.println();
		}
		else 	System.out.println("조회된 결과가 없습니다.");
	}

	public void update(){
		try {
			String  name =  BitGlobal.inputString("회원명").trim();
			String  newPhone = BitGlobal.inputString("수정할 전화번호 입력");
			Member mem = nameToMember(name);
			mem.setPhone(newPhone);
			System.out.println("수정되었습니다.");
		}
		catch (Exception e) {
			System.out.println("[수정오류] "+e.getMessage());
		}
	}

	public void delete() {
		try {
			int number =  BitGlobal.inputNumber("회원번호");
			int idx = numberToIdx(number);
			if(idx == -1)
				throw new Exception("없는 회원번호 입니다.");

			arr.delete(idx);
			System.out.println("삭제되었습니다.");
		}
		catch (Exception e) {
			System.out.println("[삭제오류] "+e.getMessage());
		}
	}

}
