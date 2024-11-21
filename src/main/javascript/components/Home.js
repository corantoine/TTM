import React from "react";
import home from "../styles/home.css"
import TextAccueil from "./TextAccueil";
import { LogoTtm } from "../picture/LogoTtm";

const Home = () => {
return(
    <section className="body_home">
    <div className="logo_TTM">
        <LogoTtm/>
    </div>
    <div className="texte_accueil">
        <TextAccueil/>
    </div>
    <button type="submit" id="home_button">Première connexion ?</button>
    </section>
) ;
}

export default Home;