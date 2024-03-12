package com.mentormate.openair.repository;

import com.mentormate.openair.model.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BandsService {

    private final BandsRepository bandsRepository;

    @Autowired
    public BandsService(BandsRepository bandsRepository) {
        this.bandsRepository = bandsRepository;
    }


    public List<Band> findAll() {
        return bandsRepository.findAll();
    }
}
