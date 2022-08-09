package com.nttdata.bank.aplicacion.rest;

import com.nttdata.bank.dominio.entidades.CustomerBankAccountDTO;
import com.nttdata.bank.dominio.servicios.CustomerBankAccountService;
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
 * Controlador de cuenta bancaria del cliente.
 */
@RestController
@RequestMapping("/customerBankAccounts")
public class CustomerBankAccountController {

  @Autowired
  private CustomerBankAccountService customerBankAccountService;

  @GetMapping()
  public ResponseEntity<List<CustomerBankAccountDTO>> getAll() {
    return new ResponseEntity<>(customerBankAccountService.getAll(), HttpStatus.OK);
  }

  /**
   * Obtiene la cuenta bancaria de un cliente.
   *
   * @param id id de la cuenta bancaria del cliente.
   * @return clase dto de la cuenta bancaria de un cliente.
   */
  @GetMapping("{id}")
  public ResponseEntity<CustomerBankAccountDTO> getCustomerBankAccount(@PathVariable int id) {
    return customerBankAccountService.getCustomerBankAccount(id)
            .map(customerBankAccount -> new ResponseEntity<>(customerBankAccount, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping()
  public ResponseEntity<CustomerBankAccountDTO> save(@RequestBody CustomerBankAccountDTO
                                                               customerBankAccount) {
    return new ResponseEntity<CustomerBankAccountDTO>(customerBankAccountService.save(
              customerBankAccount), HttpStatus.CREATED);
  }

  @PutMapping()
  public ResponseEntity<CustomerBankAccountDTO> update(
          @RequestBody CustomerBankAccountDTO customerBankAccount) {
    return new ResponseEntity<CustomerBankAccountDTO>(customerBankAccountService.update(
            customerBankAccount), HttpStatus.CREATED);
  }

  /**
   * Elimina la cuenta bancaria de un cliente.
   *
   * @param id id de la cuenta bancaria de un cliente.
   * @return estado de la eliminacion de la cuenta bancaria de un cliente.
   */
  @DeleteMapping("{id}")
  public ResponseEntity delete(@PathVariable int id) {

    if (customerBankAccountService.delete(id)) {
      return new ResponseEntity(HttpStatus.OK);
    } else {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }

}
