package com.nttdata.bank.infraestructura.datos.crud;

import com.nttdata.bank.infraestructura.datos.entidades.CreditBE;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio de mantenimiento de Creditos.
 */
public interface CreditCrudRepository extends CrudRepository<CreditBE, Integer> {
  Optional<CreditBE> findByDescriptionIgnoreCase(String description);
}