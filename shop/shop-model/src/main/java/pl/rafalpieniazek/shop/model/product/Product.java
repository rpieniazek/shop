package pl.rafalpieniazek.shop.model.product;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import pl.rafalpieniazek.shop.model.category.Category;
import pl.rafalpieniazek.shop.model.order.OrderDetail;

@Entity
@Table(name="products")
public class Product {

	public Product() {
	}

	public Product(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue
	@Getter
	@Column(name="id_product")
	private Long Id;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String description;
	
	@Getter
	@Setter
	private Blob image;
	
	@Getter
	@Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_category")
	private Category category;
	
	//quantity//ilosc
	@Getter
	@Setter
	private int quantity;
	
	@Getter
	@Setter
	private String brand;
	
	@Getter
	@Setter
	private String model;
	
	@Getter
	@Setter
	private Date createdAt;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@Getter
	@Setter
	private OrderDetail orderDetail;
	
}
