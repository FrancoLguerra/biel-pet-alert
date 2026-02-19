package com.huellitas.biel.controller;

import com.huellitas.biel.model.Publication;
import com.huellitas.biel.model.enums.PublicationType;
import com.huellitas.biel.model.enums.PublicationStatus;
import com.huellitas.biel.service.PublicationService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    // Mostrar formulario
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("publication", new Publication());
        model.addAttribute("types", PublicationType.values());
        model.addAttribute("statuses", PublicationStatus.values());
        return "publications/create";
    }
    @GetMapping("/publications/create")
public String createForm(Model model) {
    model.addAttribute("publication", new Publication());
    return "publications/create";
}

    // Guardar publicación
    @PostMapping("/save")
    public String savePublication(
            @Valid @ModelAttribute Publication publication,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("types", PublicationType.values());
            model.addAttribute("statuses", PublicationStatus.values());
            return "publications/create";
        }

        publication.setCreatedAt(LocalDateTime.now());
        publicationService.save(publication);

        return "redirect:/publications";
    }
    @GetMapping("/publications")
public String listPublications(Model model) {
    model.addAttribute("publications", publicationService.findAll());
    return "publications/list";
}
}