package pl.rafalpieniazek.shop.model.order;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import pl.rafalpieniazek.shop.model.product.Product;

@Entity
@Table(name="order_details")
public class OrderDetail {

	@Id
	@GeneratedValue
	@Getter
	@Column(name="id_order_details")
	private Long Id;
	
	
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order")
	private Order order;
	
	@OneToOne(mappedBy = "order", targetEntity = OrderDetail.class, cascade = CascadeType.ALL)
	private Product product;
	
}
