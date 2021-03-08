package queue_example2_LinkedQueue;


public class MyLinkedQueue {
	private MyDList list = new MyDList();
	
	public MyLinkedQueue() {
		list = new MyDList();
	}
	
	public boolean put(Object data) {
		return list.push_back(data);
	}
	
	
	public Object get() {
		if (isEmpty())
			return null;
		Object obj = list.getHead().data;
		list.erase_front();
		return obj ;
	}
	
	public boolean isEmpty() {
		return list.getHead()==null?true:false;
	}
	
	public void printAll() {
		System.out.print("[ front ] ");
		list.selectNextAll();
		System.out.print(" [ rear ] ");
	}
	
	public void clear() {
		list.clear();
	}
}
