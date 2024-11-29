import React from 'react'
import '../styles/footer.css'
import { LogoFooterTTM } from '../picture/LogoFooterTTM'
import { InstaColor } from '../picture/InstaColor'
import { FacebookColor } from '../picture/FacebookColor'
import { TiktokColor } from '../picture/TiktokColor'
import { LinkedInColor } from '../picture/LinkedInColor'

function Footer() {
  return (
    <div>
      <footer className="footer">
        <LogoFooterTTM />
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
            <a
              href="https://www.instagram.com/initiative_deux_sevres"
              target="blank"
              rel="noopener noreferrer"
            >
              <InstaColor />
            </a>
            <a
              href="https://www.tiktok.com/@initiative.deux.s"
              target="blank"
              rel="noopener noreferrer"
            >
              <TiktokColor />
            </a>
          </div>
          <div className="sn-row">
            <a
              href="https://www.facebook.com/people/Initiative-Deux-S%C3%A8vres/61556616180678/"
              target="blank"
              rel="noopener noreferrer"
            >
              <FacebookColor />
            </a>
            <a
              href="https://www.linkedin.com/company/initiative-deux-sevres"
              target="blank"
              rel="noopener noreferrer"
            >
              <LinkedInColor />
            </a>
          </div>
        </div>
      </footer>
    </div>
  )
}

export default Footer
