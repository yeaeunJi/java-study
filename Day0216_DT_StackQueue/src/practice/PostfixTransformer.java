package practice;

public class PostfixTransformer {
	public static void main(String[] args) {
		String str = "(A + (B * C))";
//		str = "A+B*C";
//		postfix(str);
		
		str = "(11 + (34 * 41))";
		str = "1+(3*4)-9";
//		str = "(11+(34*41))";
		str =  postfix1(str);
		System.out.println("후위 표현식 : " +str);
		System.out.println("계산 결과 : " +test(str));
	}

	// 1자리 정수만 가능 한 기능으로 후위 표기법에 대한 연산 수행
	// 1. 스택 생성
	// 2. 반복(문자열 끝까지)
	// 	2.1 피연산자라면 : 문자를 숫자로 변경('1'-'0')스택에 push
	// 	2.2 연산자라면 pop으로 연산자의 오른쪽에 붙임
	// 			   pop으로 연산자의 왼쪽에 붙임
	//			   연산자를 이용해 결과값을 생성
	// 			   결과를 스택에 push
	// 문자열이 끝나면 스택에 있는 값 반환
	public static int postfix_cal(String str) {
		
		char[] arr = str.toCharArray();
		MyStack stack = new MyStack(arr.length);
		
		for(char a : arr) {
			if (a == '*' || a == '-' || a=='/'||a=='+') {
				int result = 0;
				int right = (int) stack.pop();
				int left = (int) stack.pop();
				switch(a){
					case '*' :
						result = left * right;
						stack.push(result);
						break;
					case '/' :
						result = left / right;
						stack.push(result);
						break;
					case '-' :
						result = left - right;
						stack.push(result);
						break;
					case '+' :
						result = left + right;
						stack.push(result);
						break;
				}
				
			}
			else if( a >= '0' && a <= '9') {
				stack.push(a-'0');
			}
		}
		return (int)stack.pop();
	}
	
	public static void postfix(String str) {
		// 1. 스택 생성
		// 2. 순환(전달된 문자열의 끝까지)
		//	2.1 '(' 무시
		// 	2.2 피연산자라면 출력
		// 	2.3 연산자(+,-,*,/)라면 스택에 푸쉬
		//	2.4 ')'라면 stack에서 pop하여 출력
		// 3. 스택에 끝가지 갔음에도 stack에 연산자가 남아있다면 모두 출력

		if (str == null ) {
			System.out.println("");
			return;
		}

		char[] arr = str.toCharArray();
		int length = arr.length;
		MyStack stack = new MyStack(length);

		for(char a : arr) {
			if (a == '*' || a == '-' || a=='/'||a=='+') {
				stack.push(a);
			}
			else if (a == ')') {
				System.out.print(stack.pop()+" ");
			}
			else if( a >= 'A' && a <= 'Z') {
				System.out.print(a+" ");
			}
		}

		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}

	// 중위 표기법 문자열을 후위 표기법 문자열로 변환해서 반환처리
	// 피연산자 : 문자를 숫자형 문자 변환 ('0' ~ '9')
	public static String postfix1(String str) {
		if (str == null ) {
			return "";
		}

		String result = "";
		char[] arr = str.toCharArray();
		int length = arr.length;
		MyStack stack = new MyStack(length);

		for(char a : arr) {
			if (a == '*' || a == '-' || a=='/'||a=='+') {
				stack.push(a);
			}
			else if (a == ')') {
				result += stack.pop()+" ";
			}
			else if( a >= '0' && a <= '9') {
				result += a+" ";
			}
		}
		
		while(!stack.isEmpty()) {
			result += stack.pop()+" ";
		}
		return result;
	}

	// 십의 자리 이상도 처리 가능하도록!!!
	public static String postfix2(String str) {
		if (str == null ) {
			return "";
		}

		String result = "";
		
		char[] arr = str.toCharArray();
		
		
		int length = arr.length;
		MyStack stack = new MyStack(length);

		for(int i =0; i<length; i++) {
			char a = arr[i];
			
			if (a == '*' || a == '-' || a=='/'||a=='+') {
				stack.push(a);
			}
			else if (a == ')') {
				result += stack.pop()+" ";
			}
			else if( a >= '0' && a <= '9') {
				int k = i+1;
				result += a;
				do {					
					if (arr[k] >= '0' && arr[k] <= '9') {
						result += arr[k];
						k++;
					}
					else break;
				}while(k<length);
				result += " ";
				i = k-1;
			}
		}
		
		while(!stack.isEmpty()) { // ()가 없는 식 처리하기 위한 코드
			result += stack.pop()+" ";
		}
		return result;
	}

	// 1자리 정수만 가능 한 기능으로 후위 표기법에 대한 연산 수행 간단한 버전
	public static int test(String str) {
			char[] arr 		= str.toCharArray();
			MyStack stack 	= new MyStack(arr.length);
			
			for(char a : arr) {
				if (a == '*' || a == '-' || a=='/'||a=='+') {
					int result = 0;
					int number1 = (int)stack.pop();
					int number2 = (int)stack.pop();
					switch(a){
						case '*' :  result = number2 * number1;	break;
						case '/' :	result = number2 / number1;	break;
						case '-' :  result = number2 - number1; break;
						case '+' :  result = number2 + number1;	break;
					}
					stack.push(result);
				}
				else if( a >= '0' && a <= '9') {
					stack.push((a-'0'));  //문자를 숫자로 변환!
				}
			}
			return (int)stack.pop();
		}
}
