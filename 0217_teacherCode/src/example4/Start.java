package example4;

public class Start {
	public static void main(String[] args) {
		MyBSearchTree bst = new MyBSearchTree();
		
		//저장 테스트......
		System.out.print("저장값 : ");
		int value =-1;
		for(int i=0; i<10; i++) {			
			 value = (int)(Math.random()*100)+1; //1~100
			System.out.print(value + " ");
			//bst.Insert_NonRe(value);
			bst.Insert(value);
		}
		
		//결과 확인......
		System.out.println("\n[순회 결과값]");
		bst.InOrder();		//오름차순...
		
		//검색 테스트....
		//MyBSearchTree.Node node = bst.Search(value);
		MyBSearchTree.Node node = bst.Search_NonR(value);
		
		if(node == null)
			System.out.println("없다");
		else
			System.out.println("찾은값 ; " + node.key);		
		
		//--------삭제-------------
//		bst.Delete(value);
		bst.delete(value);
		//검색 테스트....
		//MyBSearchTree.Node node = bst.Search(value);
		node = bst.Search_NonR(value);
		if(node == null)
			System.out.println("없다");
		else
			System.out.println("찾은값 ; " + node.key);
		System.out.println("\n[순회 결과값]");
		bst.InOrder();		//오름차순...
	}
}
