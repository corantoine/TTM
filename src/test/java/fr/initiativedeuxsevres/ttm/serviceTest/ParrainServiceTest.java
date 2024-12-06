package fr.initiativedeuxsevres.ttm.serviceTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.mockito.Mockito.*;
import fr.initiativedeuxsevres.ttm.model.ParrainEntity;
import fr.initiativedeuxsevres.ttm.model.Role;
import fr.initiativedeuxsevres.ttm.repository.ParrainRepository;
import fr.initiativedeuxsevres.ttm.service.ParrainService;

@SpringBootTest
public class ParrainServiceTest {

    @Autowired
    ParrainService parrainService;

    //Simulation du comportement de PorteurRepository
    @MockBean
    private ParrainRepository parrainRepository;

    @DisplayName("Tester la méthode de création d'un parrain")
    @Test
    public void testCreateParrain(){
        ParrainEntity parrain = ParrainEntity.builder()
                .id(2L)
                .username("JackieS")
                .nom("Sparrow")
                .prenom("Jack")
                .plateformeInitiative("plateforme")
                .role(Role.PARRAIN)
                .entrepriseRepresentee("Black Pearl")
                .presentationParcours("Parcours de pirate")
                .typeDeReseau("Piraterie")
                .domaineExpertise("Pillage")
                .lieuxDeplacement("Caraïbes")
                .disponibilites("Tout le temps")
                .build();

        when(parrainRepository.save(parrain)).thenReturn(parrain);

        ParrainEntity newParrain = parrainService.createParrain(parrain);

        Assertions.assertNotNull(newParrain);
        Assertions.assertEquals(parrain, newParrain);
        verify(parrainRepository, times(1)).save(parrain);
        Assertions.assertEquals(parrain.getNom(), "Sparrow");
        System.out.println(parrain);
        System.out.println(parrain.getNom());

    }
}
