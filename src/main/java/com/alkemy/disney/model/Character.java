package com.alkemy.disney.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "character")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String name;
    private Integer age;
    private Float weight;
    private String history;

    @ManyToMany(mappedBy = "characters")
    private List<Movies> movies;

}