
public class Seat {
	private boolean isUsed = false;
	
	public void reservation() {
		this.isUsed = true;
//		System.out.print(" 1 ");
	}
	
	
	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public void cancle() {
		this.isUsed = false;
//		System.out.print(" 0 ");
	}
	
	public String toString() {
		return " "+ (this.isUsed==false?0:1)+" ";
	}

	
}
