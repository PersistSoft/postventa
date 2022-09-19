package com.persist.postventa.adapter;

import com.persist.postventa.annotations.RDBMSPostgresAdapter;
import com.persist.postventa.entity.generic.SocietyEntity;
import com.persist.postventa.generic.SocietyDomain;
import com.persist.postventa.mapper.SocietyPostgresMapper;
import com.persist.postventa.ports.out.society.FindSocietyByIdPort;
import com.persist.postventa.ports.out.society.ListSocietyPort;
import com.persist.postventa.ports.out.society.SaveSocietyPort;
import com.persist.postventa.springdata.SocietyPostgresRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RDBMSPostgresAdapter(value = "societyPostgresAdapter")
public class SocietyPostgresAdapter implements ListSocietyPort, SaveSocietyPort, FindSocietyByIdPort {
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
        SocietyEntity society = this.societyPostgresMapper.toEntity(societyDomain);
        society = this.societyPostgresRepository.save(society);
        societyDomain = this.societyPostgresMapper.toDomain(society);
        return societyDomain;
    }

    @Override
    public SocietyDomain findById(Long id) {
        Optional<SocietyEntity> optSociety = this.societyPostgresRepository.findById(id);

        if(optSociety.isPresent()){
            return this.societyPostgresMapper.toDomain(optSociety.get());
        }

        return null;
    }
}
