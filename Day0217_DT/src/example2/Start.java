package example2;

public class Start {
	public static void main(String[] args) {
		ParseTree tree = new ParseTree();

		tree.makeParseTree("3 2 + 4 * 2 -");
		
		System.out.println(tree.count);
		System.out.println((char)tree.root.key);
		
		System.out.print("전위 : ");  tree.preOrder();
		System.out.print("전위 non recur: ");  tree.preOrder_NonRecur();
		System.out.print("전위  preOrderNonRecursive: ");  tree.preOrderNonRecursive();
		System.out.print("중위 : ");  tree.inOrder();
		System.out.print("후위 : ");  tree.postOrder();
	}
}
