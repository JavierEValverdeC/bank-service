package com.nttdata.bank.infraestructura.datos.interfaces;

import com.nttdata.bank.dominio.entidades.CreditDTO;
import java.util.List;
import java.util.Optional;

/**
 * Clase interfaz de repositorio de credito.
 */
public interface ICreditRepository {

  public List<CreditDTO> getAll();

  public Optional<CreditDTO> getCredit(int idCredit);

  public CreditDTO save(CreditDTO credit);

  public void delete(int idCredit);

  public Optional<CreditDTO> getCreditByDescription(String description);
}
