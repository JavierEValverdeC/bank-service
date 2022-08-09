package com.nttdata.bank.infraestructura.datos.repositorios;

import com.nttdata.bank.dominio.entidades.CreditDTO;
import com.nttdata.bank.infraestructura.datos.crud.CreditCrudRepository;
import com.nttdata.bank.infraestructura.datos.entidades.CreditBE;
import com.nttdata.bank.infraestructura.datos.interfaces.ICreditRepository;
import com.nttdata.bank.infraestructura.datos.mapeo.CreditMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase de repositorio de creditos.
 */
@Repository
public class CreditRepository implements ICreditRepository {

  @Autowired
  private CreditCrudRepository creditCrudRepository;

  @Autowired
  private CreditMapper creditBeMapper;

  @Override
  public List<CreditDTO> getAll() {
    List<CreditBE> creditBes = (List<CreditBE>) creditCrudRepository.findAll();
    return creditBeMapper.toCredits(creditBes);
  }

  @Override
  public Optional<CreditDTO> getCredit(int creditId) {
    return creditCrudRepository.findById(creditId)
            .map(creditBE -> creditBeMapper.toCredit(creditBE));
  }

  @Override
  public Optional<CreditDTO> getCreditByDescription(String description) {
    return creditCrudRepository.findByDescriptionIgnoreCase(description)
            .map(creditBE -> creditBeMapper.toCredit(creditBE));
  }

  @Override
  public CreditDTO save(CreditDTO credit) {
    CreditBE creditBe = creditBeMapper.toCreditBE(credit);
    return creditBeMapper.toCredit(creditCrudRepository.save(creditBe));
  }

  @Override
  public void delete(int creditId) {
    creditCrudRepository.deleteById(creditId);
  }

}
