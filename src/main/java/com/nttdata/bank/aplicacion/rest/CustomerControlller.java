package com.nttdata.bank.aplicacion.rest;

import com.nttdata.bank.dominio.entidades.CustomerDTO;
import com.nttdata.bank.dominio.servicios.CustomerService;
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
 * Controlador de clientes.
 */
@RestController
@RequestMapping("/customers")
public class CustomerControlller {

  @Autowired
  private CustomerService customerService;

  @GetMapping()
  public ResponseEntity<List<CustomerDTO>> getAll() {
    return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
  }

  /**
   * Obtener cliente por id.
   *
   * @param id id del cliente.
   * @return clase dto cliente.
   */
  @GetMapping("{id}")
  public ResponseEntity<CustomerDTO> getCustomer(@PathVariable int id) {
    return customerService.getCustomer(id)
            .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping()
  public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customer) {
    return new ResponseEntity<CustomerDTO>(customerService.save(customer), HttpStatus.CREATED);
  }

  @PutMapping()
  public ResponseEntity<CustomerDTO> update(@RequestBody CustomerDTO customer) {
    return new ResponseEntity<CustomerDTO>(customerService.update(customer), HttpStatus.CREATED);
  }

  /**
   * Eliminar un cliente.
   *
   * @param id id del cliente.
   * @return estado de eliminacion del cliente.
   */
  @DeleteMapping("{id}")
  public ResponseEntity delete(@PathVariable int id) {

    if (customerService.delete(id)) {
      return new ResponseEntity(HttpStatus.OK);
    } else {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }

}
