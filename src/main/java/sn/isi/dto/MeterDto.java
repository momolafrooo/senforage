package sn.isi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeterDto {

	private int id;

	@NotNull(message = "Le numéro est obligatoire")
	private int number;

	@NotNull(message = "Le cumul est obligatoire")
	private int cumul;

}
