package pl.rafalpieniazek.shop.model.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import pl.rafalpieniazek.shop.model.order.Order;
@Entity
@Table(name="users")
public class User {
	
	@Id
	@Getter
	@Setter
	@GeneratedValue
	@Column(name="id_user")
	private Long Id;
	
	@Getter
	@Setter
	private String firstName;
	
	@Getter
	@Setter
	private String lastName;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String password;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "user", targetEntity = Order.class, cascade = CascadeType.ALL)
	private Set<Order> orders;
}
