import React, { useContext, useState } from 'react'
import '../styles/login.css'
import { loginUser } from '../service/LoginUser'
import { AuthContext } from '../config/AuthContext'
import { useNavigate, useParams } from 'react-router-dom'
import Input from './Input'

const Login = () => {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const { login, payload } = useContext(AuthContext)
  const navigate = useNavigate()
  const params = useParams()
  const url = window.location.pathname
  const [showModal, setShowModal] = useState(false)
  const [domaines, setDomaines] = useState([])
  const [typesReseau, setTypesReseau] = useState([])
  const role = payload?.payload?.role
  console.log('ROLE ==', role)
  
  const handleSubmit = async (event) => {
    event.preventDefault()
    try {
      const response = await loginUser(email, password)
      console.log(response)
      
      if (response) {
        console.log('firstLogin ==>', response.firstLogin)
        login(response.accessToken)

        if (response.firstLogin) {
          setShowModal(true)
        } else {
          navigate(url === '/login' ? '/' : url)
        }
      }
    } catch (error) {
      console.error('Login failed:', error)
    }
  }

  return (
    <div className="login">
      <div className="login-page-title-and-text">
        <h2>Page de connexion</h2>
        <p>
          Afin de pouvoir vous connecter, vous devez avoir validé votre
          inscription au site grâce au lien contenu dans le mail que vous
          recevrez à la suite de votre validation lors de votre passage en
          commission.
        </p>
      </div>
      <div className="form-container">
        <form method="post" onSubmit={handleSubmit} className="login-form">
          <h4 className="login-title">Connexion</h4>
          <Input
            type="email"
            name="Nom d'utilisateur ou adresse email : "
            placeholder="Nom d'utilisateur ou e-mail"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            useValuseAsLabel={false}
            className="login-input"
          ></Input>
          <Input
            type="password"
            name="Mot de passe : "
            placeholder="Mot de passe"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            useValuseAsLabel={false}
            className="login-input"
          />
          <button id="login-button" type="submit">
            Se connecter
          </button>
          <p>Mot de passe oublié ?</p>
        </form>
      </div>
    </div>
  )
}

export default Login
