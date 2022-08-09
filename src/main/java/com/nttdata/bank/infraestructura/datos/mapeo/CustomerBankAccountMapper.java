package com.nttdata.bank.infraestructura.datos.mapeo;

import com.nttdata.bank.dominio.entidades.CustomerBankAccountDTO;
import com.nttdata.bank.infraestructura.datos.entidades.CustomerBankAccountBE;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Clase mapper de la cuenta bancaria de un cliente.
 */
@Mapper(componentModel = "spring")
public interface CustomerBankAccountMapper {

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "customerBe", target = "customerDto"),
    @Mapping(source = "bankAccountBe", target = "bankAccountDto"),
    @Mapping(source = "accountNumber", target = "accountNumber"),
    @Mapping(source = "availableBalance", target = "availableBalance"),
    @Mapping(source = "totalDeposit", target = "totalDeposit"),
    @Mapping(source = "totalWithdrawals", target = "totalWithdrawals")
  })

  CustomerBankAccountDTO toCustomerBankAccount(CustomerBankAccountBE customerBankAccountBe);

  List<CustomerBankAccountDTO> toCustomerBankAccounts(List<CustomerBankAccountBE>
                                                              customerBankAccountsBe);

  @InheritInverseConfiguration
  CustomerBankAccountBE toCustomerBankAccountBE(CustomerBankAccountDTO customerBankAccount);

}