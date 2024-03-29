package com.skip.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "date")
	private String date;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
	@Column(name = "delivery_address")
	private String delivery_address;
	@Column(name = "contact")
	private String contact;
	@Column(name = "store_id")
	private int store_id;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_items", referencedColumnName = "id")
	private List<Orderitem> orderitem;
	@Column(name = "total")
	private double total;
	@Column(name = "status")
	private String status;
	@Column(name = "last_update")
	private String last_update;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public List<Orderitem> getOrderitem() {
		return orderitem;
	}
	public void setOrderitem(List<Orderitem> orderitem) {
		this.orderitem = orderitem;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
}
