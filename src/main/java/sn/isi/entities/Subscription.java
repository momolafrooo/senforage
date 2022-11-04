package sn.isi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String description;
	
	@Column(unique = true, nullable = false)
	private int number;
	
	@Column(nullable = false)
	private Date date;
	
	@ManyToOne
	private Client client;

	@OneToOne(mappedBy = "subscription")
	private Meter meter;
}
