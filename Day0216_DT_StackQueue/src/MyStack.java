
public class MyStack {
	// 디폴트 접근 지정자 : 동일 패키지에서 자유롭게 접근 가능하므로 기본적으로 private 은닉
	private int max;
	private Object[] arr;
	private int top;
	
	// Default Constructor
	public MyStack() {
		this(10);
	}
	
	// overloading Constructor
	// parameter : int max
	public MyStack(int max) {
		this.max = max;
		arr = new Object[max];
		top = -1;
	}

	// 데이터 저장하는 method
	// step1. overflow check
	// step2. top + 1( top의 초기값이 -1
	// step3. top위치에 데이터 save
	public boolean push(Object data) {
		if (isOverFlow()) {
			return false;
		}
		arr[++top] = data; // 전치 연산 : 해당 문장(;)안에서 가장 먼저 처리되는 것으로 위의 두 코드와 같은 결과
		return true;
	}
	
	// 데이터를 저장할 저장공간이 없는지 체크하는 method
	private boolean isOverFlow() {
		return max <= top + 1; // 연산 결과로 true/false를 반환
	}

	// 데이터를 삭제하는 method
	// step1. isEmpty 검사
	// step2. top 위치에 있는 데이터를 임시 변수에 저장
	// step3. top-1
	// step4. 임시변수에 저장된 정보를 반환
	public Object pop() throws Exception {
		if (isEmpty()) 
			throw new Exception("비어있습니다.");
		return arr[top--]; // 후치 : 해당 구문(;)이 종료된 후 실행!
	}
	
	// 배열이 비어있는지 체크하는 method
	public boolean isEmpty() {
		return top < 0 ;
	}
	
	// 저장된 데이터 전체를 출력하는 method
	public void printAll() {
		System.out.print(" [ 저장 공간("+ max + "개) 중 "+(top+1)+" 개  사용] ");
		for(int i =0; i<=top; i++)
			System.out.print(arr[i]+" ");
	}
	
	// 제일 마지막에 저장된 값을 반환(비어있을 경우 예외처리)
	public Object getTop() throws Exception{
		if (isEmpty())
		//	return null;
			throw new Exception("비어있습니다.");
		return arr[top];
	}
	
	// 초기화(top의 값을 설정)
	public void clear() {
		top = -1;
	}
} // end class
