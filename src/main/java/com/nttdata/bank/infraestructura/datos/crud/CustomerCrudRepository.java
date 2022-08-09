package com.nttdata.bank.infraestructura.datos.crud;

import com.nttdata.bank.infraestructura.datos.entidades.CustomerBE;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz de repositorio de mantenimiento de clientes.
 */
public interface CustomerCrudRepository extends CrudRepository<CustomerBE, Integer> {
  Optional<CustomerBE> findByIdentityDocumentNumberIgnoreCase(String identityDocumentNumber);
}