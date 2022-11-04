package sn.isi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

	private int id;

	@NotNull(message = "Le nom est obligatoire")
	private String name;

	@NotNull(message = "L'adresse est obligatoire")
	private String address;

	@NotNull(message = "Le téléphone est obligatoire")
	private String phone;

}
