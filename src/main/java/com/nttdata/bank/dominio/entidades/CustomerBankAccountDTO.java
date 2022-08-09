package com.nttdata.bank.dominio.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase dto de la cuenta bancaria de un cliente.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customerBankAccounts") // DB
public class CustomerBankAccountDTO {

  private int id;

  private CustomerDTO customerDto;

  private BankAccountDTO bankAccountDto;

  private String accountNumber;

  private Float availableBalance;

  private Float totalDeposit;

  private Float totalWithdrawals;
}