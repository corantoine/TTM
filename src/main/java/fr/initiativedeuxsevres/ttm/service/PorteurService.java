package fr.initiativedeuxsevres.ttm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.initiativedeuxsevres.ttm.model.PorteurEntity;
import fr.initiativedeuxsevres.ttm.repository.PorteurRepository;

/**
 * Service pour gérer les opérations spécifiques aux porteurs.
 */
@Service
public class PorteurService {
    @Autowired
    private static PorteurRepository porteurRepository;

    /**
     * Crée un nouveau porteur.
     *
     * @param porteur l'entité porteur à créer
     * @return le porteur créé
     */
    public static PorteurEntity createPorteur(PorteurEntity porteur) {
        return porteurRepository.save(porteur);
    }

    // Autres méthodes spécifiques aux porteurs
}