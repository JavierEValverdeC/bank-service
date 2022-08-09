package com.nttdata.bank.dominio.servicios;

import com.nttdata.bank.dominio.entidades.CustomerBankAccountTransactionDTO;
import com.nttdata.bank.dominio.interfaces.ICustomerBankAccountTransactionService;
import com.nttdata.bank.infraestructura.datos.repositorios.CustomerBankAccountRepository;
import com.nttdata.bank.infraestructura.datos.repositorios.CustomerBankAccountTransactionRepository;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

/**
 * Clase Servicio de movimiento de cuenta bancaria de clientes.
 */
@Service
public class CustomerBankAccountTransactionService implements
        ICustomerBankAccountTransactionService {

  @Autowired
  private CustomerBankAccountTransactionRepository customerBankAccountTransactionRepository;

  @Autowired
  private CustomerBankAccountRepository customerBankAccountRepository;

  @Override
  public List<CustomerBankAccountTransactionDTO> getAll() {
    return customerBankAccountTransactionRepository.getAll();
  }


  @Override
  public Optional<CustomerBankAccountTransactionDTO> getCustomerBankAccountTransaction(
          int idCustomerBankAccountTransaction) {
    return customerBankAccountTransactionRepository.getCustomerBankAccountTransaction(
            idCustomerBankAccountTransaction);
  }

  @Override
  public CustomerBankAccountTransactionDTO save(
          CustomerBankAccountTransactionDTO customerBankAccountTransaction) {
    if (getCustomerBankAccountTransaction(customerBankAccountTransaction.getId()).isPresent()) {
      throw new ApplicationContextException("Ya existe el movimiento "
              + "bancario con el id ingresado.");
    }

    if (customerBankAccountTransaction.getCustomerBankAccountDto() != null) {
      if (customerBankAccountRepository.getCustomerBankAccount(
              customerBankAccountTransaction.getCustomerBankAccountDto().getId()).isEmpty()) {
        throw new ApplicationContextException("La cuenta bancaria del cliente "
                + "NO EXISTE o se ha dado de baja");
      }
    } else {
      throw new ApplicationContextException("Debe ingresar una cuenta bancaria de un cliente");
    }
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    customerBankAccountTransaction.setDateTransaction(timestamp);
    return customerBankAccountTransactionRepository.save(customerBankAccountTransaction);
  }

  @Override
  public CustomerBankAccountTransactionDTO update(
          CustomerBankAccountTransactionDTO customerBankAccountTransaction) {
    if (getCustomerBankAccountTransaction(customerBankAccountTransaction.getId()).isPresent()) {
      if (customerBankAccountTransaction.getCustomerBankAccountDto() != null) {
        if (customerBankAccountRepository.getCustomerBankAccount(
              customerBankAccountTransaction.getCustomerBankAccountDto().getId()).isEmpty()) {
          throw new ApplicationContextException("La cuenta bancaria del cliente "
                  + "NO EXISTE o se ha dado de baja");
        }
      } else {
        throw new ApplicationContextException("Debe ingresar una cuenta bancaria de un cliente");
      }
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      customerBankAccountTransaction.setDateTransaction(timestamp);
      return customerBankAccountTransactionRepository.save(customerBankAccountTransaction);
    } else {
      throw new ApplicationContextException("No se encontraron datos");
    }
  }

  @Override
  public boolean delete(int idCustomerBankAccountTransaction) {

    return getCustomerBankAccountTransaction(idCustomerBankAccountTransaction)
            .map(customerBankAccountTransaction -> {
              customerBankAccountTransactionRepository.delete(idCustomerBankAccountTransaction);
              return true;
            }).orElse(false);
  }

}