package com.huellitas.biel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.huellitas.biel.model.Publication;
import com.huellitas.biel.model.enums.PublicationStatus;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

    List<Publication> findBystatus(PublicationStatus status);
    
}
