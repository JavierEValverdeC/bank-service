package com.nttdata.bank.infraestructura.datos.interfaces;

import com.nttdata.bank.dominio.entidades.BankAccountDTO;
import java.util.List;
import java.util.Optional;

/**
 * Clase Interfaz de repositorio de cuenta bancaria.
 */
public interface IBankAccountRepository {

  public List<BankAccountDTO> getAll();

  public Optional<BankAccountDTO> getBankAccount(int idBankAccount);

  public BankAccountDTO save(BankAccountDTO bankAccount);

  public void delete(int idBankAccount);

  public Optional<BankAccountDTO> getBankAccountByDescription(String description);

}
