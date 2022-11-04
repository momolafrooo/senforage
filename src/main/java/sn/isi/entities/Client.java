package sn.isi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String address;
	
	@Column(unique = true, nullable = false)
	private String phone;
	
	@ManyToOne
	private Village village;
	
	@OneToMany(mappedBy = "client")
	private List<Subscription> subscriptions = new ArrayList<>();

}
