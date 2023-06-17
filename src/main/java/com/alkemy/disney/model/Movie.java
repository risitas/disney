package com.alkemy.disney.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movie")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String title;
    private LocalDate dateCreation;
    private Integer rating;

    @ManyToMany
    private List<Actor> actors;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

}
