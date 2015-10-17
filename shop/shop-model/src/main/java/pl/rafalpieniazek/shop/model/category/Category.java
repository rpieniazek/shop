package pl.rafalpieniazek.shop.model.category;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.rafalpieniazek.shop.model.product.Product;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue
	@Getter
	@Column(name="id_category")
	private Long Id;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String detail;
	
	@OneToMany(mappedBy = "category", targetEntity = Product.class, cascade = CascadeType.ALL)
	private Set<Product> products;
}
