package com.nttdata.bank.infraestructura.datos.interfaces;

import com.nttdata.bank.dominio.entidades.CustomerBankAccountDTO;
import java.util.List;
import java.util.Optional;

/**
 * Clase interfaz de repositorio de cuenta bancaria de cliente.
 */
public interface ICustomerBankAccountRepository {

  public List<CustomerBankAccountDTO> getAll();

  public Optional<CustomerBankAccountDTO> getCustomerBankAccount(int idCustomerBankAccount);

  public CustomerBankAccountDTO save(CustomerBankAccountDTO customerBankAccount);

  public void delete(int idCustomerBankAccount);

}
