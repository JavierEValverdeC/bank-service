package com.nttdata.bank.dominio.servicios;

import com.nttdata.bank.dominio.entidades.CustomerDTO;
import com.nttdata.bank.infraestructura.datos.repositorios.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

public class CustomerServiceIT {

    @Mock
    private CustomerRepository customerRepository;

    CustomerService customerService;

    @Test
    void save() throws Exception
    {
        //given
        CustomerDTO customerDTO = CustomerDTO.builder()
                .id(1)
                .type("personal")
                .identityDocumentNumber("12345678")
                .name("Javier")
                .lastName("Valverde")
                .phone("987654321")
                .email("javiervalverde@gmail.com")
                .build();
        given(customerRepository.save(any(CustomerDTO.class))).willReturn(customerDTO);

        //when
        CustomerDTO customerDTOsCreated = customerService.save(customerDTO);

        //then
        then(customerRepository).should().save(any(CustomerDTO.class));
        assertThat(customerDTOsCreated).isNotNull();
    }

}
