package com.viktoriyatp.client;

import java.util.List;

public interface ClientService {
  List<ClientDto> getAllClients();
  ClientDto addClient(ClientRequestDto clientRequestDto);
  ClientDto getClientById(int id);
  ClientDto updateClient(int id, ClientRequestDto clientRequestDto);
  void removeClient(int id);

}
