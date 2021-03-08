
public class Book {
	
	private String title;
	private String lender;
	private String writer;
	private boolean lendOk ;
	private String lendDate ;
	private String category ;
	
	public Book(String title,  String bookId, String category, String writer) {
		this.title = title;
		this.lendOk = true;
		this.category = category;
		this.writer = writer;
	}
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getLender() {
		return lender;
	}


	public void setLender(String lender) {
		this.lender = lender;
	}


	public boolean isLendOk() {
		return lendOk;
	}


	public void setLendOk(boolean lendOk) {
		this.lendOk = lendOk;
	}


	public String getLendDate() {
		return lendDate;
	}


	public void setLendDate(String lendDate) {
		this.lendDate = lendDate;
	}


	public String toString() {
		return "대출자 : "+this.lender +", 제목 : "+this.title+", 카테고리 : "+this.category+", 대출일자 : "+this.lendDate;
	}
}
