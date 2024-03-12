package com.mentormate.openair.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
@Entity
@Table(name = "Bands")
public class Band {
    @Id
    private Integer id;
    @NotBlank(message = "Bands must have a name")
    @Size(max = 100, message = "Band name cannot exceed 100 characters.")
    private String name;
    @NotBlank(message = "Bands must have a genre")
    @Size(max = 100, message = "Genre cannot exceed 100 characters.")
    private String genre;
    @Size(max = 200, message = "Additional info cannot exceed 200 characters.")
    private String additionalInfo;
    @NotNull(message = "Bands must request a time slot")
    private Integer timeSlotId;
    @NotBlank(message = "Bands must play on one of the festival days")
    private Date day;

}
