package com.nttdata.bank.infraestructura.datos.entidades;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase Entidad Credito.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "credits") // DB
public class CreditBE {
  @Id
  private int id;

  @NotNull
  private String description;

  @NotNull
  private String abbreviation;

  @NotNull
  private int quantity;

}
