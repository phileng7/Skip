package com.skip.entity;

import java.io.Serializable;
/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;	*/

import javax.persistence.*;

@Entity
@Table(name = "orderitem")
public class Orderitem implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private int id;
	@Id
	@Column(name = "order_id")
	private int order_id;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
	private Product product;
	@Column(name = "price")
	private double price;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "total")
	private double total;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Product geProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
