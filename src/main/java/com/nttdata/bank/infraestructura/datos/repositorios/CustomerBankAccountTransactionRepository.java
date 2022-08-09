package com.nttdata.bank.infraestructura.datos.repositorios;

import com.nttdata.bank.dominio.entidades.CustomerBankAccountTransactionDTO;
import com.nttdata.bank.infraestructura.datos.crud.CustomerBankAccountTransactionCrudRepository;
import com.nttdata.bank.infraestructura.datos.entidades.CustomerBankAccountTransactionBE;
import com.nttdata.bank.infraestructura.datos.interfaces.ICustomerBankAccountTransactionRepository;
import com.nttdata.bank.infraestructura.datos.mapeo.CustomerBankAccountTransactionMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase repositorio de movimientos cuentas bancarias de clientes.
 */
@Repository
public class CustomerBankAccountTransactionRepository implements
        ICustomerBankAccountTransactionRepository {

  @Autowired
  private CustomerBankAccountTransactionCrudRepository customerBankAccountTransactionCrudRepository;

  @Autowired
  private CustomerBankAccountTransactionMapper customerBankAccountTransactionBeMapper;

  @Override
  public List<CustomerBankAccountTransactionDTO> getAll() {
    List<CustomerBankAccountTransactionBE> customerBankAccountTransactionBes =
            (List<CustomerBankAccountTransactionBE>) customerBankAccountTransactionCrudRepository
                    .findAll();
    return customerBankAccountTransactionBeMapper.toCustomerBankAccountTransactions(
            customerBankAccountTransactionBes);
  }

  @Override
  public Optional<CustomerBankAccountTransactionDTO> getCustomerBankAccountTransaction(
          int customerBankAccountTransactionId) {
    return customerBankAccountTransactionCrudRepository.findById(customerBankAccountTransactionId)
            .map(customerBankAccountTransactionBE ->
                    customerBankAccountTransactionBeMapper.toCustomerBankAccountTransaction(
                            customerBankAccountTransactionBE));
  }

  @Override
  public CustomerBankAccountTransactionDTO save(
          CustomerBankAccountTransactionDTO customerBankAccountTransaction) {
    CustomerBankAccountTransactionBE customerBankAccountTransactionBe =
            customerBankAccountTransactionBeMapper.toCustomerBankAccountTransactionBE(
                    customerBankAccountTransaction);
    return customerBankAccountTransactionBeMapper.toCustomerBankAccountTransaction(
            customerBankAccountTransactionCrudRepository.save(customerBankAccountTransactionBe));
  }
  
  @Override
  public void delete(int customerBankAccountTransactionId) {
    customerBankAccountTransactionCrudRepository.deleteById(customerBankAccountTransactionId);
  }

}
