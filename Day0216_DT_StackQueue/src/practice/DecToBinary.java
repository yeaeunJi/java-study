package practice;

public class DecToBinary {
	public static String dectobinary(int data) {
		MyLinkedStack stack = new MyLinkedStack();
		String result = "";

		while(data>=2) {
			stack.push(data%2);
			data = data/2;
		}

		stack.push(data);

		while(!stack.isEmpty()) {
			try {
				result += stack.pop();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] value = {0, 1,200, 1000, 1020, 1024};

		for(int a : value) {
			System.out.println("입력한 10진수 "+a+" ==> 이진수 : "+dectobinary(a) );
		}

	}
}
