package common;

public class MyLinkedStack {
	private MyDList list = new MyDList();

	public boolean Push(Object data) {
		return list.push_front(data);
	}
	
	public boolean IsEmpty() {
		MyDList.DNode node = list.getHead();
		if(node == null)
			return true;
		else
			return false;
	}
	
	public Object Pop() {
		//����ִ� ���� üũ(����ִٸ� null)
		if(IsEmpty())
			return null;
		//�����ϱ� ���� head�� ���� �ִ� ���� ȹ��!
		//MyDList.DNode node = list.getHead();
		//Object data = node.data;
		Object data = list.getHead().data;
		list.erase_front();
		return data;
	}
	
	public void PrintAll() {
		list.Select_PrevAll();
	}
	
	public Object GetTop() throws Exception{
		MyDList.DNode node = list.getHead();
		if(node == null)
			throw new Exception("����ִ�.");
		return node.data;
	}
	
	public void Clear() {
		list.Clear();
	}
}
