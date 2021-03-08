package example2;

public class MyLinkedStack {
	private MyDList list = new MyDList();
	
	public boolean push(Object data) {
		return list.push_front(data);
	}
	
	// 비어 있는 상태 체크(비어있다면 null 반환)
	public boolean isEmpty() {
		MyDList.DNode node = list.getHead();
		return node == null?true:false;
	}
	
	// 비어 있는 상태 체크(비어있다면 null 반환)
	//삭제하기 전에 head가 가지고 있는 값을 저장
	//리스트에서 삭제
	public Object pop() throws Exception {
		if (isEmpty())
			throw new Exception("비어있습니다.");
		Object data = list.getHead().data; // isEmpty를 통해 null처리가 되었기때문에 한줄로 처리 가능
		list.erase_front();
		return data;
	}
	
	public void printAll() {
		list.selectNextAll();
	}
	
	public Object getTop() throws Exception{
		if (isEmpty())
			throw new Exception("비어있습니다.");
		return  list.getHead().data;
	}
	
	public void clear() {
		list.clear();
	}
}
