package com.mentormate.openair.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @NotNull(message = "Day is required")
    @Pattern(regexp = "^(2024-07-19|2024-07-20|2024-07-21)$", message = "Bands must play on one of the festival days (19/07, 20/07, 21/07)")
    private String day;

    public static String convertFestivalDate(String inputDate) {
        String day = inputDate.substring(0, 2);
        return "2024-07-" + day;
    }
}
