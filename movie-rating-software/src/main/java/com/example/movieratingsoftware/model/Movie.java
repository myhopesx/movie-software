package com.example.movieratingsoftware.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Movie {

    @Id
    @NotEmpty
    @Column(nullable = false , unique = true)
    @Size(min = 3)
    private String Id;

    @Column(nullable = false ,unique = true)
    @Size(min = 2)
    private String name;

    @Column(nullable = false)
    @Pattern(regexp = "(Drama|Action|Comedy)" , message = " genre Can only have these values : (Drama, Action , Comedy)")
    private String genre;

    @NotNull
    @PositiveOrZero(message = "rating Has to be a number")
    @Min(value = 1)
    @Max(value = 5)
    private Double rating;

    @NotNull
    @Column(nullable = false)
    @PositiveOrZero
    @Min(value = 60)
    private Double duration;

    @NotEmpty
    @Column(nullable = false)
    @Pattern(regexp = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$",message = "must be date in mm/dd/yyyy")
    private String launchDate;

}
