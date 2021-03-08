package common;

public class MyStack {
	//디폴트 접근지정를 설정 : 동일 패키지에서 자유롭게 접근 가능!
	private int max;
	private Object[] arr;
	private int top;

	//생성자
	public MyStack() {
		this(10);
	}
	
	public MyStack(int max) {
		this.max = max;
		arr = new Object[max];
		this.top = -1;
	}

	//메서드
	private boolean IsOverflow() {
		//if (max <= top + 1)
		//	return true;
		//else
		//	return false;
		return max <= top +1;
	}
	
	public boolean Push(Object data)  {
		if (IsOverflow())
			return false;
		
//		top++;
//		arr[top] = data;
		arr[++top] = data;  //전치 :  해당 문장(;) 에서 가장 먼저 처리되는 것!
		return true;
	}

	public boolean IsEmpty() {
		return top == -1;
	}
	
	public Object Pop() {
		if (IsEmpty())
			return null;

//		Object ar = arr[top];
//		top--;
//		return ar;
		return arr[top--];      //후치 : 해당구문이(;) 종료된 후 실행!
	}

	public void PrintAll() {		
		for(int i=0; i<= top; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public Object GetTop() throws Exception {
		if( IsEmpty())
			throw new Exception("비어있습니다.");
		
		return arr[top];		
	}

	public void Clear() {
		top = -1;
	}
}





