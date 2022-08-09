package com.nttdata.bank.infraestructura.datos.interfaces;

import com.nttdata.bank.dominio.entidades.CustomerDTO;
import java.util.List;
import java.util.Optional;

/**
 * Clase interfaz de repositorio de cliente.
 */
public interface ICustomerRepository {

  public List<CustomerDTO> getAll();

  public Optional<CustomerDTO> getCustomer(int idCustomer);

  public CustomerDTO save(CustomerDTO customer);

  public void delete(int idCustomer);

  public Optional<CustomerDTO> getCustomerByDocumentNumber(String identityDocumentNumber);
}
