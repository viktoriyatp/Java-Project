package com.viktoriyatp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

  public final ClientRepository clientRepository;
  public final ClientMapper clientMapper;

  @Autowired
  public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
    this.clientRepository = clientRepository;
    this.clientMapper = clientMapper;
  }

  @Override
  public List<ClientDto> getAllClients(){
    List<Client> clients = clientRepository.findAll();

    return clients.stream().map(clientMapper::toClientDto).collect(Collectors.toList());
  }

  @Override
  public ClientDto addClient(ClientRequestDto clientRequestDto) {
    Client client = clientMapper.toClient(clientRequestDto);
    clientRepository.save(client);

    return clientMapper.toClientDto(client);
  }
}
