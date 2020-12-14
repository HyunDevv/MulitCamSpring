package com.vo;

import java.sql.Date;

public class Product {           //컬럼명과 동일하게 정한다
	private int id;
	private String name;
	private int price;
	private double rate;
	private Date regdate;
	public Product() {
	}
	public Product(int id, String name, int price, double rate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.rate = rate;
	}
	public Product(int id, String name, int price, double rate, Date regdate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.rate = rate;
		this.regdate = regdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", rate=" + rate + ", regdate=" + regdate
				+ "]";
	}

	
	
}
