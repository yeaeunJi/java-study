package common;
// 배열과 연결리스트의 구현 약속을 하기위한 인터페이스 
public interface BitCollection {
	int getSize(); //  자동으로 추상메서드가 됨. public abstract가 붙음
	Object getData(int idx);
	 void Insert(Object obj) throws Exception;
	 void Delete(int idx) throws Exception;
}
