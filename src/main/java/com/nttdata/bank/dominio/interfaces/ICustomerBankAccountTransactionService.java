package com.nttdata.bank.dominio.interfaces;

import com.nttdata.bank.dominio.entidades.CustomerBankAccountTransactionDTO;
import java.util.List;
import java.util.Optional;

/**
 * Clase de interfaz de servicio de las movimientos bancarios de un cliente.
 */
public interface ICustomerBankAccountTransactionService {

  public List<CustomerBankAccountTransactionDTO> getAll();

  public Optional<CustomerBankAccountTransactionDTO> getCustomerBankAccountTransaction(
          int idCustomerBankAccountTransaction);

  public CustomerBankAccountTransactionDTO save(CustomerBankAccountTransactionDTO
                                                        customerBankAccountTransaction);

  public CustomerBankAccountTransactionDTO update(CustomerBankAccountTransactionDTO
                                                          customerBankAccountTransaction);

  public boolean delete(int idCustomerBankAccountTransaction);
}
