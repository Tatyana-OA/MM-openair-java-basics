package com.mentormate.openair.controller;

import com.mentormate.openair.model.Band;
import com.mentormate.openair.repository.BandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bands")
public class BandController {

  private final BandsService bandsService;

  @Autowired
    public BandController(BandsService bandsService) {
        this.bandsService = bandsService;
    }

    @GetMapping
    public List<Band> getBands() {
        return bandsService.findAll();
    }
}
