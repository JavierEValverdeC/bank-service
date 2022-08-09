package com.nttdata.bank.dominio.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase DTO credito.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "credits") // DB
public class CreditDTO {

  private int id;

  private String description;

  private String abbreviation;

  private int quantity;

}
