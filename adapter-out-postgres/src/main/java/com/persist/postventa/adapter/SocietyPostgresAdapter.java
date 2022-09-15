package com.persist.postventa.adapter;

import com.persist.postventa.annotations.RDBMSPostgresAdapter;
import com.persist.postventa.generic.SocietyDomain;
import com.persist.postventa.mapper.SocietyPostgresMapper;
import com.persist.postventa.ports.out.ListSocietyPort;
import com.persist.postventa.springdata.SocietyPostgresRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RDBMSPostgresAdapter(value = "societyPostgresAdapter")
public class SocietyPostgresAdapter implements ListSocietyPort {
    private final SocietyPostgresRepository societyPostgresRepository;
    private final SocietyPostgresMapper societyPostgresMapper;

    @Override
    public List<SocietyDomain> findAll() {
        log.info("{} findAll", SocietyPostgresAdapter.class.getSimpleName());
        this.societyPostgresRepository.getAll().stream().forEach(System.out::println);
        var societyDomains
                = this.societyPostgresMapper.toDomains(this.societyPostgresRepository.getAll());
        return societyDomains;
    }
}
