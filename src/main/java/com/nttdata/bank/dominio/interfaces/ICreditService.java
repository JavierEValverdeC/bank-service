package com.nttdata.bank.dominio.interfaces;

import com.nttdata.bank.dominio.entidades.CreditDTO;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio de credito.
 */
public interface ICreditService {

  public List<CreditDTO> getAll();

  public Optional<CreditDTO> getCredit(int idCredit);

  public CreditDTO save(CreditDTO credit);

  public CreditDTO update(CreditDTO credit);

  public boolean delete(int idCredit);

  public Optional<CreditDTO> getCreditByDescription(String description);
}
