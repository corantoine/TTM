import React, { useContext, useState } from 'react'
import '../styles/login.css'
import { loginUser } from '../service/LoginUser'
import { AuthContext } from '../config/AuthContext'
import { useNavigate, useParams } from 'react-router-dom'
import Input from './Input'

const Login = () => {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const { login } = useContext(AuthContext)
  const navigate = useNavigate()
  const params = useParams()
  const url = window.location.pathname

  const handleSubmit = async (event) => {
    event.preventDefault()
    try {
      const response = await loginUser(email, password)
      console.log(response)

      if (response) {
        login(response.accessToken)
        navigate(url == '/login' ? '/' : url)
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

// const Login = () => {
//  const handleSubmit = (event) => {
//     event.preventDefault();
//  }

//   return (
//     <div className='login'>
//         <div className='login-page-title-and-text'>
//       <h2>Page de connexion</h2>
//       <p>
//         Afin de pouvoir vous connecter, vous devez avoir validé votre inscription au site grâce au lien contenu dans le mail que vous recevrez à la suite de votre validation lors de votre passage en commission.
//       </p>
//       </div>
//       <div className="login-card">
//         <form onSubmit={handleSubmit} className="login-form">
//           <h4 className="login-title">Connexion</h4>
//           <input
//           name='email'
//           className='login-input'
//           placeholder= "Nom d'utilisateur ou e-mail"
//           />
//           <input
//           name='password'
//           className='login-input'
//           placeholder='Mot de passe'
//           />
//           <button
//           id='login-button'
//           type='submit'>
//             Se connecter
//           </button>
//           <p>Mot de passe oublié ?</p>
//         </form>
//       </div>
//     </div>
//   )
// }

// export default Login
