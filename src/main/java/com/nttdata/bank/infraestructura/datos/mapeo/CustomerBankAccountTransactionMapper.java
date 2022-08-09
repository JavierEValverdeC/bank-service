package com.nttdata.bank.infraestructura.datos.mapeo;

import com.nttdata.bank.dominio.entidades.CustomerBankAccountTransactionDTO;
import com.nttdata.bank.infraestructura.datos.entidades.CustomerBankAccountTransactionBE;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Clase Mapper de movimientos de cuentas bancarias de clientes.
 */
@Mapper(componentModel = "spring")
public interface CustomerBankAccountTransactionMapper {

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "customerBankAccountBe", target = "customerBankAccountDto"),
    @Mapping(source = "availableBalance", target = "availableBalance"),
    @Mapping(source = "depositAmount", target = "depositAmount"),
    @Mapping(source = "withdrawalsAmount", target = "withdrawalsAmount"),
    @Mapping(source = "flagDeposit", target = "flagDeposit"),
    @Mapping(source = "flagWithdrawals", target = "flagWithdrawals"),
    @Mapping(source = "dateTransaction", target = "dateTransaction")
  })

  CustomerBankAccountTransactionDTO toCustomerBankAccountTransaction(
          CustomerBankAccountTransactionBE customerBankAccountTransactionBe);

  List<CustomerBankAccountTransactionDTO> toCustomerBankAccountTransactions(
          List<CustomerBankAccountTransactionBE> customerBankAccountTransactionsBe);

  @InheritInverseConfiguration
  CustomerBankAccountTransactionBE toCustomerBankAccountTransactionBE(
          CustomerBankAccountTransactionDTO customerBankAccountTransaction);

}