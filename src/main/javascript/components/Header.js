import React from 'react'
import '../styles/header.css'
import { LogoReseauInit } from '../picture/LogoReseauInit'
import { LoginLogo } from '../picture/LoginLogo'

export default function Header() {
  return (
    <nav className="header">
      <LogoReseauInit />
      <div className="header-title-container">
        <h1 className="header-title">Bienvenue sur TTM !</h1>
      </div>
      <ul className="nav-items">
        <li className="li-nav">
          <LoginLogo />
        </li>
      </ul>
    </nav>
  )
}
