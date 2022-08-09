package com.nttdata.bank.infraestructura.datos.repositorios;

import com.nttdata.bank.dominio.entidades.CustomerBankAccountDTO;
import com.nttdata.bank.infraestructura.datos.crud.CustomerBankAccountCrudRepository;
import com.nttdata.bank.infraestructura.datos.entidades.CustomerBankAccountBE;
import com.nttdata.bank.infraestructura.datos.interfaces.ICustomerBankAccountRepository;
import com.nttdata.bank.infraestructura.datos.mapeo.CustomerBankAccountMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase repositorio de la cuenta bancaria de un cliente.
 */
@Repository
public class CustomerBankAccountRepository implements ICustomerBankAccountRepository {

  @Autowired
  private CustomerBankAccountCrudRepository customerBankAccountCrudRepository;

  @Autowired
  private CustomerBankAccountMapper customerBankAccountBeMapper;

  @Override
  public List<CustomerBankAccountDTO> getAll() {
    List<CustomerBankAccountBE> customerBankAccountBes = (List<CustomerBankAccountBE>)
            customerBankAccountCrudRepository.findAll();
    return customerBankAccountBeMapper.toCustomerBankAccounts(customerBankAccountBes);
  }

  @Override
  public Optional<CustomerBankAccountDTO> getCustomerBankAccount(int customerBankAccountId) {
    return customerBankAccountCrudRepository.findById(customerBankAccountId)
            .map(customerBankAccountBE ->
                    customerBankAccountBeMapper.toCustomerBankAccount(customerBankAccountBE));
  }

  @Override
  public CustomerBankAccountDTO save(CustomerBankAccountDTO customerBankAccount) {
    CustomerBankAccountBE customerBankAccountBe =
            customerBankAccountBeMapper.toCustomerBankAccountBE(customerBankAccount);
    return customerBankAccountBeMapper.toCustomerBankAccount(
            customerBankAccountCrudRepository.save(customerBankAccountBe));
  }

  @Override
  public void delete(int customerBankAccountId) {
    customerBankAccountCrudRepository.deleteById(customerBankAccountId);
  }

}
