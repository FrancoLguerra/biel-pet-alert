package com.huellitas.biel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.huellitas.biel.model.Publication;
import com.huellitas.biel.model.enums.PublicationStatus;
import com.huellitas.biel.model.enums.PublicationType;

import jakarta.validation.Valid;


public interface PublicationService {
    Publication save(Publication publication);
    List<Publication> findActivePublications();
    void update(Publication publication);
    void delete(Long id);
	Publication findById(Long id);
    public List<Publication> findByType(PublicationType type);
    
}
