package com.viktoriyatp.client;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

  ClientDto toClientDto (Client client);

  Client toClient(ClientRequestDto clientRequestDto);
}
