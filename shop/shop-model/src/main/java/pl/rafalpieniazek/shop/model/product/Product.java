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
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import pl.rafalpieniazek.shop.model.category.Category;
import pl.rafalpieniazek.shop.model.order.OrderDetail;

@Entity
@Table(name="products")
@Getter
@Setter
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
	@Column(name="id_product")
	private Long Id;

	@NotNull
	private String name;

	@NotNull
	private String description;

	@NotNull
	private Blob image;

	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_category")
	private Category category;

	@NotNull
	private int quantity;

	@NotNull
	private String brand;

	@NotNull
	private String model;

	private Date createdAt;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private OrderDetail orderDetail;
	
}
