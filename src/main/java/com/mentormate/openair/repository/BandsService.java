package com.mentormate.openair.repository;

import com.mentormate.openair.controller.NotFoundException;
import com.mentormate.openair.controller.NotSavedException;
import com.mentormate.openair.model.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BandsService {

    private final BandsRepository bandsRepository;

    @Autowired
    public BandsService(BandsRepository bandsRepository) {
        this.bandsRepository = bandsRepository;
    }


    public List<Band> findAll() {
        List<Band> bands = bandsRepository.findAll();
        if (bands.isEmpty()) {
            throw new NotFoundException();
        }
        return bands;
    }

    public Band findBandById(int id) {
        Optional<Band> bandOptional = bandsRepository.findById(id);
        if (bandOptional.isEmpty()) {
            throw new NotFoundException(id);
        }
        return bandOptional.get();
    }

    public void addBand(Band band) {
        band.setDay(Band.convertFestivalDate(band.getDay()));
        try {
            bandsRepository.save(band);
        }catch(DataIntegrityViolationException ex) {
            throw new NotSavedException();
        }

    }

    public void updateBand(int id, Band band) {
        findBandById(id);
        band.setId(id);
        bandsRepository.save(band);
    }

    public void deleteBandById(int id) {
        findBandById(id);
        bandsRepository.deleteById(id);
    }
}
