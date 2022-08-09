package com.nttdata.bank.dominio.entidades;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase dto movimiento de cuenta bancaria de cliente.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customerBankAccountTransactions") // DB
public class CustomerBankAccountTransactionDTO {

  private int id;

  private CustomerBankAccountDTO customerBankAccountDto;

  private Float availableBalance;

  private Float depositAmount;

  private Float withdrawalsAmount;

  private int flagDeposit;

  private int flagWithdrawals;

  private Date dateTransaction;
}
