import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Start {
	//JDBC 드라이버 로딩 가능 확인
	public static void exam1() {
		// Db 연결 객체
		Connection conn ;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			Class.forName("com.mysql.cj.jdbc.Driver");
			//드라이버클래스://호스트주소:포트/데이터베이스명""아이디""패스워드"
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampleDB","root","1234");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampleDB?serverTimezone=UTC","root","1234");
			System.out.println("데이터 베이스 연결 성공");
			
			
			// 2. 명령 객체(쿼리문을 가지고 실제 DBMS 명령을 내리는 객체)
			Statement st = conn.createStatement();
			
			// 3. 만약 질의문(select)이라면 정보를 담을 수 있는 객체
			ResultSet rs = null;
			
			
			st.execute("select * from emp;");
			rs = st.getResultSet();
			
			rs = st.executeQuery("select * from emp");
						
			while(rs.next()) {
				String str  = rs.getString(1); // SQL의 시작번호는 1부터임
				System.out.println(str);
			}
			
			conn.close(); // 연결 끊김
			System.out.println("데이터 베이스 연결 해제");
		}
		catch(Exception e) {
			System.out.println("error:"+e.getMessage());
		}
		finally {
		}
	}
	
	public static void main(String[] args) {
		exam1();
	}
	
	
}
