package com.nttdata.bank.infraestructura.datos.entidades;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase entidad cuenta bancaria.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bankAccounts") // DB
public class BankAccountBe {
  @Id
  private int id;

  @NotNull
  private String description;

  @NotNull
  private String abbreviation;

  @NotNull
  private Float commissionForMaintenance;

  @NotNull
  private int monthlyWithdrawals;

  @NotNull
  private int monthlyDeposit;

}
