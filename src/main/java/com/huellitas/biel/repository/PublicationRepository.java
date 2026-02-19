package com.huellitas.biel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.huellitas.biel.model.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
    
}
