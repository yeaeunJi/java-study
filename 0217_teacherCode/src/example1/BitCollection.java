package example1;

//�迭�� ���Ḯ��Ʈ�� ���� ���!
public interface BitCollection {
	int getSize();    		//[public abstract] int getSize(); //�߻� �޼���
	Object getData(int idx);
	void Insert(Object obj) throws Exception;
	void Delete(int idx) throws Exception;
}
