package org.jsp.userfood.dto;
import java.time.LocalDateTime;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class FoodOrder 
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@UpdateTimestamp
private LocalDateTime deltime;
@CreationTimestamp
private LocalDateTime orderedtime;
private int price;
private String address;
private String itemname;
@ManyToOne
@JoinColumn
private User users;
@Override
public String toString() {
	return "FoodOrder [id=" + id + ", deltime=" + deltime + ", orderedtime=" + orderedtime + ", price=" + price
			+ ", address=" + address + ", itemname=" + itemname + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public LocalDateTime getDeltime() {
	return deltime;
}
public void setDeltime(LocalDateTime deltime) {
	this.deltime = deltime;
}
public LocalDateTime getOrderedtime() {
	return orderedtime;
}
public void setOrderedtime(LocalDateTime orderedtime) {
	this.orderedtime = orderedtime;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getItemname() {
	return itemname;
}
public void setItemname(String itemname) {
	this.itemname = itemname;
}
public User getUsers() {
	return users;
}
public void setUsers(User users) {
	this.users = users;
}
}
