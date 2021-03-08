package ex_0203;

public class VideoShopMain {

	public static void main(String[] args) {
		String temp;
		VideoShop vs = new VideoShop();
		System.out.println("보우햔 비디오 수는 "+vs.getcount());
		
		vs.enQueue("메트릭스1");
		vs.enQueue("메트릭스2");
		vs.enQueue("메트릭스2");
		System.out.println("보유햔 비디오 수는 "+vs.getcount());
		
		temp = vs.deQueue();
		System.out.println(temp+"빌림");
		
		temp = vs.deQueue();
		System.out.println(temp+"빌림");
		
		temp = vs.deQueue();
		System.out.println(temp+"빌림");
		
		System.out.println("보유햔 비디오 수는 "+vs.getcount());
	}

}
