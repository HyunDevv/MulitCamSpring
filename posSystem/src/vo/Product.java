package vo;

public class Product {
	private String id;
	private String name;
	private int price;
	private String img;
	public Product() {
		super();
	}
	public Product(String id, String name, int price, String img) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getImg() {
		return img;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", img=" + img + "]";
	}
	
	

}
