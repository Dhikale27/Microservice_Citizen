package com.practice.CitizenService.Repository;

import com.practice.CitizenService.dto.Citizen;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends MongoRepository<Citizen, Integer> {
    List<Citizen> findByVaccinationCenterId(Integer id);
}
