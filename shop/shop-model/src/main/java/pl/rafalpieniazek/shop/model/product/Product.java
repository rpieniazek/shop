package pl.rafalpieniazek.shop.model.product;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import pl.rafalpieniazek.shop.model.category.Category;
import pl.rafalpieniazek.shop.model.order.OrderDetail;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.sql.Date;

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


	private String name;


	private String description;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_category")
	private Category category;


	private int quantity;


	private String brand;


	private String model;

	private Date createdAt;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private OrderDetail orderDetail;
	
}
