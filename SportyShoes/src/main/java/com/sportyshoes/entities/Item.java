package com.sportyshoes.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemId;
	
	private String itemName;
	private String forGender;
	private int price;
	private String image;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getForGender() {
		return forGender;
	}
	public void setForGender(String forGender) {
		this.forGender = forGender;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", forGender=" + forGender + ", price=" + price
				+ ", image=" + image + "]";
	}
	public Item(int itemId, String itemName, String forGender, int price, String image) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.forGender = forGender;
		this.price = price;
		this.image = image;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
	