import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import { BurgerMenu } from '../picture/BurgerMenu'
import { LoginLogo } from '../picture/LoginLogo'
import '../styles/header.css'

const Navbar = () => {
      // Utilisation d'un state pour gérer l'état du menu burger

  const [menuOpen, setMenuOpen] = useState(false)

  const toggleMenu = () => {
    setMenuOpen(!menuOpen)
  }
  return (
    <nav className={`nav ${menuOpen ? 'open' : ''}`}>
      
      <ul className="nav-items">
        <li>
          {' '}
          <Link to="/">Accueil</Link>
        </li>
        <li>
          <Link to="/login">Connexion</Link>
        </li>
        <li>
          <Link to ="/register">Creer user</Link>
        </li>
        <div className="login-logo">
          <Link to="/login">
            <LoginLogo />
          </Link>
        </div>
      </ul>
      <div className="burger-menu" onClick={toggleMenu}>
        <BurgerMenu />
      </div>
      <div className="close-menu" onClick={toggleMenu}>
        X
      </div>
    </nav>
  )
}

export default Navbar
