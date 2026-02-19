package com.huellitas.biel.model;

import lombok.*;
import java.time.LocalDateTime;

import com.huellitas.biel.model.enums.PublicationStatus;
import com.huellitas.biel.model.enums.PublicationType;
import jakarta.persistence.*;
import org.springframework.validation.BindingResult;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.Valid;





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
    @NotNull(message = "El tipo es obligatorio")
    private PublicationType type;

    @Enumerated(EnumType.STRING)
     @NotNull(message = "El estado es obligatorio")
    private PublicationStatus status;
   
    @Column(length = 1000)
    private String description;
    
     @NotBlank(message = "El nombre es obligatorio")
    private String petName;
    private String species;
    private String breed;
    private String color;
    private LocalDateTime createdAt;
    private String neighborhood;
    private String location;
    private String imagenUrl;

     @NotBlank(message = "El teléfono es obligatorio")
    private String contactPhone;

       @ManyToOne
    private User user;
    
}
