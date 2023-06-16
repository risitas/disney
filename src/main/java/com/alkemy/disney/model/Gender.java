package com.alkemy.disney.model;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movies;

}
