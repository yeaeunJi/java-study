
public class ClassRelation {
	private int num1;
	private int num2;
	
	public ClassRelation(int r, int i) {
		num1 = r;
		num2 = i;
	}
	
	int getNum1() {
		return num1;
	}
	
	int getNum2() {
		return num2;
	}
	
	public ClassRelation add(ClassRelation c) {
		int resultReal = num1 + c.getNum1();
		int resultmag = num2 + c.getNum2();
		return new ClassRelation(resultReal, resultmag);
	}
}
