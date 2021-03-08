
public class Circle extends ShapeAbstract implements A{
	static final double PIE = 3.14;
	int width ;
	int length;
	
	public Circle(int width, int length) {
		this.width = width;
		this.length = length;
	}
	
	
	public void draw() {
		System.out.println("원을 그립니다.");
	}
	
	public double size() {
		return  width *  length * PIE;
	}
	
	public void grab() {;;}
	public void grab2() {;;}
}
