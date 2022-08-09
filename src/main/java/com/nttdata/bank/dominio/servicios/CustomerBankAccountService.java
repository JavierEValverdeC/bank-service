package com.nttdata.bank.dominio.servicios;

import com.nttdata.bank.dominio.entidades.CustomerBankAccountDTO;
import com.nttdata.bank.dominio.interfaces.ICustomerBankAccountService;
import com.nttdata.bank.infraestructura.datos.repositorios.BankAccountRepository;
import com.nttdata.bank.infraestructura.datos.repositorios.CustomerBankAccountRepository;
import com.nttdata.bank.infraestructura.datos.repositorios.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

/**
 * Clase servicio cliente cuenta bancaria.
 */
@Service
public class CustomerBankAccountService implements ICustomerBankAccountService {

  @Autowired
  private CustomerBankAccountRepository customerBankAccountRepository;

  @Autowired
  private BankAccountRepository bankAccountRepository;

  @Autowired
  private CustomerRepository customerRepository;


  @Override
  public List<CustomerBankAccountDTO> getAll() {
    return customerBankAccountRepository.getAll();
  }

  @Override
  public Optional<CustomerBankAccountDTO> getCustomerBankAccount(int idCustomerBankAccount) {
    return customerBankAccountRepository.getCustomerBankAccount(idCustomerBankAccount);
  }

  @Override
  public CustomerBankAccountDTO save(CustomerBankAccountDTO customerBankAccount) {

    if (getCustomerBankAccount(customerBankAccount.getId()).isPresent()) {
      throw new ApplicationContextException("La cuenta bancaria del cliente "
              + "con el id ingresado ya existe");
    }

    if (customerBankAccount.getCustomerDto() != null) {
      if (customerRepository.getCustomer(customerBankAccount.getCustomerDto().getId()).isEmpty()) {
        throw new ApplicationContextException("El cliente ingresado NO EXISTE");
      }
    } else {
      throw new ApplicationContextException("No ingresado el cliente a registrar");
    }

    if (customerBankAccount.getBankAccountDto() != null) {
      if (bankAccountRepository.getBankAccount(
              customerBankAccount.getBankAccountDto().getId()).isEmpty()) {
        throw new ApplicationContextException("No existe el tipo de cuenta bancaria ingresada");
      }
    } else {
      throw new ApplicationContextException("Debe ingresar una cuenta bancaria o credito");
    }

    if (customerRepository.getCustomer(
            customerBankAccount.getCustomerDto().getId()).get().getType().equals("empresarial")) {
      if (bankAccountRepository.getBankAccount(
              customerBankAccount.getBankAccountDto().getId()).get().getDescription()
              .equals("Cuenta corriente")) {
        return customerBankAccountRepository.save(customerBankAccount);
      } else {
        throw new ApplicationContextException("El cliente es de "
                + "tipo empresarial y solo puede tener multiples cuentas corrientes");
      }
    }

    return customerBankAccountRepository.save(customerBankAccount);
  }

  @Override
  public CustomerBankAccountDTO update(CustomerBankAccountDTO customerBankAccount) {
    if (customerBankAccount.getCustomerDto() != null) {
      if (customerRepository.getCustomer(customerBankAccount.getCustomerDto().getId()).isEmpty()) {
        throw new ApplicationContextException("El cliente ingresado NO EXISTE");
      }
    } else {
      throw new ApplicationContextException("No ingresado el cliente a registrar");
    }

    if (customerBankAccount.getBankAccountDto() != null) {
      if (bankAccountRepository.getBankAccount(
              customerBankAccount.getBankAccountDto().getId()).isEmpty()) {
        throw new ApplicationContextException("No existe el tipo de cuenta bancaria ingresada");
      }
    } else {
      throw new ApplicationContextException("Debe ingresar una cuenta bancaria o credito");
    }

    if (customerRepository.getCustomer(
            customerBankAccount.getCustomerDto().getId()).get().getType().equals("empresarial")) {
      if (!bankAccountRepository.getBankAccount(
              customerBankAccount.getBankAccountDto().getId()).get()
              .getDescription().equals("Cuenta corriente")) {
        throw new ApplicationContextException("El cliente es de tipo empresarial "
                + "y solo puede tener multiples cuentas corrientes");
      }
    }
    if (getCustomerBankAccount(customerBankAccount.getId()).isPresent()) {
      return customerBankAccountRepository.save(customerBankAccount);
    } else {
      throw new ApplicationContextException("No se encontraron datos");
    }

  }

  @Override
  public boolean delete(int idCustomerBankAccount) {

    return getCustomerBankAccount(idCustomerBankAccount)
            .map(customerBankAccount -> {
              customerBankAccountRepository.delete(idCustomerBankAccount);
              return true;
            }).orElse(false);
  }

}