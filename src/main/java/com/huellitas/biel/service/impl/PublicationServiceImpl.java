package com.huellitas.biel.service.impl;

import com.huellitas.biel.model.Publication;
import com.huellitas.biel.model.enums.PublicationStatus;
import com.huellitas.biel.repository.PublicationRepository;
import com.huellitas.biel.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class PublicationServiceImpl implements PublicationService {

    private final PublicationRepository publicationRepository;

    @Override
    public Publication save(Publication publication) {
        publication.setStatus(PublicationStatus.ACTIVE);
        publication.setCreatedAt(LocalDateTime.now());
        return publicationRepository.save(publication);
    }

    @Override
    public List<Publication> findActivePublications() {
        return publicationRepository.findBystatus(PublicationStatus.ACTIVE);
    }
    
}
