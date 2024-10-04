package com.practice.CitizenService.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Citizen {
    @Id
    private Integer id;
    private String name;
    private int vaccinationCenterId;
}
