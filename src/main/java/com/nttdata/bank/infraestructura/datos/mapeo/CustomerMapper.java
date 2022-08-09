package com.nttdata.bank.infraestructura.datos.mapeo;

import com.nttdata.bank.dominio.entidades.CustomerDTO;
import com.nttdata.bank.infraestructura.datos.entidades.CustomerBE;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Clase Mapper del cliente.
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "type", target = "type"),
    @Mapping(source = "identityDocumentNumber", target = "identityDocumentNumber"),
    @Mapping(source = "name", target = "name"),
    @Mapping(source = "lastName", target = "lastName"),
    @Mapping(source = "phone", target = "phone"),
    @Mapping(source = "email", target = "email")
  })

  CustomerDTO toCustomer(CustomerBE customerBe);

  List<CustomerDTO> toCustomers(List<CustomerBE> customersBe);

  @InheritInverseConfiguration
  CustomerBE toCustomerBE(CustomerDTO customer);

}