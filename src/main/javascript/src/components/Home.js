import React from "react";
import logo_TTM from "../picture/logo_TTM.svg";
import home from "../styles/home.css"

const Home = () => {
return(
    <section className="body_home">
    <div className="logo_TTM">
        <img src = {logo_TTM} className="app_logo" alt="logo de l'application"/>
    </div>
    <div className="texte_accueil">
        {/* {TexteAccueil} */}Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tempus pretium nulla, in efficitur erat. Vestibulum pretium dapibus libero at suscipit. Quisque tempus ipsum enim, vel dapibus odio aliquam porta. Donec suscipit tortor vel iaculis gravida. Mauris malesuada congue bibendum. Phasellus bibendum commodo euismod. Vivamus semper felis a dui porttitor hendrerit. 
        Suspendisse a pellentesque quam, vitae eleifend velit. Integer aliquet et enim vel aliquet. 
        Vestibulum sollicitudin, est sit amet imperdiet pellentesque, tortor nisl scelerisque ligula, luctus dignissim nulla enim et quam. 
        Praesent id ultrices ligula, nec pulvinar ipsum. 
    </div>
    <button id="home_button">Première connexion ?</button>
    </section>
) ;
}

export default Home;