package com.nttdata.bank.infraestructura.datos.crud;

import com.nttdata.bank.infraestructura.datos.entidades.BankAccountBe;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio Cuenta Bancaria.
 */
public interface BankAccountCrudRepository extends CrudRepository<BankAccountBe, Integer> {
  Optional<BankAccountBe> findByDescriptionIgnoreCase(String description);
}