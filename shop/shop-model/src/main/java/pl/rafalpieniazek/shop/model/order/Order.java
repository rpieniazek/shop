package pl.rafalpieniazek.shop.model.order;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import pl.rafalpieniazek.shop.model.user.User;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue
	@Getter
	@Column(name="id_order")
	private Long Id;
	
	
	@Getter
	@Setter
	private String shippingAdress;
	
	@Getter
	@Setter
	private Date createdAt;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	private User user;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "order", targetEntity = OrderDetail.class, cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails;
	
}	
