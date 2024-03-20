package com.mentormate.openair.controller;

import com.mentormate.openair.model.Band;
import com.mentormate.openair.repository.ApiResponse;
import com.mentormate.openair.repository.BandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Band>> getBandById(@PathVariable int id) {
        try {
            Band band = bandsService.findBandById(id);
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Band found", band));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> addBand(@RequestBody Band band) {
      try {
          bandsService.addBand(band);
          return ResponseEntity.ok(new ApiResponse<>(HttpStatus.CREATED.value(), "Band added", null));
      } catch(Exception ex) {
          return ResponseEntity.ok(new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null));
      }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteBand(@RequestParam int id) {
        try {
            bandsService.deleteBandById(id);
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Band deleted", null));
        } catch (Exception ex) {
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null));
        }
    }

}
