//package fr.initiativedeuxsevres.ttm.serviceTest;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//
//import fr.initiativedeuxsevres.ttm.model.PorteurEntity;
//import fr.initiativedeuxsevres.ttm.model.Role;
//import fr.initiativedeuxsevres.ttm.repository.PorteurRepository;
//import fr.initiativedeuxsevres.ttm.service.PorteurService;
//
//@SpringBootTest
//public class PorteurServiceTest {
//
//    @Autowired
//    PorteurService porteurService;
//
//    //Simulation du comportement de PorteurRepository
//    @MockBean
//    private PorteurRepository porteurRepository;
//
//
//    //TODO: séparer createUser et CreatePorteur
//    @DisplayName("Tester la méthode de creation d'un porteur")
//    @Test
//    public void testCreatePorteur() {
//        PorteurEntity porteur = PorteurEntity.builder()
//                .id(1L)
//                .nom("a")
//                .prenom("a")
//                .username("a")
//                .role(Role.PORTEUR)
//                .entreprise("Entreprise")
//                .plateformeInitiative("Plateforme")
//                .dateLancement("2024-12-06")
//                .domaineActivite("Domaine")
//                .description("Description")
//                .besoinsPotentiels("Besoins")
//                .lieuActivite("Lieu")
//                .disponibilites("Disponibilités")
//                .build();
//        when(porteurRepository.save(porteur)).thenReturn(porteur);
//
//        PorteurEntity result = porteurService.createPorteur(porteur);
//
//        Assertions.assertNotNull(result);
//        Assertions.assertEquals(porteur, result);
//        verify(porteurRepository, times(1)).save(porteur);
//        //Ici on vérifie qu'on récupère bien le nom, puisque le champ est dans la classe parent
//        Assertions.assertEquals(porteur.getNom(), "a");
//        System.out.println(porteur);
//        System.out.println(porteur.getNom());
//    }
//}