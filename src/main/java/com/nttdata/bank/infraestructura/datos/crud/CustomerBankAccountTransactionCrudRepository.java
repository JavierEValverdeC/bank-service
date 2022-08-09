package com.nttdata.bank.infraestructura.datos.crud;

import com.nttdata.bank.infraestructura.datos.entidades.CustomerBankAccountTransactionBE;
import org.springframework.data.repository.CrudRepository;

/**
 * Clase interfaz de repositorio de mantenimiento de movimientos de cuenta bancarias de clientes.
 */
public interface CustomerBankAccountTransactionCrudRepository extends
        CrudRepository<CustomerBankAccountTransactionBE, Integer> {

}