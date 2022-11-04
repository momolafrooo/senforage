package sn.isi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {

	private int id;

	@NotNull(message = "Le montant en chiffre est obligatoire")
	private int amountInNumber;

	@NotNull(message = "Le montant en lettre est obligatoire")
	private String amountInLetter;

}
