import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class TestCollection2 {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("사과");
		list.add( "바나나");
		list.add("토마토");
		
		HashSet<String> a = new HashSet<String>();
		
		int duplicatedNum = 0;
		
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			String fruits = iter.next();
			if( a.add(fruits)) {
					;;
			}else {
				duplicatedNum++;
				System.out.println(fruits+"은 이미 들어있는 과일입니다.");
			}
		}
		
		System.out.println("중복된 과일의 수 : "+duplicatedNum);
		
		
		
		
	}
}
