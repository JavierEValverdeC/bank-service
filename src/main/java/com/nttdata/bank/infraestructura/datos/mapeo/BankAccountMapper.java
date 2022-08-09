package com.nttdata.bank.infraestructura.datos.mapeo;

import com.nttdata.bank.dominio.entidades.BankAccountDTO;
import com.nttdata.bank.infraestructura.datos.entidades.BankAccountBe;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Mapper Cuenta Bancaria.
 */
@Mapper(componentModel = "spring")
public interface BankAccountMapper {

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "description", target = "description"),
    @Mapping(source = "abbreviation", target = "abbreviation"),
    @Mapping(source = "commissionForMaintenance", target = "commissionForMaintenance"),
    @Mapping(source = "monthlyWithdrawals", target = "monthlyWithdrawals"),
    @Mapping(source = "monthlyDeposit", target = "monthlyDeposit")
  })
  BankAccountDTO toBankAccount(BankAccountBe bankAccountBe);

  List<BankAccountDTO> toBankAccounts(List<BankAccountBe> bankAccountsBe);

  @InheritInverseConfiguration
  BankAccountBe toBankAccountBE(BankAccountDTO bankAccount);

}