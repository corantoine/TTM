import React, { useContext } from 'react'
import { AuthContext } from '../config/AuthContext'
import { useNavigate } from 'react-router-dom'
import Login from './Login'
import profilePhoto from '../../../assets/profilPic.jpg'

import '../styles/profile.scss'
const Profile = () => {
  const { payload } = useContext(AuthContext)
  const navigate = useNavigate()

  // useEffect(() => {
  //   if (!payload) {
  //     navigate('/')
  //   }
  // }, [payload, navigate])
  // const Profile = () => {
  const handleClick = () => {
    alert('profil supprimé')
  }

  return (
    <div id="content">
      {payload ? (
        <div id="content">
          <div id="profile-info">
            <img
              className="profile-pic"
              alt="Photo de profil de l'utilisateur"
              src={profilePhoto}
            />
            <div className="identity">
              <div className="user-info">
                <div className="name">
                  <p>Prénom </p>
                  <p> Nom</p>
                </div>
                <p>Métier</p>
              </div>
            </div>
            <div className="availabilities">
              <h3>Disponibilités :</h3>
              <p>lundi, mardi, mercredi, jeudi</p>
            </div>
            <div className="needs">
              <p>Types de réseaux / besoins</p>
            </div>
            <div className="profile-btn">
              <button onClick={handleClick}>Supprimer mon profil</button>
              {/* <FontAwesomeIcon icon={faTrashCan} onClick={handleClick} /> */}
              {/* <p>Supprimer mon profil</p> */}
            </div>
          </div>
          <div className="profile-description">
            <h2>DESCRIPTION DU PROJET ET DES BESOINS</h2>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
              eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
              enim ad minim veniam, quis nostrud exercitation ullamco laboris
              nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
              reprehenderit in voluptate velit esse cillum dolore eu fugiat
              nulla pariatur. Excepteur sint occaecat cupidatat non proident,
              sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
          </div>
        </div>
      ) : (
        <Login />
      )}
    </div>
  )
}
export default Profile
