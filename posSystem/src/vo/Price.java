package vo;

import java.util.Arrays;

public class Price {
	private String name;
	private int[] data;
	public Price() {
		super();
	}
	public Price(String name, int[] data) {
		super();
		this.name = name;
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public int[] getData() {
		return data;
	}
	@Override
	public String toString() {
		return "Price [name=" + name + ", data=" + Arrays.toString(data) + "]";
	}
	

}
