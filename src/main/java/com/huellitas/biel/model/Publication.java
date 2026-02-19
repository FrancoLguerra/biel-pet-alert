package com.huellitas.biel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.time.LocalDate;
import jakarta.persistence.*;





@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)

    private PublicationType type;
    private String petName;
    private String species;
    private String breed;
    private String color;
     @Column(length = 1000)
    private String description;

    private LocalDate date;

    private String neighborhood;
    private String location;

    private String imagenUrl;

    @Enumerated(EnumType.STRING)
    private PublicationStatus status;

    @ManyToOne
    private User user;
    
}
