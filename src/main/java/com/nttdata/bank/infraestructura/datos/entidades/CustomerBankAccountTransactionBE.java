package com.nttdata.bank.infraestructura.datos.entidades;

import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase entidad movimiento de cuenta bancaria de un cliente.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customerBankAccountTransactions") // DB
public class CustomerBankAccountTransactionBE {

  @Id
  private int id;

  private CustomerBankAccountBE customerBankAccountBe;

  @NotNull
  private Float availableBalance;

  private Float depositAmount;

  private Float withdrawalsAmount;

  @NotNull
  private int flagDeposit;

  @NotNull
  private int flagWithdrawals;

  @NotNull
  private Date dateTransaction;

}
