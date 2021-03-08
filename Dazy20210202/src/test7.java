
public class test7 {

	public static void main(String[] args) {
		ClassRelation com1 = new ClassRelation(7, 17);
		ClassRelation com2 = com1.add(com1);
		System.out.println(com1.getNum1() + " "+com1.getNum2());
		System.out.println(com2.getNum1() + " "+com2.getNum2());
	}

}
