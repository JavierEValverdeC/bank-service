package com.nttdata.bank.infraestructura.datos.mapeo;

import com.nttdata.bank.dominio.entidades.CreditDTO;
import com.nttdata.bank.infraestructura.datos.entidades.CreditBE;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Clase mapper de credito.
 */
@Mapper(componentModel = "spring")
public interface CreditMapper {

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "description", target = "description"),
    @Mapping(source = "abbreviation", target = "abbreviation"),
    @Mapping(source = "quantity", target = "quantity")
  })

  CreditDTO toCredit(CreditBE creditBe);

  List<CreditDTO> toCredits(List<CreditBE> creditsBe);

  @InheritInverseConfiguration
  CreditBE toCreditBE(CreditDTO credit);

}