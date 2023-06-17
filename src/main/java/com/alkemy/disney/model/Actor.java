package com.alkemy.disney.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "actor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String name;
    private Integer age;
    private Float weight;
    private String history;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;

}