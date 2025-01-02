package fr.initiativedeuxsevres.ttm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.initiativedeuxsevres.ttm.model.ParrainEntity;
import fr.initiativedeuxsevres.ttm.repository.ParrainRepository;

/**
 * Service pour gérer les opérations spécifiques aux parrains.
 */
@Service
public class ParrainService {
    @Autowired
    private ParrainRepository parrainRepository;

    /**
     * Crée un nouveau parrain.
     *
     * @param parrain l'entité parrain à créer
     * @return le parrain créé
     */
    //TODO : Voir comment implémenter la méthode
    public ParrainEntity updateParrain(ParrainEntity parrain) {
        return parrainRepository.save(parrain);
    }

    // Autres méthodes spécifiques aux parrains
}