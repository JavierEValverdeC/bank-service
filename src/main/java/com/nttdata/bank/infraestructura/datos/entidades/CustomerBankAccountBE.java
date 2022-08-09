package com.nttdata.bank.infraestructura.datos.entidades;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase entidad cuenta bancaria del cliente.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customerBankAccounts") // DB
public class CustomerBankAccountBE {

  @Id
  private int id;

  private CustomerBE customerBe;

  private BankAccountBe bankAccountBe;

  @NotNull
  private String accountNumber;

  @NotNull
  private Float availableBalance;

  @NotNull
  private Float totalDeposit;

  @NotNull
  private Float totalWithdrawals;

}
