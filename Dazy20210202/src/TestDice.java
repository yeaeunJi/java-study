
public class TestDice {

	public static void main(String[] args) {
		Dice one = new Dice();
		Dice two = new Dice();
		
		one.roll();
		two.roll();
		
		one.compareNum(two);
	}

}
