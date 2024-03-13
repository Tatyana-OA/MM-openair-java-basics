package com.mentormate.openair.model;

import jakarta.persistence.*;
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
@Table(name = "bands")
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Bands must have a name")
    @Size(max = 100, message = "Band name cannot exceed 100 characters.")
    private String name;
    @NotBlank(message = "Bands must have a genre")
    @Size(max = 100, message = "Genre cannot exceed 100 characters.")
    private String genre;
    @Size(max = 200, message = "Additional info cannot exceed 200 characters.")
    private String additional_info;
    @NotNull(message = "Bands must request a time slot")
    private Integer timeslot_id;
    @NotNull(message = "Bands must play on one of the festival days")
    private Date day;
}
