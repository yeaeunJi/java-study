package ex_0203;

public class Test11 {
	
	public static void main(String[] args) {
	VipCustomer vip = new VipCustomer("1","q", "VIP", "J");
	GoldCustomer gold = new GoldCustomer("2","g", "GOLD");
	
	System.out.println(vip);
	vip.buying( 20000);
	System.out.println(vip);
	
	System.out.println("*************************************");
	
	System.out.println(gold);
	gold.buying( 20000);
	System.out.println(gold);
	}
}
