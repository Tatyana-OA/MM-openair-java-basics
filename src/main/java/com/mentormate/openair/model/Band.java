package com.mentormate.openair.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bands")
public class Band {
    @Id
    @Column
    private Integer id;
    @NotBlank(message = "Bands must have a name")
    @Size(max = 100, message = "Band name cannot exceed 100 characters.")
    @Column
    private String name;
    @NotBlank(message = "Bands must have a genre")
    @Size(max = 100, message = "Genre cannot exceed 100 characters.")
    @Column
    private String genre;
    @Size(max = 200, message = "Additional info cannot exceed 200 characters.")
    @Column(name = "additionalinfo")
    private String additionalInfo;
    @NotNull(message = "Bands must request a time slot")
    @Column(name = "timeslotid")
    private Integer timeSlotId;
    @NotBlank(message = "Bands must play on one of the festival days")
    @Column
    private Date day;

}
