import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Product {

	private int price;
	private String category;
	private int totalPrice;
	private HashMap<String, Integer> menu;
	private Queue<String> orderList ;

	public Product() {
		menu = new HashMap<String, Integer>();
		this.orderList = new LinkedList<String>();
		menu.put("TV",100);
		menu.put("Computer", 200);
	}	

	public void order(String food) {
		orderList.offer(food);
		totalPrice += menu.get(food);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public HashMap<String, Integer> getMenu() {
		return menu;
	}

	public void setMenu(HashMap<String, Integer> menu) {
		this.menu = menu;
	}

	public Queue<String> getOrderList() {
		return orderList;
	}

	public void setOrderList(Queue<String> orderList) {
		this.orderList = orderList;
	}



}

