package example1;

//배열과 연결리스트의 구현 약속!
public interface BitCollection {
	int getSize();    		//[public abstract] int getSize(); //추상 메서드
	Object getData(int idx);
	void Insert(Object obj) throws Exception;
	void Delete(int idx) throws Exception;
}
