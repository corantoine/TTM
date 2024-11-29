import React, { useState } from 'react'
import '../styles/header.css'
import { LogoReseauInit2 } from '../picture/LogoReseauInit2'
import { LoginLogo } from '../picture/LoginLogo'
import { Link, useNavigate } from 'react-router-dom'
import { BurgerMenu } from '../picture/BurgerMenu'

export default function Header() {
  // Utilisation d'un state pour gérer l'état du menu burger

  const [menuOpen, setMenuOpen] = useState(false)

  const toggleMenu = () => {
    setMenuOpen(!menuOpen)
  }

  return (
    <header className="header">
      <Link to="/">
        <LogoReseauInit2 />
      </Link>
      <nav className={`nav ${menuOpen ? 'open' : ''}`}>
        <h1 className="header-title">Bienvenue sur TTM !</h1>{' '}
        <ul className="nav-items">
          <li> <Link to='/'>Accueil</Link></li>
          <li>
            <Link to="/login">Connexion</Link>
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
    </header>
  )
}
