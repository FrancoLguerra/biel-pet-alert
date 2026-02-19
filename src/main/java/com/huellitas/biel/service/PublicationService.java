package com.huellitas.biel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.huellitas.biel.model.Publication;
import com.huellitas.biel.model.enums.PublicationStatus;


public interface PublicationService {
    Publication save(Publication publication);
    List<Publication> findActivePublications();
    
}
