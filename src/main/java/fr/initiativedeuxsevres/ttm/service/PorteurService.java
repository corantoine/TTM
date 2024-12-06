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
//    @Autowired
    private final PorteurRepository porteurRepository;

    public PorteurService(PorteurRepository porteurRepository) {
        this.porteurRepository = porteurRepository;
    }

    /**
     * Crée un nouveau porteur.
     *
     * @param porteur l'entité porteur à créer
     * @return le porteur créé
     */
    public PorteurEntity createPorteur(PorteurEntity porteur) {
        return porteurRepository.save(porteur);
    }

}