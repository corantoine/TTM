package fr.initiativedeuxsevres.ttm.converter.in;

import fr.initiativedeuxsevres.ttm.message.in.ParrainDtoIn;
import fr.initiativedeuxsevres.ttm.model.ParrainEntity;

public class ParrainDtoToParrainEntityMapper {

    /**
     * Convertit un DTO parrain en une entité Parrain
     * Méthode prenant un objet ParrainDto en entrée et le transforme en objet ParrainEntity
     * qui contient les mêmes informations.
     * Cela permet de transférer les données des parrains entre les différentes couches de l'application.
     *
     * @param parrainDtoIn le DTO parrain à convertir
     * @return un objet ParrainEntity contenant les informations du parrain.
     */
    public static ParrainEntity convertParrainDtoToParrainEntity(ParrainDtoIn parrainDtoIn) {
        return ParrainEntity.builder()
                .entrepriseRepresentee(parrainDtoIn.getEntrepriseRepresentee())
                .presentationParcours(parrainDtoIn.getPresentationParcours())
                .typeDeReseau(parrainDtoIn.getTypeDeReseau())
                .domaineExpertise(parrainDtoIn.getDomaineExpertise())
                .lieuxDeplacement(parrainDtoIn.getLieuxDeplacement())
                .build();
    }
}
