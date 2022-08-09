package com.nttdata.bank.dominio.interfaces;

import com.nttdata.bank.dominio.entidades.BankAccountDTO;
import java.util.List;
import java.util.Optional;

/**
 * Clase infterfaz de servicio de cuenta bancaria.
 */
public interface IBankAccountService {

  public List<BankAccountDTO> getAll();

  public Optional<BankAccountDTO> getBankAccount(int idBankAccount);

  public BankAccountDTO save(BankAccountDTO bankAccount);

  public BankAccountDTO update(BankAccountDTO bankAccount);

  public boolean delete(int idBankAccount);

  public Optional<BankAccountDTO> getBankAccountByDescription(String description);
}
