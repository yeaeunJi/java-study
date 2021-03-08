
public interface IPrinter {
	// 흑백 인쇄
	public abstract String noColorPrint(String paper);
	
	// 컬러 인쇄
	public abstract String colorPrint(String paper);
	
	// 스캔
	public abstract String scan(String paper); 
}
