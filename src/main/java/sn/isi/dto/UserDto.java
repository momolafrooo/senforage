package sn.isi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private int id;

	@NotNull(message = "Le prénom est obligatoire")
	private String firstName;

	@NotNull(message = "Le nom est obligatoire")
	private String lastName;

	@NotNull(message = "L'email est obligatoire")
	private String email;

	@NotNull(message = "Le mot de passe est obligatoire")
	private String password;

	@NotNull(message = "Le champs active est obligatoire")
	private Boolean active;
}
