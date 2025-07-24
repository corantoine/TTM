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

// import React, { useContext, useEffect, useState } from 'react'
// import { AuthContext } from '../config/AuthContext'
// import { useNavigate } from 'react-router-dom'
// import Login from './Login'
// import '../styles/profile.scss'
// import { getUserProfile } from '../service/profileService'

// const Profile = () => {
//   const { payload } = useContext(AuthContext)
//   console.log(payload);

//   const navigate = useNavigate()

//   // État pour afficher ou non la modale de suppression
//   const [isDeleteModalOpen, setIsDeleteModalOpen] = useState(false)

//   // Texte saisi dans le champ de confirmation
//   const [confirmationText, setConfirmationText] = useState('')
//   const [profil, setProfil] = useState(null)

//   // Fonction appelée lors de la suppression confirmée
//   const handleClick = () => {
//     alert('profil supprimé')
//     setIsDeleteModalOpen(false)
//     navigate('/') // Redirection vers la page d'accueil
//   }

//   // ...

//   useEffect(() => {
//     try {
//       const token = sessionStorage.getItem('accessToken')
//       console.log('TOKEN ---> : ', token)

//       if (!token) return

//       getUserProfile(token)
//         .then((data) => {
//           console.log('PROFIL RECU --> ', data)
//           setProfil(data)
//         })
//         .catch((err) => console.error('Erreur dans getUserProfile :', err))
//     } catch (err) {
//       console.error('Erreur dans useEffect :', err)
//     }
//   }, [])

//   useEffect(() => {
//     if (profil) {
//       console.log('PROFIL mis à jour :', profil)
//     }
//   }, [profil])

//   console.log('PROFILLLLLLLLLLL   :   ', profil)

//   return (
//     <main id="content">
//       {payload ? (
//         <section id="profile-info">
//           {/* Colonne gauche : photo, disponibilités, bouton suppression */}
//           <div className="left-column">
//             <img
//               className="profile-pic"
//               alt="Photo de profil de l'utilisateur"
//               src="http://3000/profilPic.jpg"
//             />
//             <div className="availabilities">
//               <h3>Disponibilités :</h3>
//               <p>lundi, mardi, mercredi, jeudi</p>
//             </div>
//             <div className="needs">
//               <p>Types de réseaux / besoins</p>
//             </div>
//             <div className="profile-btn">
//               <button onClick={() => setIsDeleteModalOpen(true)}>
//                 Supprimer mon profil
//               </button>
//             </div>
//           </div>

//           {/* Colonne droite : infos utilisateur et description */}
//           <div className="right-column">
//             <div className="user-info">
//               <div className="name">
//                 <p>{profil?.prenom || 'Prénom'}</p>
//                 <p>{profil?.nom || 'fonctionne pas'}</p>
//               </div>
//               <p>Métier</p>
//             </div>
//             <div className="profile-description">
//               <h2>DESCRIPTION DU PROJET ET DES BESOINS</h2>
//               <p>
//                 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
//                 eiusmod tempor incididunt ut labore et dolore magna aliqua...
//               </p>
//             </div>
//           </div>

//           {/* Modale de confirmation de suppression */}
//           {isDeleteModalOpen && (
//             <div className="modal-overlay">
//               <div
//                 className="modal"
//                 role="dialog"
//                 aria-modal="true"
//                 aria-labelledby="modal-title"
//                 aria-describedby="modal-desc"
//               >
//                 <h3 id="modal-title">
//                   Confirmer la suppression de votre profil
//                 </h3>
//                 <p id="modal-desc">
//                   Veuillez taper <strong>SUPPRIMER</strong> pour confirmer.
//                 </p>
//                 <label htmlFor="confirm-delete" className="visually-hidden">
//                   Champ de confirmation
//                 </label>
//                 <input
//                   id="confirm-delete"
//                   type="text"
//                   placeholder="Tapez SUPPRIMER"
//                   value={confirmationText}
//                   onChange={(e) => setConfirmationText(e.target.value)}
//                   autoFocus
//                   aria-describedby="modal-desc"
//                 />
//                 <div className="modal-buttons">
//                   <button
//                     className="cancel"
//                     onClick={() => setIsDeleteModalOpen(false)}
//                   >
//                     Annuler
//                   </button>
//                   <button
//                     className="confirm"
//                     onClick={() => {
//                       if (confirmationText === 'SUPPRIMER') {
//                         handleClick()
//                       } else {
//                         alert('Veuillez taper SUPPRIMER pour confirmer.')
//                       }
//                     }}
//                   >
//                     Supprimer
//                   </button>
//                 </div>
//               </div>
//             </div>
//           )}
//         </section>
//       ) : (
//         <Login />
//       )}
//     </main>
//   )
// }

// export default Profile
// import React, { useEffect, useState } from 'react';
// import { getUserProfile } from '../service/userService';

// const UserProfile = () => {
//   const [profile, setProfile] = useState(null);

//   useEffect(() => {
//     const token = sessionStorage.getItem('accessToken'); // ou sessionStorage selon ton choix
//     console.log('TOKEN ---> : ', token);

//     if (token) {
//       getUserProfile(token)
//         .then(data => setProfile(data))
//         .catch(error => console.error('Erreur chargement profil :', error));
//     }
//   }, []);

//   if (!profile) return <p>Chargement du profil...</p>;

//   return (
//     <div>
//       <h2>Mon Profil</h2>
//       <p><strong>Nom :</strong> {profile.nom}</p>
//       <p><strong>Prénom :</strong> {profile.prenom}</p>
//       <p><strong>Username :</strong> {profile.username}</p>
//       <p><strong>Rôle :</strong> {profile.role}</p>
//       <p><strong>Plateforme :</strong> {profile.plateformeInitiative}</p>
//     </div>
//   );
// };

// export default UserProfile;
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { getUserProfile } from '../service/userService'
import '../styles/profile.scss'

const Profile = () => {
  const navigate = useNavigate()

  const [isDeleteModalOpen, setIsDeleteModalOpen] = useState(false)
  const [confirmationText, setConfirmationText] = useState('')
  const [profile, setProfile] = useState({
    prenom: '',
    nom: '',
    email: '',
    disponibilites: [], // tableau pour multi-sélection
    // autres champs...
  })

  const [isEditing, setIsEditing] = useState(false)
  const [showFirstLoginModal, setShowFirstLoginModal] = useState(false)

  useEffect(() => {
    const token = sessionStorage.getItem('accessToken')

    if (token) {
      getUserProfile(token)
        .then((data) => {
          const disponibilites = Array.isArray(data.disponibilites)
            ? data.disponibilites
            : data.disponibilites
            ? [data.disponibilites]
            : []

          setProfile({ ...data, disponibilites })

          if (disponibilites.length === 0) {
            setShowFirstLoginModal(true)
          }
        })
        .catch((error) => console.error('Erreur chargement profil :', error))
    }
  }, [])

  if (!profile) return <p>Chargement du profil...</p>

  const handleSubmit = async (e) => {
    e.preventDefault()
    const token = sessionStorage.getItem('accessToken')

    try {
      const response = await fetch('/users/me', {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
          Authorization: `Bearer ${token}`,
        },
        body: JSON.stringify(profile),
      })

      if (response.ok) {
        alert('Profil mis à jour avec succès !')
        setIsEditing(false)
      } else {
        alert('Erreur lors de la mise à jour du profil.')
      }
    } catch (error) {
      console.error('Erreur :', error)
    }
  }

  return (
    <main id="content">
      <section id="profile-info">
        {/* Colonne gauche */}
        <div className="left-column">
          http://3000/profilPic.jpg
          <div className="plateforme-initiative">
            <h3>Plateforme initiative :</h3>
            <p>{profile.plateformeInitiative}</p>
          </div>
          <div className="availabilities">
            <h3>Disponibilités :</h3>
            <div className="days">
              {profile.disponibilites.length > 0 ? (
                profile.disponibilites.map((jour, index) => (
                  <span className="day-pill" key={index}>
                    {jour}
                  </span>
                ))
              ) : (
                <p>Non renseigné</p>
              )}
            </div>
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

        {/* Colonne droite */}
        <div className="right-column">
          {isEditing ? (
            <form onSubmit={handleSubmit} className="edit-form">
              <div className="form-group">
                <label htmlFor="prenom">Prénom</label>
                <input
                  id="prenom"
                  type="text"
                  value={profile.prenom}
                  onChange={(e) =>
                    setProfile({ ...profile, prenom: e.target.value })
                  }
                />
              </div>
              <div className="form-group">
                <label htmlFor="nom">Nom</label>
                <input
                  id="nom"
                  type="text"
                  value={profile.nom}
                  onChange={(e) =>
                    setProfile({ ...profile, nom: e.target.value })
                  }
                />
              </div>
              <div className="form-group">
                <label htmlFor="email">Email</label>
                <input
                  id="email"
                  type="email"
                  value={profile.email}
                  onChange={(e) =>
                    setProfile({ ...profile, email: e.target.value })
                  }
                />
              </div>
              <div className="form-group">
                <label htmlFor="disponibilites">Disponibilités</label>
                <div className="checkbox-group">
                  {[
                    'Lundi',
                    'Mardi',
                    'Mercredi',
                    'Jeudi',
                    'Vendredi',
                    'Samedi',
                    'Dimanche',
                  ].map((jour) => (
                    <label key={jour}>
                      <input
                        type="checkbox"
                        value={jour}
                        checked={profile.disponibilites.includes(jour)}
                        onChange={(e) => {
                          const checked = e.target.checked
                          const value = e.target.value
                          setProfile((prev) => ({
                            ...prev,
                            disponibilites: checked
                              ? [...prev.disponibilites, value]
                              : prev.disponibilites.filter((d) => d !== value),
                          }))
                        }}
                      />
                      {jour}
                    </label>
                  ))}
                </div>
              </div>
              <div className="form-buttons">
                <button type="submit" className="confirm">
                  Enregistrer
                </button>
                <button
                  type="button"
                  className="cancel"
                  onClick={() => setIsEditing(false)}
                >
                  Annuler
                </button>
              </div>
            </form>
          ) : (
            <div className="user-info">
              <div className="name">
                <p>{profile.prenom}</p>
                <p>{profile.nom}</p>
              </div>
              <button onClick={() => setIsEditing(true)}>Modifier</button>
            </div>
          )}

          <div className="profile-description">
            <h2>DESCRIPTION DU PROJET ET DES BESOINS</h2>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
              eiusmod tempor incididunt ut labore et dolore magna aliqua...
            </p>
          </div>
        </div>

        {/* Modale de première connexion */}
        {showFirstLoginModal && (
          <div className="modal-overlay">
            <div className="modal">
              <h3>Bienvenue !</h3>
              <p>Merci de renseigner vos disponibilités :</p>
              <div className="checkbox-group">
                {[
                  'Lundi',
                  'Mardi',
                  'Mercredi',
                  'Jeudi',
                  'Vendredi',
                  'Samedi',
                  'Dimanche',
                ].map((jour) => (
                  <label key={jour}>
                    <input
                      type="checkbox"
                      value={jour}
                      checked={profile.disponibilites.includes(jour)}
                      onChange={(e) => {
                        const checked = e.target.checked
                        const value = e.target.value
                        setProfile((prev) => ({
                          ...prev,
                          disponibilites: checked
                            ? [...prev.disponibilites, value]
                            : prev.disponibilites.filter((d) => d !== value),
                        }))
                      }}
                    />
                    {jour}
                  </label>
                ))}
              </div>

              <div className="modal-buttons">
                <button
                  className="confirm"
                  onClick={() => {
                    setShowFirstLoginModal(false)
                    handleSubmit(new Event('submit'))
                  }}
                >
                  Enregistrer
                </button>
              </div>
            </div>
          </div>
        )}

        {/* Modale de suppression */}
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
                <button
                  className="cancel"
                  onClick={() => setIsDeleteModalOpen(false)}
                >
                  Annuler
                </button>
                <button
                  className="confirm"
                  onClick={() => {
                    if (confirmationText === 'SUPPRIMER') {
                      alert('profil supprimé')
                      setIsDeleteModalOpen(false)
                      navigate('/')
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
    </main>
  )
}

export default Profile
