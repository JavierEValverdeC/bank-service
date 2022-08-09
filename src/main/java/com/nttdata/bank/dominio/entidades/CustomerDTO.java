package com.nttdata.bank.dominio.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase dto cliente.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers") // DB
public class CustomerDTO {

  private int id;

  private String type;

  private String identityDocumentNumber;

  private String name;

  private String lastName;

  private String phone;

  private String email;

}

