package com.alkemy.disney.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

        @Id
        private Long identification;

        @Column(nullable = false)
        private String password;
        @Column(nullable = false, unique = true)
        private String email;

        @ManyToOne
        @JoinColumn(name = "role_id")
        private Rol rol;

}


