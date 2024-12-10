import React from 'react'
import { CreateUser } from '../service/CreateUser'
import '../styles/createUserForm.css'

const CreateUserForm = () => {
  const handleSubmitRegister = async (e) => {
    e.preventDefault()

    //récupérer les données du formulaire
    const { nom, prenom, username, password, email, plateforme, role } =
      Object.fromEntries(new FormData(e.target))

    //envoie dans l'api pour stocker les données dans notre BDD
    try {
      if (
        nom &&
        prenom &&
        username &&
        password &&
        email &&
        plateforme &&
        role
      ) {
        await CreateUser(
          nom,
          prenom,
          username,
          password,
          email,
          plateforme,
          role
        )
      }
    } catch (error) {
      console.error(error.message)
    }
  }

  return (
    <div className="main-container">
      <div className="createUserForm-container">
        <h2 className="register-title">Créer un compte</h2>
        <form className="form-mini-container" onSubmit={handleSubmitRegister}>
          <div>
            <label htmlFor="nom">Nom :</label>
            <input type="text" id="nom" name="nom" />
          </div>
          <div>
            <label htmlFor="prenom">Prénom :</label>
            <input type="text" id="prenom" name="prenom" />
          </div>
          <div>
            <label htmlFor="username">Nom d'utilisateur :</label>
            <input type="text" id="username" name="username" />
          </div>
          <div>
            <label htmlFor="plateforme">Plateforme initiative :</label>
            <input type="text" id="plateforme" name="plateforme" />
          </div>
          <div className="radio">
            <p>Role :</p>
            <div className="radio-choice">
              {' '}
              <input
                type="radio"
                id="roleParrain"
                name="role"
                value="PARRAIN"
              />
              <label htmlFor="roleParrain">Parrain</label>
              <input
                type="radio"
                id="rolePorteur"
                name="role"
                value="PORTEUR"
              />
              <label htmlFor="rolePorteur">Porteur</label>
            </div>
          </div>
          <div>
            <label htmlFor="email">Email :</label>
            <input type="email" id="email" name="email" />
          </div>
          <div>
            <label htmlFor="password">Mot de passe :</label>
            <input
              type="password"
              id="password"
              name="password"
              autoComplete="on"
            />
          </div>
          <button type="submit" className="register-button">
            S'enregistrer
          </button>
        </form>
      </div>
    </div>
  )
}

export default CreateUserForm
