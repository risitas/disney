package com.alkemy.disney.model;

import jakarta.persistence.*;
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
        private Long id;
        private String rolname;
        @OneToMany(mappedBy = "rol")
        private List<User> users;

}
