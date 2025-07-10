import React, { useContext } from 'react'
import home from '../styles/home.css'
import TextAccueil from './TextAccueil'
import { LogoTtm } from '../picture/LogoTtm'
import { Link } from 'react-router-dom'
import { AuthContext } from '../config/AuthContext'

const Home = () => {
  const { payload } = useContext(AuthContext)
  return (
    <div>
      {!payload ? (
        <section className="body_home">
          <div className="logo_TTM">
            <LogoTtm />
          </div>
          <div className="texte_accueil">
            <TextAccueil />
          </div>
          <Link to="/login">
            <button type="submit" id="home_button">
              Première connexion ?
            </button>
          </Link>
        </section>
      ) : (
        <section className="body_home">
          <div className="logo_TTM">
            <LogoTtm />
          </div>
          <div className="texte_accueil">
            <TextAccueil />
          </div>
        </section>
      )}
    </div>
  )
}

export default Home
