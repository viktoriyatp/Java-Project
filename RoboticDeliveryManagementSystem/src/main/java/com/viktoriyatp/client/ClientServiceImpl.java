package com.viktoriyatp.client;

import com.viktoriyatp.exceptions.ClientNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import static com.viktoriyatp.constants.ClientConstants.CLIENT_NOT_FOUND;

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

  @Override
  public ClientDto getClientById(int id) {
    Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFound(String.format(CLIENT_NOT_FOUND, id)));

    return clientMapper.toClientDto(client);
  }

  @Override
  public ClientDto updateClient(int id, ClientRequestDto clientRequestDto) {
    Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFound(String.format(CLIENT_NOT_FOUND, id)));

    clientMapper.updateClient(client,clientRequestDto);
    clientRepository.save(client);

    return clientMapper.toClientDto(client);
  }

  @Override
  public void removeClient(int id) {
    boolean doesExist = clientRepository.existsById(id);

    if(!doesExist) {
      throw new ClientNotFound(String.format(CLIENT_NOT_FOUND,id));
    }
    
    clientRepository.deleteById(id);
  }
}
