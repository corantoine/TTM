import React from 'react'
import '../styles/header.css'
import { useLocation } from 'react-router-dom'

// const paths = {
//   uoTitle: '/uo',
//   roleTitle: '/role',
//   acteurTitle: '/acteur',
//   homeTitle: '/',
// }

// const whichPath = (currentPath) => {
//   switch (currentPath) {
//     case paths.uoTitle:
//       return 'Unites organisationnelles'
//     case paths.roleTitle:
//       return 'ROLES'
//     case paths.acteurTitle:
//       return 'ACTEURS'
//     case paths.homeTitle:
//       return 'Bienvenue sur Flow Chart Tree !'
//     default:
//       return console.error("cette page n'existe pas.")
//   }
// }
export default function Header() {
  const location = useLocation()
  const currentPath = location.pathname
  console.log('log de currentPath : ', currentPath)

  return (
    <nav className="header">
      <h3 className="title-site">
        TTM
      </h3>
      <div>
        <h1 className="header-title">Bienvenue sur TTM !</h1>
      </div>
      <ul className="nav-items">
        <li className="li-nav">
          LOGO
        </li>
        <li className="li-nav">
          CONNEXION
        </li>
      </ul>
    </nav>
  )
}
