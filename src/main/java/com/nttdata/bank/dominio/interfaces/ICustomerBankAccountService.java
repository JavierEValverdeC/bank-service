package com.nttdata.bank.dominio.interfaces;

import com.nttdata.bank.dominio.entidades.CustomerBankAccountDTO;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio de cuenta bancaria de cliente.
 */
public interface ICustomerBankAccountService {

  public List<CustomerBankAccountDTO> getAll();

  public Optional<CustomerBankAccountDTO> getCustomerBankAccount(int idCustomerBankAccount);

  public CustomerBankAccountDTO save(CustomerBankAccountDTO customerBankAccount);

  public CustomerBankAccountDTO update(CustomerBankAccountDTO customerBankAccount);

  public boolean delete(int idCustomerBankAccount);
}
