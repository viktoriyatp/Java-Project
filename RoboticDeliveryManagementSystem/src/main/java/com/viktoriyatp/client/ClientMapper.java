package com.viktoriyatp.client;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {

  ClientDto toClientDto (Client client);
  Client toClient(ClientRequestDto clientRequestDto);
  void updateClient(@MappingTarget Client client, ClientRequestDto clientRequestDto);
}
