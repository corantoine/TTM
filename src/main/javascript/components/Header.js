import React, { useState } from 'react'
import '../styles/header.css'
import { LogoReseauInit2 } from '../picture/LogoReseauInit2'
import { LoginLogo } from '../picture/LoginLogo'
import { Link, useNavigate } from 'react-router-dom'

export default function Header() {
  // Utilisation d'un state pour gérer l'état du menu burger

  const [showLinks, setShowLinks] = useState(false)
  const navigate = useNavigate()

  const handleShowLinks = () => {
    setShowLinks(!showLinks)
  }

  return (
    // <header className={`navbar ${showLinks ? 'show-nav' : 'hide-nav'}`}>
    //   <div className='header'>
    //   <LogoReseauInit2 />
    //   <div className="header-title-container">
    //     <h1 className="header-title">Bienvenue sur TTM !</h1>
    //   </div>
    //   <ul className="nav-items">
    //     <li className="li-nav">
    //       <LoginLogo />
    //       <div id="icons"></div>
    //     </li>
    //   </ul>
    //   </div>
    // </header>

    <header className={`navbar ${showLinks ? 'show-nav' : 'hide-nav'}`}>
      {' '}
      {/* ternaire pour ajouter afficher ou cacher la navbar en fonction de l'état de showLinks */}
      <div className="logo-and-text-container">
        <Link to="/">
          <LogoReseauInit2 />
        </Link>{' '}
        <div className="header-title-container">
          <h1 className="header-title">Bienvenue sur TTM !</h1>{' '}
        </div>
        <ul className="navbar-links">
          <li className="li-nav">
            <Link to="/login">
              <LoginLogo />
            </Link>
          </li>
        </ul>
      </div>
    </header>
  )
}
