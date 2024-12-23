package com.elp.config;
import com.elp.dto.ClienteDTO;
import com.elp.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MaperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ModelMapper clienteMapper() {
        ModelMapper mapper = new ModelMapper();

        //lectura Get
        mapper.createTypeMap(Cliente.class, ClienteDTO.class)
                .addMapping(Cliente::getNombres,(dest,v) -> dest.setNombreCliente((String) v))
                .addMapping(Cliente::getApellidos,(dest,v) -> dest.setApellidosCliente((String) v));

        //Escritura
        mapper.createTypeMap(ClienteDTO.class, Cliente.class)
                .addMapping(ClienteDTO::getNombreCliente,(dest,v) -> dest.setNombres ((String) v))
                .addMapping(ClienteDTO::getApellidosCliente,(dest,v) -> dest.setApellidos((String) v));
        return mapper;
    }
}
