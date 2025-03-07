package fr.initiativedeuxsevres.ttm.converter.out;

import fr.initiativedeuxsevres.ttm.message.out.ParrainDtoOut;
import fr.initiativedeuxsevres.ttm.model.ParrainEntity;

//FIXME : classe qui me servira à update mon parrain ?
public class ParrainEntityToParrainDtoOutMapper {
    /**
     * Cette méthode prend une entité parrain pour la convertir en DTO Parrain contenant les mêmes informations.
     * Cela permet de transférer les données entre les différentes couches de l'application.
     *
     * @param parrain l'entité parrain à convertir
     * @return un objet ParrainDtoOut contenant les infos du parrain
     */
    public static ParrainDtoOut convertParrainEntityToParrainDtoOut(ParrainEntity parrain) {
        return ParrainDtoOut.builder()
                .id(parrain.getId())
                .entrepriseRepresentee(parrain.getEntrepriseRepresentee())
                .presentationParcours(parrain.getPresentationParcours())
                .typeDeReseau(parrain.getTypeDeReseau())
                .domaineExpertise(parrain.getDomaineExpertise())
                .lieuxDeplacement(parrain.getLieuxDeplacement())
                .build();
    }
}
