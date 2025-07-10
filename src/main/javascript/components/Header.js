import React, { useContext, useState } from 'react'
import '../styles/header1.css'
import { LogoReseauInit2 } from '../picture/LogoReseauInit2'
import { Link } from 'react-router-dom'
import Navbar from './Navbar'
import { AuthContext } from '../config/AuthContext'
import { LoginLogo } from '../picture/LoginLogo'

const Header = () => {
  const { payload, logout } = useContext(AuthContext)
  const role = payload?.payload?.role

  console.log(role)

  return (
    <>
      {!role ? (
        <header className="anonymous-header">
          <div className="header-left">
            <Link to="/">
              <LogoReseauInit2 />
            </Link>
          </div>

          <div className="header-center">
            <h1 className="header-title">Bienvenue sur TTM !</h1>
          </div>

          <div className="header-right">
            <Link to="/login">
              <LoginLogo />
            </Link>
          </div>
        </header>
      ) : (
        <header className="header-connected">
          <Link to="/">
            <LogoReseauInit2 />
          </Link>
          <Navbar />
        </header>
      )}
    </>
  )
  return (
    <header className="header">
      <Link to="/">
        <LogoReseauInit2 />
      </Link>
      {!user ? (
        <div className="header-title">
          <h1>Bienvenue sur TTM !</h1>
        </div>
      ) : (
        <Navbar />
      )}
    </header>
  )
}

export default Header
