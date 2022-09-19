package com.persist.postventa.adapter;

import com.persist.postventa.annotations.RDBMSPostgresAdapter;
import com.persist.postventa.entity.generic.ClientEntity;
import com.persist.postventa.generic.ClientDomain;
import com.persist.postventa.mapper.ClientPostgresMapper;
import com.persist.postventa.ports.out.client.FindClientByIdPort;
import com.persist.postventa.ports.out.client.ListClientPort;
import com.persist.postventa.springdata.ClientPostgresRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RDBMSPostgresAdapter(value = "clientPostgresAdapter")
public class ClientPostgresAdapter implements ListClientPort, FindClientByIdPort {
    private final ClientPostgresRepository clientPostgresRepository;
    private final ClientPostgresMapper clientPostgresMapper;

    @Override
    public List<ClientDomain> findAll() {
        List<ClientEntity> clients = this.clientPostgresRepository.findAll();
        return this.clientPostgresMapper.toDomains(clients);
    }

    @Override
    public ClientDomain findById(Long id) {
        Optional<ClientEntity> optClient = this.clientPostgresRepository.findById(id);

        if(optClient.isPresent()){
            return this.clientPostgresMapper.toDomain(optClient.get());
        }

        return null;
    }
}
