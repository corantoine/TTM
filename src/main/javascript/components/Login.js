import React from 'react'
import '../styles/login.css'

const Login = () => {
 const handleSubmit = (event) => {
    event.preventDefault();
 }

  return (
    <div className='login'>
        <div className='login-page-title-and-text'>
      <h2 >Page de connexion</h2>
      <p>
        Afin de pouvoir vous connecter, vous devez avoir validé votre
        inscription au site <br />
        grâce au lien contenu dans le mail que vous recevrez à la suite de votre
        <br />
        validation lors de votre passage en commission.
      </p>
      </div>
      <div className="login-card">
        <form onSubmit={handleSubmit} className="login-form">
          <h3 className="login-title">Connexion</h3>
          <input
          name='email'
          className='login-input'
          placeholder= "Nom d'utilisateur ou e-mail"
          />
          <input
          name='password'
          className='login-input'
          placeholder='Mot de passe'
          />
          <button
          id='login-button'
          type='submit'>
            Se connecter
          </button>
          Mot de passe oublié ?       
        </form>
      </div>
    </div>
  )
}

export default Login
