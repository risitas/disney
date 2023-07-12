package com.alkemy.disney.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Label;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name= "rol")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false, unique = true)
        private String rolName;
        @OneToMany(mappedBy = "rol")
        @JsonIgnore
        private List<User> users;
}
