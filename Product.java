
public class Product {

	private String name;
	private double cost;
	private boolean hot;
	
	private int stock;
	
	public Product(String name, double cost, boolean hot, int stock) {
		this.name = name;
		this.cost = cost;
		this.hot = hot;
		this.stock = stock;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public boolean isHot() {
		return hot;
	}

	public void setHot(boolean hot) {
		this.hot = hot;
	}

	public int getStock() {
		return stock;
	}

	public void deduct(int amount) {
		this.stock -=  amount;
	}

}
