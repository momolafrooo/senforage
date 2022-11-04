package sn.isi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {

	private int id;

	@NotNull(message = "La description est obligatoire")
	private String description;

	@NotNull(message = "La numéro est obligatoire")
	private int number;

	@NotNull(message = "La date est obligatoire")
	private Date date;

}
