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
public class Meter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private int number;
	
	@Column(nullable = false)
	private int cumul;
	
	@OneToOne
	private Subscription subscription;
	
	@OneToMany(mappedBy = "meter")
	private List<Invoice> invoices = new ArrayList<>();
}
