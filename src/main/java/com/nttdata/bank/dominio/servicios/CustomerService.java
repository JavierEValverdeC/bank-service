package com.nttdata.bank.dominio.servicios;

import com.nttdata.bank.dominio.entidades.CustomerDTO;
import com.nttdata.bank.dominio.interfaces.ICustomerService;
import com.nttdata.bank.infraestructura.datos.repositorios.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

/**
 * Clase servicio del cliente.
 */
@Service
public class CustomerService implements ICustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public List<CustomerDTO> getAll() {
    return customerRepository.getAll();
  }

  @Override
  public Optional<CustomerDTO> getCustomerByDocumentNumber(String documentNumber) {
    return customerRepository.getCustomerByDocumentNumber(documentNumber);
  }

  @Override
  public Optional<CustomerDTO> getCustomer(int idCustomer) {
    return customerRepository.getCustomer(idCustomer);
  }

  @Override
  public CustomerDTO save(CustomerDTO customer) {
    String documentNumber = customer.getIdentityDocumentNumber();
    if (getCustomer(customer.getId()).isPresent()) {
      throw new ApplicationContextException("El usuario con id "
              + customer.getId() + " ya ha sido registrado");
    }
    if (getCustomerByDocumentNumber(documentNumber).isEmpty()) {
      return customerRepository.save(customer);
    } else {
      throw new ApplicationContextException("El usuario con Numero de Documento de Identidad "
              + documentNumber + " ya ha sido registrado");
    }
  }

  @Override
  public CustomerDTO update(CustomerDTO customer) {
    if (getCustomer(customer.getId()).isPresent()) {
      if (getCustomerByDocumentNumber(customer.getIdentityDocumentNumber()).isEmpty()) {
        return customerRepository.save(customer);
      } else {
        throw new ApplicationContextException("El usuario con Numero "
                + "de Documento de Identidad " + customer.getIdentityDocumentNumber()
                + " ya ha sido registrado");
      }
    } else {
      throw new ApplicationContextException("No existe el usuario con el id ingresado.");
    }
  }

  @Override
  public boolean delete(int idCustomer) {

    return getCustomer(idCustomer)
            .map(customer -> {
              customerRepository.delete(idCustomer);
              return true;
            }).orElse(false);
  }

}