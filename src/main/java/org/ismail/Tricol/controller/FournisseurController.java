package org.ismail.Tricol.controller;

import org.ismail.Tricol.model.Fournisseur;
import org.ismail.Tricol.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/fournisseurs")
public class FournisseurController {

    private FournisseurService fournisseurService;

    public void setFournisseurService(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @PostMapping
    public Fournisseur save(@RequestBody Fournisseur fournisseur) {
        fournisseurService.saveFournisseur(fournisseur);
        return fournisseur;
    }

    @GetMapping
    public List<Fournisseur> findAll() {
        return fournisseurService.findAllFournisseurs();
    }

    @GetMapping("/{id}")
    public Fournisseur findById(@PathVariable("id") Long id) {
        return fournisseurService.findFournisseurById(id).orElseThrow(() -> new IllegalArgumentException("Fournisseur avec l'ID " + id + " non trouvé"));
    }

    @DeleteMapping("/{id}")
    public void deleteFournisseur(@PathVariable("id") Long id) {
        fournisseurService.deleteFournisseurById(id);
    }

    @PutMapping("/{id}")
    public Fournisseur updateFournisseur(@PathVariable("id") Long id, @RequestBody Fournisseur fournisseur) {
        return fournisseurService.updateFournisseur(id, fournisseur);
    }

}
