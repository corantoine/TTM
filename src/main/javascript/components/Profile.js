/**
 * Composant Profile
 * -----------------
 * Affiche les informations du profil utilisateur si l'utilisateur est authentifié.
 * Permet de supprimer le profil avec une confirmation via une modale sécurisée.
 * 
 * Accessibilité :
 * - Utilise un <main> et <section> pour la structure sémantique.
 * - La modale utilise role="dialog", aria-labelledby et aria-describedby.
 * - Le champ de confirmation a un label masqué mais lisible par les lecteurs d’écran.
 * 
 * Sécurité :
 * - L'utilisateur doit taper "SUPPRIMER" pour confirmer la suppression.
 * - Cela évite les suppressions accidentelles.
 */

import React, { useContext, useState } from 'react'
import { AuthContext } from '../config/AuthContext'
import { useNavigate } from 'react-router-dom'
import Login from './Login'
import profilePhoto from '../../../../public/profilPic.jpg'

import '../styles/profile.scss'

const Profile = () => {
  const { payload } = useContext(AuthContext)
  const navigate = useNavigate()

  // État pour afficher ou non la modale de suppression
  const [isDeleteModalOpen, setIsDeleteModalOpen] = useState(false)

  // Texte saisi dans le champ de confirmation
  const [confirmationText, setConfirmationText] = useState('')

  // Fonction appelée lors de la suppression confirmée
  const handleClick = () => {
    alert('profil supprimé')
    setIsDeleteModalOpen(false)
    navigate('/') // Redirection vers la page d'accueil
  }

  return (
    <main id="content">
      {payload ? (
        <section id="profile-info">
          {/* Colonne gauche : photo, disponibilités, bouton suppression */}
          <div className="left-column">
            <img
              className="profile-pic"
              alt="Photo de profil de l'utilisateur"
              src="http://3000/profilPic.jpg"
            />
            <div className="availabilities">
              <h3>Disponibilités :</h3>
              <p>lundi, mardi, mercredi, jeudi</p>
            </div>
            <div className="needs">
              <p>Types de réseaux / besoins</p>
            </div>
            <div className="profile-btn">
              <button onClick={() => setIsDeleteModalOpen(true)}>
                Supprimer mon profil
              </button>
            </div>
          </div>

          {/* Colonne droite : infos utilisateur et description */}
          <div className="right-column">
            <div className="user-info">
              <div className="name">
                <p>Prénom</p>
                <p>Nom</p>
              </div>
              <p>Métier</p>
            </div>
            <div className="profile-description">
              <h2>DESCRIPTION DU PROJET ET DES BESOINS</h2>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
                eiusmod tempor incididunt ut labore et dolore magna aliqua...
              </p>
            </div>
          </div>

          {/* Modale de confirmation de suppression */}
          {isDeleteModalOpen && (
            <div className="modal-overlay">
              <div
                className="modal"
                role="dialog"
                aria-modal="true"
                aria-labelledby="modal-title"
                aria-describedby="modal-desc"
              >
                <h3 id="modal-title">Confirmer la suppression de votre profil</h3>
                <p id="modal-desc">
                  Veuillez taper <strong>SUPPRIMER</strong> pour confirmer.
                </p>
                <label htmlFor="confirm-delete" className="visually-hidden">
                  Champ de confirmation
                </label>
                <input
                  id="confirm-delete"
                  type="text"
                  placeholder="Tapez SUPPRIMER"
                  value={confirmationText}
                  onChange={(e) => setConfirmationText(e.target.value)}
                  autoFocus
                  aria-describedby="modal-desc"
                />
                <div className="modal-buttons">
                  <button className="cancel" onClick={() => setIsDeleteModalOpen(false)}>
                    Annuler
                  </button>
                  <button
                    className="confirm"
                    onClick={() => {
                      if (confirmationText === 'SUPPRIMER') {
                        handleClick()
                      } else {
                        alert('Veuillez taper SUPPRIMER pour confirmer.')
                      }
                    }}
                  >
                    Supprimer
                  </button>
                </div>
              </div>
            </div>
          )}
        </section>
      ) : (
        <Login />
      )}
    </main>
  )
}

export default Profile
