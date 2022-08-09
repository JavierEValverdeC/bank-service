package com.nttdata.bank.aplicacion.rest;

import com.nttdata.bank.dominio.entidades.CustomerBankAccountTransactionDTO;
import com.nttdata.bank.dominio.servicios.CustomerBankAccountTransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador Movimiento de cuenta bancaria de un cliente.
 */
@RestController
@RequestMapping("/customerBankAccountTransactions")
public class CustomerBankAccountTransactionController {

  @Autowired
  private CustomerBankAccountTransactionService customerBankAccountTransactionService;

  @GetMapping()
  public ResponseEntity<List<CustomerBankAccountTransactionDTO>> getAll() {
    return new ResponseEntity<>(customerBankAccountTransactionService.getAll(), HttpStatus.OK);
  }

  /**
   * Obtener movimientos de cuenta bancarias de clientes.
   *
   * @param id id movimiento de cuenta bancaria de cliente.
   * @return clase dto movimiento de cuenta bancaria de clientes.
   */
  @GetMapping("{id}")
  public ResponseEntity<CustomerBankAccountTransactionDTO> getCustomerBankAccountTransaction(
          @PathVariable int id) {
    return customerBankAccountTransactionService.getCustomerBankAccountTransaction(id)
            .map(customerBankAccountTransaction -> new ResponseEntity<>(
                    customerBankAccountTransaction, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  /**
   * Guardar movimiento de cuenta bancaria de un cliente.
   *
   * @param customerBankAccountTransaction clase movimiento de cuenta bancaria de un cliente.
   * @return clase dto de movimiento de cuenta bancaria de un cliente.
   */
  @PostMapping()
  public ResponseEntity<CustomerBankAccountTransactionDTO> save(
          @RequestBody CustomerBankAccountTransactionDTO customerBankAccountTransaction) {
    return new ResponseEntity<CustomerBankAccountTransactionDTO>(
            customerBankAccountTransactionService.save(customerBankAccountTransaction),
            HttpStatus.CREATED);
  }

  /**
   * Guardar movimiento de cuenta bancaria de un cliente.
   *
   * @param customerBankAccountTransaction clase movimiento de cuenta bancaria de un cliente.
   * @return clase dto de movimiento de cuenta bancaria de un cliente.
   */
  @PutMapping()
  public ResponseEntity<CustomerBankAccountTransactionDTO> update(
          @RequestBody CustomerBankAccountTransactionDTO customerBankAccountTransaction) {
    return new ResponseEntity<CustomerBankAccountTransactionDTO>(
            customerBankAccountTransactionService.update(
                    customerBankAccountTransaction), HttpStatus.CREATED);
  }

  /**
   * Eliminar movimiento de cuenta bancaria de un cliente.
   *
   * @param id id de movimiento de cuenta bancaria de un cliente.
   * @return estado de eliminacion.
   */
  @DeleteMapping("{id}")
  public ResponseEntity delete(@PathVariable int id) {

    if (customerBankAccountTransactionService.delete(id)) {
      return new ResponseEntity(HttpStatus.OK);
    } else {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }

}
