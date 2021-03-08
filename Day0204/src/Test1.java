import java.util.Arrays;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Seat[] seats = new Seat[10];
		for(int i =0; i < seats.length;i++) {
			seats[i] = new Seat();
		}

		while(true) {
			display(seats);
			Scanner sc = new Scanner(System.in);
			System.out.println("예약하실 좌석을 입력해주세요.");
			int i = 1;
			
			int input = sc.nextInt();
			
			if (input > seats.length) {
				System.out.println("존재하지 않는 좌석입니다. 다시 시도해주세요");
				continue;
			}else {
				seats[input-1].reservation();
			}
			
			int cnt = 0;
			for(int k=0;k<seats.length;k++) {
				if (seats[k].isUsed())
					cnt ++;
			}
			
			if (cnt == seats.length) {
				System.out.println("좌석이 모두 매진되었습니다.");
				break;
			} else {
				continue;
			}
			
		}
	}
	
	public static void display(Seat[] seats) {
		for(int i =0; i < seats.length;i++) {
			System.out.print("seat"+(i+1)+"\t");
		}
		System.out.println();
		
		for(int i =0; i < seats.length;i++) {
			System.out.print("   "+seats[i]+"  \t");
		}
		System.out.println();
	}
}
