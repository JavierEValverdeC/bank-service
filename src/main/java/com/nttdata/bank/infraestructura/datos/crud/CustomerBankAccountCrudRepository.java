package com.nttdata.bank.infraestructura.datos.crud;

import com.nttdata.bank.infraestructura.datos.entidades.CustomerBankAccountBE;
import org.springframework.data.repository.CrudRepository;

/**
 * Clase repositorio de la cuenta bancaria de un cliente.
 */
public interface CustomerBankAccountCrudRepository extends
        CrudRepository<CustomerBankAccountBE, Integer> {
}