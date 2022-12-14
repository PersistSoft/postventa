package com.persist.postventa.services;

import com.persist.postventa.annotations.UseCase;
import com.persist.postventa.exceptions.ApartmentNotFoundException;
import com.persist.postventa.exceptions.ClientNotFoundException;
import com.persist.postventa.generic.ClientDomain;
import com.persist.postventa.ports.in.client.FindClientByIdUseCase;
import com.persist.postventa.ports.in.client.ListClientUseCase;
import com.persist.postventa.ports.in.client.SaveClientUseCase;
import com.persist.postventa.ports.in.client.ClientCommand;
import com.persist.postventa.ports.out.client.FindClientByIdPort;
import com.persist.postventa.ports.out.client.ListClientPort;
import com.persist.postventa.ports.out.client.SaveClientPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@RequiredArgsConstructor
@UseCase(value = "clientService")
public class ClientService implements ListClientUseCase, SaveClientUseCase, FindClientByIdUseCase {
    private final ListClientPort listClientPort;
    private final FindClientByIdPort findClientByIdPort;

    @Override
    public List<ClientDomain> findAll() {
        return listClientPort.findAll();
    }

    @Override
    public ClientDomain save(ClientCommand clientCommand) {
        ClientDomain clientDomain = ClientDomain.builder()
                .name(clientCommand.getName())
                .email(clientCommand.getEmail())
                .lastName(clientCommand.getLastName())
                .phone(clientCommand.getPhone())
                .build();
        return null; //this.saveClientPort.save(clientDomain);
    }

    @Override
    public ClientDomain findById(Long id) {
        ClientDomain client = this.findClientByIdPort.findById(id);
        if(isNull(client)){
            throw new ClientNotFoundException(String.format("The Client with id %s not found", id));
        }
        return client;
    }
}
