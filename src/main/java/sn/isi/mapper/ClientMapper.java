package sn.isi.mapper;

import org.mapstruct.Mapper;
import sn.isi.dto.ClientDto;
import sn.isi.entities.Client;

@Mapper
public interface ClientMapper {

    Client toEntity(ClientDto clientDto);
    ClientDto toDto(Client client);
}
