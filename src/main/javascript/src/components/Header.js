import React from 'react';
import '../styles/header.css';
import logo from '../picture/logo.svg';
import loginLogo from "../picture/loginLogo.svg"

export default function Header() {
  return (
    <nav className="header">
      <img src={logo} className='logo-initiative' alt="logo initiative"/>
      <div className="header-title-container">
        <h1 className="header-title">Bienvenue sur TTM !</h1>
      </div>
      <ul className="nav-items">
        <li className="li-nav">
          <img src={loginLogo} className='login-logo' alt='logo de connexion'/>
        </li>
      </ul>
    </nav>
  );
}
