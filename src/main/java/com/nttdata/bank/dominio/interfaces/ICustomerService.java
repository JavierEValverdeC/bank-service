package com.nttdata.bank.dominio.interfaces;

import com.nttdata.bank.dominio.entidades.CustomerDTO;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio de Cliente.
 */
public interface ICustomerService {

  public List<CustomerDTO> getAll();

  public Optional<CustomerDTO> getCustomer(int idCustomer);

  public CustomerDTO save(CustomerDTO customer);

  public CustomerDTO update(CustomerDTO customer);

  public boolean delete(int idCustomer);

  public Optional<CustomerDTO> getCustomerByDocumentNumber(String documentNumber);
}
