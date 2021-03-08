import java.text.SimpleDateFormat;
import java.util.Date;

public class Now {
		SimpleDateFormat dayTime = new SimpleDateFormat("[hh:mm:ss]");
		private String time = dayTime.format(new Date());
		
		private String name = "";
			
		public void setTime(String t) {
			time = t;
		}
		
		public String getTime() {
			return time;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String n) {
			name = n;
		}
		
		
		
}
