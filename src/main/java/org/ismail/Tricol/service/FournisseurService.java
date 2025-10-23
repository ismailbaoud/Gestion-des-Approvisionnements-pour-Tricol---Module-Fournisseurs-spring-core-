package org.ismail.Tricol.service;

import org.ismail.Tricol.model.Fournisseur;
import org.ismail.Tricol.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FournisseurService {

    private FournisseurRepository fournisseurRepository;

    public void setFournisseurRepository(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }


    public void saveFournisseur(Fournisseur fournisseur) {
        fournisseurRepository.save(fournisseur);
    }

    public List<Fournisseur> findAllFournisseurs() {
        return fournisseurRepository.findAll();
    }


    public void deleteFournisseurById(Long id) {
        fournisseurRepository.deleteById(id);
    }

    public Fournisseur updateFournisseur(Long id , Fournisseur fournisseur) {
        Fournisseur existingFournisseur = fournisseurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fournisseur avec l'ID " + id + " non trouvé"));
        existingFournisseur.setId(id);
        existingFournisseur.setIce(fournisseur.getIce());
        existingFournisseur.setNom(fournisseur.getNom());
        existingFournisseur.setPrenom(fournisseur.getPrenom());
        existingFournisseur.setEmail(fournisseur.getEmail());
        existingFournisseur.setSociete(fournisseur.getSociete());
        existingFournisseur.setAdresse(fournisseur.getAdresse());
        existingFournisseur.setContact(fournisseur.getContact());
        existingFournisseur.setTelephone(fournisseur.getTelephone());
        existingFournisseur.setVille(fournisseur.getVille());

        return fournisseurRepository.save(existingFournisseur );
    }

    public Optional<Fournisseur> findFournisseurById(Long id) {
        return fournisseurRepository.findById(id);
    }
}