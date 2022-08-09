package com.nttdata.bank.dominio.servicios;

import com.nttdata.bank.dominio.entidades.BankAccountDTO;
import com.nttdata.bank.dominio.interfaces.IBankAccountService;
import com.nttdata.bank.infraestructura.datos.repositorios.BankAccountRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

/**
 * Servicio Cuenta Bancaria.
 */
@Service
public class BankAccountService implements IBankAccountService {

  @Autowired
  private BankAccountRepository bankAccountRepository;

  @Override
  public List<BankAccountDTO> getAll() {
    return bankAccountRepository.getAll();
  }

  @Override
  public Optional<BankAccountDTO> getBankAccountByDescription(String description) {
    return bankAccountRepository.getBankAccountByDescription(description);
  }

  @Override
  public Optional<BankAccountDTO> getBankAccount(int idBankAccount) {
    return bankAccountRepository.getBankAccount(idBankAccount);
  }

  @Override
  public BankAccountDTO save(BankAccountDTO bankAccount) {
    String description = bankAccount.getDescription();
    if (getBankAccount(bankAccount.getId()).isPresent()) {
      throw new ApplicationContextException("La cuenta bancaria con id "
              + bankAccount.getId() + " ya ha sido registrada.");
    }
    if (getBankAccountByDescription(description).isEmpty()) {
      return bankAccountRepository.save(bankAccount);
    } else {
      throw new ApplicationContextException("La cuenta bancaria " + description
              + " ya ha sido registrado.");
    }
  }

  @Override
  public BankAccountDTO update(BankAccountDTO bankAccount) {
    if (getBankAccount(bankAccount.getId()).isPresent()) {
      if (getBankAccountByDescription(bankAccount.getDescription()).isEmpty()) {
        return bankAccountRepository.save(bankAccount);
      } else {
        throw new ApplicationContextException("La cuenta bancaria "
                + bankAccount.getDescription() + " ya ha sido registrada.");
      }
    } else {
      throw new ApplicationContextException("No existe la cuenta bancaria con el "
              + "id ingresado.");
    }
  }

  @Override
  public boolean delete(int idBankAccount) {

    return getBankAccount(idBankAccount)
            .map(bankAccount -> {
              bankAccountRepository.delete(idBankAccount);
              return true;
            }).orElse(false);
  }

}