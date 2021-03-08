package practice;

public class ReverseString {
	public static void main(String[] args) {
		String str = "abcdefg012345";
//		str = null;
		str = "";
		String rstr = reverseString(str);
		System.out.println("원본 : "+str);
		System.out.println("변경 : "+rstr);
	}

	public static String reverseString(String str) {
		if (str == null)
			return "";
		
		char[] reverseStr = str.toCharArray();
		MyStack stack = new MyStack(reverseStr.length);

		for(char s :  reverseStr) {
			stack.push(s);
		}

		String result = "";
		while(!stack.isEmpty()) {
			try {
				result += stack.pop();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
