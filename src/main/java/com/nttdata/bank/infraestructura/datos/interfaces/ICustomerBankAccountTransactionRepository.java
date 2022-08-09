package com.nttdata.bank.infraestructura.datos.interfaces;

import com.nttdata.bank.dominio.entidades.CustomerBankAccountTransactionDTO;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz de repositorio de movimiento de cuenta bancaria de cliente.
 */
public interface ICustomerBankAccountTransactionRepository {

  public List<CustomerBankAccountTransactionDTO> getAll();

  public Optional<CustomerBankAccountTransactionDTO> getCustomerBankAccountTransaction(
          int idCustomerBankAccountTransaction);

  public CustomerBankAccountTransactionDTO save(
          CustomerBankAccountTransactionDTO customerBankAccountTransaction);

  public void delete(int idCustomerBankAccountTransaction);

}
