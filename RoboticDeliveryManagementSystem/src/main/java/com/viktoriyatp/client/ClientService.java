package com.viktoriyatp.client;

import java.util.List;

public interface ClientService {
  List<ClientDto> getAllClients();

  ClientDto addClient(ClientRequestDto clientRequestDto);
}
