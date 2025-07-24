// import React, { useContext, useState } from 'react'
// import { Link } from 'react-router-dom'
// import { BurgerMenu } from '../picture/BurgerMenu'
// import { LoginLogo } from '../picture/LoginLogo'
// import '../styles/header.css'
// import { AuthContext } from '../config/AuthContext'

// const Navbar = () => {
//   // Utilisation d'un state pour gérer l'état du menu burger
//   const { payload, logout } = useContext(AuthContext)
//   const [menuOpen, setMenuOpen] = useState(false)

//   const role = payload?.payload?.role
//   console.log('ROLE ==', role)

//   const toggleMenu = () => {
//     setMenuOpen(!menuOpen)
//   }
//   return (
//     <nav className={`nav ${menuOpen ? 'open' : 'mobile-class'}`}>
//       <ul className="nav-items">
//         <li>
//           <Link to="/">Accueil</Link>
//         </li>
//         {!payload && (
//           <>
//             <li>
//               <Link to="/login">Connexion</Link>
//             </li>
//           </>
//         )}
//         {payload && (
//           <>
//             <li>
//               <Link to="/register">Creer user</Link>
//             </li>
//             <li>TEST</li>
//             <li>TEST1</li>
//             <li>TEST2</li>
//             <li>TEST3</li>
//           </>
//         )}

//         <div className="login-logo">
//           <Link to="/login">
//             <LoginLogo />
//           </Link>
//         </div>
//       </ul>
//       <div className="burger-menu" onClick={toggleMenu} aria-label='Ouvrir le menu'>
//         <BurgerMenu />
//       </div>
//       <div className="close-menu" onClick={toggleMenu} aria-label='Fermer le menu'>
//         X
//       </div>
//     </nav>
//   )
// }

// export default Navbar

import React, { useContext, useState } from 'react'
import { Link } from 'react-router-dom'
import { BurgerMenu } from '../picture/BurgerMenu'
import { LoginLogo } from '../picture/LoginLogo'
import '../styles/navbar.css'
import { AuthContext } from '../config/AuthContext'

const Navbar = () => {
  const { payload, logout } = useContext(AuthContext)
  const [menuOpen, setMenuOpen] = useState(false)

  const role = payload?.payload?.role
  console.log('ROLE ==', role)

  const toggleMenu = () => {
    setMenuOpen(!menuOpen)
  }

  const handleLogout = () => {
    logout()
    navigate('/') // Redirection vers la page d'accueil après déconnexion
  }

  return (
    <nav className={`nav ${menuOpen ? 'open' : ''}`}>
      <div
        className="burger-menu"
        onClick={toggleMenu}
        aria-label="Ouvrir le menu"
      >
        <BurgerMenu />
      </div>

      <ul className="nav-items">
        <li>
          <Link to="/">Accueil</Link>
        </li>
        {!payload && (
          <li>
            <Link to="/login">Connexion</Link>
          </li>
        )}
        {payload && (
          <>
            <li>
              <Link to="/register">Créer user</Link>
            </li>
            <li>
              <Link to="/profile">Mon profil</Link>
            </li>
            <li>TEST1</li>
            <li>TEST2</li>
            <li onClick={handleLogout} style={{cursor: 'pointer', fontWeight:'bold'}}>Logout</li>
          </>
        )}
      </ul>

      <div className="login-logo"></div>

      <div className="close-menu" onClick={toggleMenu}>
        X
      </div>
    </nav>
  )
}

export default Navbar
