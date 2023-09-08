package com.viktoriyatp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
public class ClientController {
  public final ClientServiceImpl clientService;

  @Autowired
  public ClientController(ClientServiceImpl clientService) {
    this.clientService = clientService;
  }

  @GetMapping("/clients")
  public ResponseEntity<List<ClientDto>> getAllClients() {
    return ResponseEntity.ok(clientService.getAllClients());
  }

  @PostMapping("/clients")
  public ResponseEntity<ClientDto> addClient(@RequestBody ClientRequestDto clientRequestDto) {
    ClientDto clientDto = clientService.addClient(clientRequestDto);

    URI location = UriComponentsBuilder.fromUriString("/clients/{id}").buildAndExpand(clientDto.getId()).toUri();

    return ResponseEntity.created(location).build();
  }
}
