package com.nttdata.bank.infraestructura.datos.entidades;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase entidad cliente.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers") // DB
public class CustomerBE {

  @Id
  private int id;

  @NotNull
  private String type;

  @NotNull
  private String identityDocumentNumber;

  @NotNull
  private String name;

  @NotNull
  private String lastName;

  @NotNull
  private String phone;

  @NotNull
  private String email;

}
