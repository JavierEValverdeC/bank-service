package com.nttdata.bank.aplicacion.rest;

import com.nttdata.bank.dominio.entidades.CreditDTO;
import com.nttdata.bank.dominio.servicios.CreditService;
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
 * Controlador de Creditos.
 */
@RestController
@RequestMapping("/credits")
public class CreditController {

  @Autowired
  private CreditService creditService;

  @GetMapping()
  public ResponseEntity<List<CreditDTO>> getAll() {
    return new ResponseEntity<>(creditService.getAll(), HttpStatus.OK);
  }

  /**
   * Obtener credito por id.
   *
   * @param id id del credito.
   * @return un credito.
   */
  @GetMapping("{id}")
  public ResponseEntity<CreditDTO> getCredit(@PathVariable int id) {
    return creditService.getCredit(id)
            .map(credit -> new ResponseEntity<>(credit, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping()
  public ResponseEntity<CreditDTO> save(@RequestBody CreditDTO credit) {
    return new ResponseEntity<CreditDTO>(creditService.save(credit), HttpStatus.CREATED);
  }

  @PutMapping()
  public ResponseEntity<CreditDTO> update(@RequestBody CreditDTO credit) {
    return new ResponseEntity<CreditDTO>(creditService.update(credit), HttpStatus.CREATED);
  }

  /**
   * Elimina un credito.
   *
   * @param id id del credito.
   * @return estado de eliminacion.
   */
  @DeleteMapping("{id}")
  public ResponseEntity delete(@PathVariable int id) {

    if (creditService.delete(id)) {
      return new ResponseEntity(HttpStatus.OK);
    } else {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }

}
