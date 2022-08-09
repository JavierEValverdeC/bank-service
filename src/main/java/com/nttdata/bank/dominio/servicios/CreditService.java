package com.nttdata.bank.dominio.servicios;

import com.nttdata.bank.dominio.entidades.CreditDTO;
import com.nttdata.bank.dominio.interfaces.ICreditService;
import com.nttdata.bank.infraestructura.datos.repositorios.CreditRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

/**
 * Clase servicio de creditos.
 */
@Service
public class CreditService implements ICreditService {

  @Autowired
  private CreditRepository creditRepository;

  @Override
  public List<CreditDTO> getAll() {
    return creditRepository.getAll();
  }

  @Override
  public Optional<CreditDTO> getCreditByDescription(String description) {
    return creditRepository.getCreditByDescription(description);
  }

  @Override
  public Optional<CreditDTO> getCredit(int idCredit) {
    return creditRepository.getCredit(idCredit);
  }

  @Override
  public CreditDTO save(CreditDTO credit) {
    String description = credit.getDescription();
    if (getCredit(credit.getId()).isPresent()) {
      throw new ApplicationContextException("El credito con id " + credit.getId()
              + " ya ha sido registrado");
    }
    if (getCreditByDescription(description).isEmpty()) {
      return creditRepository.save(credit);
    } else {
      throw new ApplicationContextException("El credito " + description + " ya ha sido registrado");
    }
  }

  @Override
  public CreditDTO update(CreditDTO credit) {
    if (getCredit(credit.getId()).isPresent()) {
      if (getCreditByDescription(credit.getDescription()).isEmpty()) {
        return creditRepository.save(credit);
      } else {
        throw new ApplicationContextException("El credito " + credit.getDescription()
                + " ya ha sido registrado");
      }
    } else {
      throw new ApplicationContextException("No existe el credito con el id ingresado.");
    }
  }

  @Override
  public boolean delete(int idCredit) {

    return getCredit(idCredit)
            .map(credit -> {
              creditRepository.delete(idCredit);
              return true;
            }).orElse(false);
  }

}