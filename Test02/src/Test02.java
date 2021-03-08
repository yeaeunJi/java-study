import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Bus bus = new Bus(121, 1300, 300, "Bus");
		Subway sub = new Subway("교대행", 1500, 300, "Subway");

		System.out.print("현재 학생이 보유하고 있는 금액을 입력해주세요. ");
		int bal = sc.nextInt();
		Student s = new Student("철수", "2", bal);

		while (true) {
			System.out.println("이용할 교통수단을 선택해주세요. (1. 버스 2. 지하철)");
			int trans = sc.nextInt();

			switch(trans){
			case 1 :
				bus.useCar(s);
				System.out.println(bus);
				break;
			case 2:
				sub.useCar(s);
				System.out.println(sub);
				break;
			}

			
			System.out.println("목적지에 도달하셨습니까?(y/n)");
			String arrive = sc.next();
			
			if (arrive.equals("y")) {
				sc.close();
				System.exit(0);
			}

		} // end while

	}

}
