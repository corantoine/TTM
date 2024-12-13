import React, { useState } from 'react'
import '../styles/header.css'
import { LogoReseauInit2 } from '../picture/LogoReseauInit2'
import { Link } from 'react-router-dom'
import Navbar from './Navbar'

export default function Header() {
  return (
    <header className="header">
      <Link to="/">
        <LogoReseauInit2 />
      </Link>
      <h1 className="header-title">Bienvenue sur TTM !</h1> <Navbar />
    </header>
  )
}
