package com.seveninterval.service;

import com.seveninterval.dto.KisiDto;
import com.seveninterval.entity.Adres;
import com.seveninterval.entity.Kisi;
import com.seveninterval.repo.AdresRepository;
import com.seveninterval.repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {

    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;

    @Override
    @Transactional
    public KisiDto save(KisiDto kisiDto) {
        Assert.isNull(kisiDto.getAdi(), "Adi alanı zorunludur!");
        Kisi kisi = new Kisi();
        kisi.setAdi(kisiDto.getAdi());
        kisi.setSoyadi(kisiDto.getSoyadi());
        final Kisi kisiDb = kisiRepository.save(kisi);
        List<Adres> liste = new ArrayList<>();
        kisiDto.getAdresleri().forEach(item -> {
            Adres adres = new Adres();
            adres.setAdres(item);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisiDb);
            liste.add(adres);
        });
        adresRepository.saveAll(liste);
        kisiDto.setId(kisiDb.getId());
        return kisiDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiList = kisiRepository.findAll();
        List<KisiDto> kisiDtoList = new ArrayList<>();
        kisiList.forEach(item -> {
            KisiDto kisiDto = new KisiDto();
            kisiDto.setId(item.getId());
            kisiDto.setAdi(item.getAdi());
            kisiDto.setSoyadi(item.getSoyadi());
            kisiDto.setAdresleri(item.getAdresleri().stream().map(Adres::getAdres).collect(Collectors.toList()));
            kisiDtoList.add(kisiDto);
        });
        return kisiDtoList;
    }

    @Override
    public Page<KisiDto> getAll(Pageable pageable) {
        return null;
    }
}
