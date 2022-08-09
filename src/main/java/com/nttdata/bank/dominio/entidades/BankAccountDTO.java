package com.nttdata.bank.dominio.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * DTO Cuenta Bancaria.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bankAccounts") // DB
public class BankAccountDTO {

  private int id;

  private String description;

  private String abbreviation;

  private Float commissionForMaintenance;

  private int monthlyWithdrawals;

  private int monthlyDeposit;

}

