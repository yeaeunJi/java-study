package queue_example1;

public class MyQueue {
	private int max;
	private Object[] arr;
	private int rear;
	private int front;
	
	public MyQueue() {
		this(10);
	}
	
	public MyQueue(int max) {
		this.max = max;
		arr = new Object[max];
		rear = front = 0;
	}
	
	public boolean put(Object data) {
		if (isOverFlow())
			return false;
		arr[rear] = data;
		rear = (rear+1)%max;
		return true;
	}
	
	private boolean isOverFlow() {
		return front==(rear+1)%max;
	}
	
	public Object get() {
		if (isEmpty())
			return null;
		Object obj = arr[front];
		front = (front+1)%max;
		return obj;
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public void printAll() {
		System.out.print("[ front ] ");
		for(int i = front; i != rear; i=(i+1)%max) {
			System.out.print(arr[i] + " ");
		}
		System.out.print(" [ rear ] ");
	}
	
	public void clear() {
		rear = front = 0;
	}
}
