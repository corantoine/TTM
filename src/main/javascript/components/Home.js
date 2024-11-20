import React from "react";
import logo_TTM from "../picture/logo_TTM.svg";
import home from "../styles/home.css"
import TextAccueil from "./TextAccueil";

const Home = () => {
return(
    <section className="body_home">
    <div className="logo_TTM">
        <img src = {logo_TTM} className="app_logo" alt="logo de l'application"/>
    </div>
    <div className="texte_accueil">
        <TextAccueil/>
    </div>
    <button type="submit" id="home_button">Première connexion ?</button>
    </section>
) ;
}

export default Home;