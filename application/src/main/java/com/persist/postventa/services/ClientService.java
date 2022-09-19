package com.persist.postventa.services;

import com.persist.postventa.annotations.UseCase;
import com.persist.postventa.generic.ClientDomain;
import com.persist.postventa.ports.in.client.ListClientUseCase;
import com.persist.postventa.ports.in.client.SaveClientUseCase;
import com.persist.postventa.ports.in.client.ClientCommand;
import com.persist.postventa.ports.out.client.ListClientPort;
import com.persist.postventa.ports.out.client.SaveClientPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@UseCase(value = "clientService")
public class ClientService implements ListClientUseCase, SaveClientUseCase {
    private final ListClientPort listClientPort;
    //private final SaveClientPort saveClientPort;

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
}
