import React from "react";
import "../styles/footer.css";
import logoFooter from "../picture/LogoFooterTTM.svg";
import facebook from "../picture/facebookColor.svg";
import linkedin from "../picture/linkedin.svg";
import tiktok from "../picture/tiktok.svg";
import instagram from "../picture/insta-logo.svg";
import instaColor from "../picture/instaColor.svg";
import facebookColor from "../picture/facebookColor.svg";
import tiktokColor from "../picture/tiktokColor.svg";
import linkedinColor from "../picture/LinkedInColor.svg";

function Footer() {
  return (
    <div>
      <footer className="footer">
        <img
          src={logoFooter}
          className="logo-ttm-footer"
          alt="logo footer ttm"
        />
        <div className="footer-info">
          <div className="footer-info-left">
            <a
              href="https://www.initiative79.com/"
              target="blank"
              rel="noopener noreferrer"
            >
              Votre plateforme :<br />
              Initiative Deux-Sèvres
            </a>
          </div>
          <div className="footer-info-right">
            <p>
              06.79.87.56.09 <br />
              accompagnement@initiativedeuxsevres.fr
            </p>
          </div>
        </div>
        <div className="social-network">
          <div className="sn-row">
            {/* <img src={instagram} className='sn-logo' alt='logo instagram'/>   */}
            <a
              href="https://www.instagram.com/initiative_deux_sevres"
              target="blank"
              rel="noopener noreferrer"
            >
              <img src={instaColor} className="sn-logo" alt="logo instagram" />
            </a>
            {/* <img src={tiktok} className='sn-logo' alt='logo tiktok'/>   */}
            <a
              href="https://www.tiktok.com/@initiative.deux.s"
              target="blank"
              rel="noopener noreferrer"
            >
              <img src={tiktokColor} className="sn-logo" alt="logo tiktok" />
            </a>
          </div>
          <div className="sn-row">
            {/* <img src={facebook} className='sn-logo' alt='logo facebook'/>   */}
            <a
              href="https://www.facebook.com/people/Initiative-Deux-S%C3%A8vres/61556616180678/"
              target="blank"
              rel="noopener noreferrer"
            >
              <img
                src={facebookColor}
                className="sn-logo"
                alt="logo facebook"
              />
            </a>
            {/* <img src={linkedin} className='sn-logo' alt='logo linkedin'/>   */}
            <a
              href="https://www.linkedin.com/company/initiative-deux-sevres"
              target="blank"
              rel="noopener noreferrer"
            >
              <img
                src={linkedinColor}
                className="sn-logo"
                alt="logo linkedin"
              />
            </a>
          </div>
        </div>
      </footer>
    </div>
  );
}

export default Footer;
