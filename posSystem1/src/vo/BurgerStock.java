package vo;

public class BurgerStock {
	private String name;
	private int stock;

	public BurgerStock() {
		super();
	}

	public BurgerStock(String name, int stock) {
		super();
		this.name = name;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "BurgerStock [name=" + name + ", stock=" + stock + "]";
	}

}
