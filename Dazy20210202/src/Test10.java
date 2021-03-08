
public class Test10 {

	public static void main(String[] args) {
		Novel novel = new Novel("소설책1","123", "작가1" );
		Magazine magazine = new Magazine("잡지책1","123", "작가2" );
		
		novel.lend("철수","2021.02.03");
		magazine.lend("민희","2021.02.03");
		novel.lend("철수","2021.02.03");
		novel.returnBook();
		magazine.returnBook();
	}

}
