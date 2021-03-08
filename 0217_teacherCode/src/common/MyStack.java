package common;

public class MyStack {
	//����Ʈ ���������� ���� : ���� ��Ű������ �����Ӱ� ���� ����!
	private int max;
	private Object[] arr;
	private int top;

	//������
	public MyStack() {
		this(10);
	}
	
	public MyStack(int max) {
		this.max = max;
		arr = new Object[max];
		this.top = -1;
	}

	//�޼���
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
		arr[++top] = data;  //��ġ :  �ش� ����(;) ���� ���� ���� ó���Ǵ� ��!
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
		return arr[top--];      //��ġ : �ش籸����(;) ����� �� ����!
	}

	public void PrintAll() {		
		for(int i=0; i<= top; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public Object GetTop() throws Exception {
		if( IsEmpty())
			throw new Exception("����ֽ��ϴ�.");
		
		return arr[top];		
	}

	public void Clear() {
		top = -1;
	}
}





