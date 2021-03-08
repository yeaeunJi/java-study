
public class Novel  extends Book implements ILendable{
	
	public Novel(String title,  String bookId, String writer) {
		super(title, bookId, "Novel", writer);
	}
	
	public void lend(String user, String date) {
		if (this.isLendOk()) {
			this.setLendOk(false);
			this.setLender( user);
			this.setLendDate(date);
//			System.out.println(this.getTitle()+"이 대출되었습니다.");
			System.out.println(this.toString());
		}
		else System.out.println("이미 대출된 책입니다.");
		

	}
	
	public void returnBook() {
		this.setLendOk( true);
		System.out.println("반납되었습니다.");
	}
	
	
}
