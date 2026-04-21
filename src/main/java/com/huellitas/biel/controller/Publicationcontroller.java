package com.huellitas.biel.controller;

import com.huellitas.biel.model.Publication;
import com.huellitas.biel.model.enums.PublicationType;
import com.huellitas.biel.model.enums.PublicationStatus;
import com.huellitas.biel.service.PublicationService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
         System.out.println("CREATEEEE");
        return "publications/create";
    }


    // Guardar publicación
    @PostMapping
    public String savePublication(
            @Valid @ModelAttribute Publication publication,
            @RequestParam("imageFile") MultipartFile file,
            BindingResult result,
            Model model) throws IOException {

        if (result.hasErrors()) {
             System.out.println("HAY ERRORES");
            model.addAttribute("types", PublicationType.values());
            model.addAttribute("statuses", PublicationStatus.values());
            return "publications/create";
        }

        publication.setCreatedAt(LocalDateTime.now());
        publication.setImage(file.getBytes());  
        publicationService.save(publication);

        return "redirect:/publications";
    }
    @GetMapping
public String listPublications(Model model) {
    model.addAttribute("publications", publicationService.findActivePublications());
    System.out.println("LISTAAAAA");
    return "publications/list";
}
    @GetMapping("/{id}")
    public String viewPublication(@PathVariable Long id, Model model) {
        Publication publication = publicationService.findById(id);
        if (publication == null) {
            return "redirect:/publications";
        }
        model.addAttribute("publication", publication);
        return "publications/detail";
    }
    @GetMapping("/detail/{id}")
    public String getPublicationDetail(@PathVariable Long id, Model model) {
         Publication publication = publicationService.findById(id);
        if (publication == null) {
            return "redirect:/publications";
        }
        model.addAttribute("publication", publication);


        return "publications/detail";

    }

    

    @GetMapping("/put/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Publication publication = publicationService.findById(id);
        if (publication == null) {
            return "redirect:/publications";
        }
        model.addAttribute("publication", publication);
        model.addAttribute("types", PublicationType.values());
        model.addAttribute("statuses", PublicationStatus.values());
        return "publications/edit";
    }

    @PostMapping("/put/{id}")
    public String updatePublication(
            @PathVariable Long id,
            @RequestParam("imageFile") MultipartFile file,
            @Valid @ModelAttribute Publication publication,
            BindingResult result,
            Model model) throws IOException {

        if (result.hasErrors()) {
            model.addAttribute("types", PublicationType.values());
            model.addAttribute("statuses", PublicationStatus.values());
            System.out.println("UPDATEEEEE HAY ERRORES");
            return "publications/edit";
        }

        publication.setId(id);
        publication.setImage(file.getBytes());
        publicationService.update(publication);     
        System.out.println("UPDATEEEEE");

        return "redirect:/publications";
    }

    @GetMapping("/delete/{id}")
    public String deletePublication(@PathVariable Long id) {
        publicationService.delete(id);
        return "redirect:/publications";
    }

    @GetMapping("/image/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Publication pub = publicationService.findById(id);

        return ResponseEntity
            .ok()
            .header("Content-Type", "image/jpeg") // o image/png
            .body(pub.getImage());
}

}
