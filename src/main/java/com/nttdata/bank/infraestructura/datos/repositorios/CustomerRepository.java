package com.nttdata.bank.infraestructura.datos.repositorios;

import com.nttdata.bank.dominio.entidades.CustomerDTO;
import com.nttdata.bank.infraestructura.datos.crud.CustomerCrudRepository;
import com.nttdata.bank.infraestructura.datos.entidades.CustomerBE;
import com.nttdata.bank.infraestructura.datos.interfaces.ICustomerRepository;
import com.nttdata.bank.infraestructura.datos.mapeo.CustomerMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase repositorio de clientes.
 */
@Repository
public class CustomerRepository implements ICustomerRepository {

  @Autowired
  private CustomerCrudRepository customerCrudRepository;

  @Autowired
  private CustomerMapper customerBeMapper;

  @Override
  public List<CustomerDTO> getAll() {
    List<CustomerBE> customerBes = (List<CustomerBE>) customerCrudRepository.findAll();
    return customerBeMapper.toCustomers(customerBes);
  }

  @Override
  public Optional<CustomerDTO> getCustomer(int customerId) {
    return customerCrudRepository.findById(customerId)
            .map(customerBE -> customerBeMapper.toCustomer(customerBE));
  }

  @Override
  public Optional<CustomerDTO> getCustomerByDocumentNumber(String identityDocumentNumber) {
    return customerCrudRepository.findByIdentityDocumentNumberIgnoreCase(identityDocumentNumber)
            .map(customerBE -> customerBeMapper.toCustomer(customerBE));
  }

  @Override
  public CustomerDTO save(CustomerDTO customer) {
    CustomerBE customerBe = customerBeMapper.toCustomerBE(customer);
    return customerBeMapper.toCustomer(customerCrudRepository.save(customerBe));
  }

  @Override
  public void delete(int customerId) {
    customerCrudRepository.deleteById(customerId);
  }

}
