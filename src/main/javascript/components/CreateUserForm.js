import React, { useState } from 'react'
import '../styles/createUserForm.css'
import { CreateUser } from '../service/CreateUser'
import Tooltip from './Tooltip'

const CreateUserForm = () => {
  const [formData, setFormData] = useState({
    nom: '',
    prenom: '',
    username: '',
    password: '',
    confirmPassword: '',
    email: '',
    plateforme: '',
    role: '',
  })

  const [passwordError, setPasswordError] = useState('')
  const [showPassword, setShowPassword] = useState(false)
  const [showConfirmPassword, setShowConfirmPassword] = useState(false)
  // Etat pour afficher une erreur si l'adresse email ne correspond pas à la regex
  const [emailError, setEmailError] = useState('')

  const regexPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,}$/
  const regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/

  //Mdp test : r0Y124§!

  const handleChange = (e) => {
    const { name, value } = e.target
    setFormData({ ...formData, [name]: value })
  }

  const [formError, setFormError] = useState('')

  const handleSubmitRegister = async (e) => {
    e.preventDefault()
    const {
      nom,
      prenom,
      username,
      password,
      confirmPassword,
      email,
      plateforme,
      role,
    } = formData

    // Vérification que tous les champs sont remplis
    if (
      !nom ||
      !prenom ||
      !username ||
      !password ||
      !confirmPassword ||
      !email ||
      !plateforme ||
      !role
    ) {
      setFormError('Tous les champs doivent être remplis.')
      return
    }

    // Vérifie que le mot de passe respecte la regex
    if (!regexPassword.test(password)) {
      setPasswordError(
        'Le mot de passe doit contenir au moins 8 caractères, une majuscule, une minuscule, un chiffre et un caractère spécial.'
      )
      return
    }

    // Vérifie que l'adresse mail soit au bon format
    if (!regexEmail.test(email)) {
      setEmailError("Le format de l'adresse email est invalide")
      return
    }

    // Vérifie que le password et sa confirmation sont identiques
    if (password !== confirmPassword) {
      setPasswordError('Les mots de passe ne correspondent pas.')
      return
    }
    setEmailError('')
    setPasswordError('')
    setFormError('')

    try {
      await CreateUser(
        nom,
        prenom,
        username,
        password,
        confirmPassword,
        email,
        plateforme,
        role
      )
    } catch (error) {
      console.error(error.message)
    }
  }

  return (
    <main className="main-container" aria-labelledby="form-title">
      <div className="createUserForm-container">
        <h2 id="form-title" className="register-title">
          Créer un compte
        </h2>
        <form
          className="form-mini-container"
          onSubmit={handleSubmitRegister}
          noValidate
        >
          <div>
            <label htmlFor="nom">Nom :</label>
            <input
              type="text"
              id="nom"
              name="nom"
              value={formData.nom}
              onChange={handleChange}
              required
              aria-required="true"
            />
          </div>
          <div>
            <label htmlFor="prenom">Prénom :</label>
            <input
              type="text"
              id="prenom"
              name="prenom"
              value={formData.prenom}
              onChange={handleChange}
              required
              aria-required="true"
            />
          </div>
          <div>
            <label htmlFor="username">Nom d'utilisateur :</label>
            <input
              type="text"
              id="username"
              name="username"
              value={formData.username}
              onChange={handleChange}
              required
              aria-required="true"
            />
          </div>
          <div>
            <label htmlFor="plateforme">Plateforme initiative :</label>
            <input
              type="text"
              id="plateforme"
              name="plateforme"
              value={formData.plateforme}
              onChange={handleChange}
              required
              aria-required="true"
            />
          </div>
          <div>
            <label id="role-label">Rôle :</label>
            <div
              className="radio-choice"
              role="radiogroup"
              aria-labelledby="role-label"
            >
              <div>
                <input
                  type="radio"
                  id="roleParrain"
                  name="role"
                  value="PARRAIN"
                  onChange={handleChange}
                  required
                  aria-required="true"
                />
                <label htmlFor="roleParrain">Parrain</label>
              </div>
              <div>
                <input
                  type="radio"
                  id="rolePorteur"
                  name="role"
                  value="PORTEUR"
                  onChange={handleChange}
                />
                <label htmlFor="rolePorteur">Porteur</label>
              </div>
            </div>
          </div>
          <div>
            <label htmlFor="email">Email :</label>
            <input
              type="email"
              id="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              required
              aria-required="true"
              aria-describedby={emailError ? 'emailError' : undefined}
              aria-invalid={!!emailError}
            />
            {emailError && (
              <p id="emailError" style={{ color: 'red' }} role="alert">
                {emailError}
              </p>
            )}
          </div>
          <div>
            <div className="label-with-icon">
              <label htmlFor="password">Mot de passe :</label>
              <Tooltip
                text={
                  <ul className="password-criteria">
                    <li>Au moins 8 caractères</li>
                    <li>Une minuscule</li>
                    <li>Une majuscule</li>
                    <li>Un chiffre</li>
                    <li>Un caractère spécial</li>
                  </ul>
                }
              >
                <span
                  className="info-icon"
                  role="img"
                  aria-label="Informations"
                >
                  ℹ️
                </span>
              </Tooltip>
            </div>
            <div className="input-with-icon">
              <input
                type={showPassword ? 'text' : 'password'}
                id="password"
                name="password"
                autoComplete="on"
                value={formData.password}
                onChange={handleChange}
                required
                aria-required="true"
                aria-describedby={passwordError ? 'passwordError' : undefined}
                aria-invalid={!!passwordError}
              />
              <button
                type="button"
                className="eye-icon"
                onClick={() => setShowPassword(!showPassword)}
                aria-label={
                  showPassword
                    ? 'Masquer le mot de passe'
                    : 'Afficher le mot de passe'
                }
              >
                {showPassword ? 'X' : '👁️'}
              </button>
            </div>
            {passwordError && (
              <p id="passwordError" style={{ color: 'red' }} role="alert">
                {passwordError}
              </p>
            )}
          </div>
          <div>
            <label htmlFor="confirmPassword">Confirmer le mot de passe :</label>
            <div className="input-with-icon">
              <input
                type={showConfirmPassword ? 'text' : 'password'}
                id="confirmPassword"
                name="confirmPassword"
                autoComplete="on"
                value={formData.confirmPassword}
                onChange={handleChange}
                required
                // champ obligatoire
                aria-required="true"
                aria-describedby={
                  formData.confirmPassword !== formData.password
                    ? 'confirmError'
                    : undefined
                }
                aria-invalid={formData.confirmPassword !== formData.password}
              />
              <button
                type="button"
                className="eye-icon"
                onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                aria-label={
                  showConfirmPassword
                    ? 'Masquer le mot de passe'
                    : 'Afficher le mot de passe'
                }
              >
                {showConfirmPassword ? 'X' : '👁️'}
              </button>
            </div>
            {formData.confirmPassword &&
              formData.confirmPassword !== formData.password && (
                <p id="confirmError" style={{ color: 'red' }} role="alert">
                  Les mots de passe ne correspondent pas.
                </p>
              )}
          </div>
          {formError && <p className="error-message">{formError}</p>}

          <button type="submit" className="register-button">
            S'enregistrer
          </button>
        </form>
      </div>
    </main>
  )
}
export default CreateUserForm
