package com.alkemy.disney.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "gender")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gender {
    @Id
    private Long id;
    private String name;
    private String image;

    @OneToMany(mappedBy = "gender")
    private List<Movie> movies;

}
