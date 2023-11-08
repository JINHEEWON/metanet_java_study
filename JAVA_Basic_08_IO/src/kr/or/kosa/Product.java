package kr.or.kosa;

import java.io.Serializable;

public abstract class Product implements Serializable{
	protected String name;
	protected int price;
	protected String seller;
	
	Product(String name, int price, String seller) {
		this.name = name;
		this.price = price;
		this.seller = seller;
	}
	
	abstract public void printDetailInfo();
}
