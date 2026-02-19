package com.huellitas.biel.model;

import lombok.*;
import java.time.LocalDateTime;

import com.huellitas.biel.model.enums.PublicationStatus;
import com.huellitas.biel.model.enums.PublicationType;

import jakarta.persistence.*;





@Entity
@Table(name = "publications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PublicationType type;

    @Enumerated(EnumType.STRING)
    private PublicationStatus status;
   
    @Column(length = 1000)
    private String description;
    
    private String petName;
    private String species;
    private String breed;
    private String color;
    private LocalDateTime createdAt;
    private String neighborhood;
    private String location;
    private String imagenUrl;
    private String contactPhone;

       @ManyToOne
    private User user;
    
}
