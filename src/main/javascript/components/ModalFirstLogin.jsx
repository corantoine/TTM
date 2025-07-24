import React, { useState, useEffect } from 'react'
// import './modal.css'
import { AuthContext } from '../config/AuthContext'

const ModalFirstLogin = ({
  role,
  onClose,
  onSubmit,
  domaines,
  typesReseau,
}) => {
  const [formData, setFormData] = useState({
    disponibilites: '',
    entreprise: '',
    parcours: '',
    typeReseau: '',
    domaineExpertise: '',
    lieuxDeplacement: '',
    nomEntreprise: '',
    dateLancement: '',
    description: '',
    besoins: '',
    lieuActivite: '',
    domaineActivite: '',
  })

  const handleChange = (e) => {
    const { name, value } = e.target
    setFormData((prev) => ({ ...prev, [name]: value }))
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    onSubmit(formData)
    onClose()
  }

  return (
    <div className="modal-overlay">
      <div className="modal-content">
        <h2>Complétez votre profil</h2>
        <form onSubmit={handleSubmit}>
          <label>Disponibilités :</label>
          <select name="disponibilites" onChange={handleChange} required>
            <option value="">-- Choisir --</option>
            <option value="Lundi">Lundi</option>
            <option value="Mardi">Mardi</option>
            <option value="Mercredi">Mercredi</option>
            <option value="Jeudi">Jeudi</option>
            <option value="Vendredi">Vendredi</option>
          </select>

          {role === 'PARRAIN' && (
            <>
              <label>Entreprise représentée :</label>
              <input type="text" name="entreprise" label>
                Domaine d'expertise :
              </input>
              <input
                type="text"
                name="domaineExpertise"
                onChange={handleChange}
              />

              <label>Lieux de déplacement :</label>
              <input
                type="text"
                name="lieuxDeplacement"
                onChange={handleChange}
              />
            </>
          )}

          {role === 'PORTEUR' && (
            <>
              <label>Nom de l'entreprise :</label>
              <input type="text" name="nomEntreprise" onChange={handleChange} />

              <label>Date de lancement :</label>
              <input type="date" name="dateLancement" onChange={handleChange} />

              <label>Description :</label>
              <input type="text" name="description" onChange={handleChange} />

              <label>Besoins potentiels :</label>
              <input type="text" name="besoins" onChange={handleChange} />

              <label>Lieu de l'activité :</label>
              <input type="text" name="lieuActivite" onChange={handleChange} />

              <label>Domaine d'activité :</label>
              <select name="domaineActivite" onChange={handleChange}>
                <option value="">-- Choisir --</option>
                {domaines.map((domaine) => (
                  <option key={domaine.id} value={domaine.nom}>
                    {domaine.nom}
                  </option>
                ))}
              </select>
            </>
          )}

          <div className="modal-buttons">
            <button type="submit">Valider</button>
            <button type="button" onClick={onClose}>
              Plus tard
            </button>
          </div>
        </form>
      </div>
      {showModal && (
        <ModalFirstLogin
          role={role}
          onClose={() => setShowModal(false)}
          onSubmit={() => setShowModal(false)} // temporaire, juste pour fermer
          domaines={domaines}
          typesReseau={typesReseau}
        />
      )}
    </div>
  )
}

export default ModalFirstLogin
