package com.persist.postventa.adapter;

import com.persist.postventa.annotations.RDBMSPostgresAdapter;
import com.persist.postventa.entity.generic.SocietyEntity;
import com.persist.postventa.generic.SocietyDomain;
import com.persist.postventa.mapper.SocietyPostgresMapper;
import com.persist.postventa.ports.out.ListSocietyPort;
import com.persist.postventa.ports.out.SaveSocietyPort;
import com.persist.postventa.springdata.SocietyPostgresRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RDBMSPostgresAdapter(value = "societyPostgresAdapter")
public class SocietyPostgresAdapter implements ListSocietyPort, SaveSocietyPort {
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

    @Override
    public SocietyDomain save(SocietyDomain societyDomain) {
        log.info("SocietyDomain to save:  {}", societyDomain);
        SocietyEntity society = this.societyPostgresMapper.toEntity(societyDomain);
        log.info("SocietyEntity to save:  {}", society);

        society = this.societyPostgresRepository.save(society);
        log.info("After safe SocietyEntity to save:  {}", society);
        societyDomain = this.societyPostgresMapper.toDomain(society);
        return societyDomain;
    }
}
