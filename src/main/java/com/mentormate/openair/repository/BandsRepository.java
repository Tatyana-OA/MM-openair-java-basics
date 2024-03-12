package com.mentormate.openair.repository;

import com.mentormate.openair.model.Band;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandsRepository extends ListCrudRepository<Band, Integer> {
}
