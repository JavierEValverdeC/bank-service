package com.nttdata.bank.infraestructura.datos.repositorios;

import com.nttdata.bank.dominio.entidades.BankAccountDTO;
import com.nttdata.bank.infraestructura.datos.crud.BankAccountCrudRepository;
import com.nttdata.bank.infraestructura.datos.entidades.BankAccountBe;
import com.nttdata.bank.infraestructura.datos.interfaces.IBankAccountRepository;
import com.nttdata.bank.infraestructura.datos.mapeo.BankAccountMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de Cuenta Bancaria.
 */
@Repository
public class BankAccountRepository implements IBankAccountRepository {

  @Autowired
  private BankAccountCrudRepository bankAccountCrudRepository;

  @Autowired
  private BankAccountMapper bankAccountBeMapper;

  @Override
  public List<BankAccountDTO> getAll() {
    List<BankAccountBe> bankAccountBes = (List<BankAccountBe>)
            bankAccountCrudRepository.findAll();
    return bankAccountBeMapper.toBankAccounts(bankAccountBes);
  }

  @Override
  public Optional<BankAccountDTO> getBankAccount(int bankAccountId) {
    return bankAccountCrudRepository.findById(bankAccountId)
            .map(bankAccountBE -> bankAccountBeMapper.toBankAccount(bankAccountBE));
  }

  @Override
  public Optional<BankAccountDTO> getBankAccountByDescription(String description) {
    return bankAccountCrudRepository.findByDescriptionIgnoreCase(description)
            .map(bankAccountBE -> bankAccountBeMapper.toBankAccount(bankAccountBE));
  }

  @Override
  public BankAccountDTO save(BankAccountDTO bankAccount) {
    BankAccountBe bankAccountBe = bankAccountBeMapper.toBankAccountBE(bankAccount);
    return bankAccountBeMapper.toBankAccount(bankAccountCrudRepository.save(bankAccountBe));
  }

  @Override
  public void delete(int bankAccountId) {
    bankAccountCrudRepository.deleteById(bankAccountId);
  }

}
