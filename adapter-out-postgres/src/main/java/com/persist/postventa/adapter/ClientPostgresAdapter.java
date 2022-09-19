package com.persist.postventa.adapter;

import com.persist.postventa.annotations.RDBMSPostgresAdapter;
import com.persist.postventa.entity.generic.ClientEntity;
import com.persist.postventa.generic.ClientDomain;
import com.persist.postventa.mapper.ClientPostgresMapper;
import com.persist.postventa.ports.out.client.ListClientPort;
import com.persist.postventa.springdata.ClientPostgresRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RDBMSPostgresAdapter(value = "clientPostgresAdapter")
public class ClientPostgresAdapter implements ListClientPort {
    private final ClientPostgresRepository clientPostgresRepository;
    private final ClientPostgresMapper clientPostgresMapper;

    @Override
    public List<ClientDomain> findAll() {
        List<ClientEntity> clients = this.clientPostgresRepository.findAll();
        return this.clientPostgresMapper.toDomains(clients);
    }
}
