package com.nttdata.bank.aplicacion.rest;

import com.nttdata.bank.dominio.entidades.BankAccountDTO;
import com.nttdata.bank.dominio.servicios.BankAccountService;
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
 * Controlador Cuenta Bancaria.
 */
@RestController
@RequestMapping("/bankAccounts")
public class BankAccountController {

  @Autowired
  private BankAccountService bankAccountService;

  @GetMapping()
  public ResponseEntity<List<BankAccountDTO>> getAll() {
    return new ResponseEntity<>(bankAccountService.getAll(), HttpStatus.OK);
  }

  /**
   * Metodo para obtener cuenta bancaria por id.
   *
   * @param id id de la cuenta bancaria.
   * @return una cuenta bancaria.
   */
  @GetMapping("{id}")
  public ResponseEntity<BankAccountDTO> getBankAccount(@PathVariable int id) {
    return bankAccountService.getBankAccount(id)
              .map(bankAccount -> new ResponseEntity<>(bankAccount, HttpStatus.OK))
              .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping()
  public ResponseEntity<BankAccountDTO> save(@RequestBody BankAccountDTO bankAccount) {
    return new ResponseEntity<BankAccountDTO>(bankAccountService.save(bankAccount),
              HttpStatus.CREATED);
  }

  @PutMapping()
  public ResponseEntity<BankAccountDTO> update(@RequestBody BankAccountDTO bankAccount) {
    return new ResponseEntity<BankAccountDTO>(bankAccountService.update(bankAccount),
            HttpStatus.CREATED);
  }

  /**
   * Metodo para eliminar cuenta bancaria por id.
   *
   * @param id id de la cuenta bancaria.
   * @return estado de eliminacion.
   */
  @DeleteMapping("{id}")
  public ResponseEntity delete(@PathVariable int id) {
    if (bankAccountService.delete(id)) {
      return new ResponseEntity(HttpStatus.OK);
    } else {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }

}
