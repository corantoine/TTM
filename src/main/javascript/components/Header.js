// import React, { useState } from 'react'
// import '../styles/header.css'
// import { LogoReseauInit2 } from '../picture/LogoReseauInit2'
// import { LoginLogo } from '../picture/LoginLogo'
// import { Link, useNavigate } from 'react-router-dom'
// import { BurgerMenu } from '../picture/BurgerMenu'

// export default function Header() {
//   // Utilisation d'un state pour gérer l'état du menu burger

//   const [menuOpen, setMenuOpen] = useState(false)
//   const navigate = useNavigate()

//   const toggleMenu = () => {
//     setMenuOpen(!menuOpen)
//   }

//   return (
//     <header className="header">
//       <div className="logo-and-text-container">
//         <Link to="/">
//           <LogoReseauInit2 />
//         </Link>
//         {/* className par défault = nav, si menuOpen est true, la className est nav open */}
//         <nav className={`nav ${menuOpen ? 'open' : ''}`}>
//           <div className="header-title-container">
//             <h1 className="header-title">Bienvenue sur TTM !</h1>{' '}
//           </div>
//           <ul className="nav-items">
//             <li className="li-nav">
//               <Link to="/login">
//                 <LoginLogo />
//               </Link>
//             </li>
//           <li className='burger-menu' onClick={toggleMenu}><BurgerMenu/></li>
//           </ul>
//         </nav>
//       </div>
//     </header>
//   )
// }

import React, { useState } from 'react'
import '../styles/header.css'
import { LogoReseauInit2 } from '../picture/LogoReseauInit2'
import { LoginLogo } from '../picture/LoginLogo'
import { Link, useNavigate } from 'react-router-dom'
import { BurgerMenu } from '../picture/BurgerMenu'

export default function Header() {
  // Utilisation d'un state pour gérer l'état du menu burger

  const [menuOpen, setMenuOpen] = useState(false)
  const navigate = useNavigate()

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
          <li>
            <Link to="/login">Connexion</Link>
          </li>
          <li>Accueil</li>
          <li>TEST</li>
          <li>TEST</li>
          <li>TEST</li>
          <div className="login-logo">
            <Link to="/login">
              <LoginLogo />
            </Link>
          </div>
          <div className="burger-menu" onClick={toggleMenu}>
            <BurgerMenu />
          </div>
        </ul>
      </nav>
    </header>
  )
}
