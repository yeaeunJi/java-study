import java.util.Random;

public class Dice {
	private int num ;
	
	public int getNumber() {
		return num;
	}
	
	public void setNumber(int num) {
		this.num  = num;
	}
	
	public void roll() {
		Random rd = new Random();
		num = rd.nextInt(6)+1;
	}
	
	public void compareNum(Dice d) {
		if (d.getNumber() == this.num) {
			System.out.println("두 주사위의 값은 "+this.num+"으로 같습니다.");
		}
		else {
			System.out.println("첫번째 주사위 값은  "+this.num+",  두번째 주사위 값은 "+d.getNumber()+"으로 다릅니다.");
		}
	}
}
