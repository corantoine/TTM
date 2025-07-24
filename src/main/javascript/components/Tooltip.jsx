import React, { useState } from 'react'
import '../styles/tooltip.css'

/**
 * Composant Tooltip qui affiche une info-bulle au survol de la souris.
 *
 * @component
 * @param {Object} props - Les propriétés du composant.
 * @param {React.ReactNode} props.text - Le contenu textuel ou JSX de la tooltip.
 * @param {React.ReactNode} props.children - L'élément enfant qui déclenche l'affichage de la tooltip.
 * @returns {JSX.Element} Le composant Tooltip.
 *
 * @example
 * <Tooltip text="Ceci est une info-bulle">
 *   <button>Survolez-moi</button>
 * </Tooltip>
 */
const Tooltip = ({ text, children }) => {
  const [visible, setVisible] = useState(false)

  return (
    <div
      className="tooltip-container"
      onMouseEnter={() => setVisible(true)}
      onMouseLeave={() => setVisible(false)}
    >
      {children}
      {visible && <div className="tooltip">{text}</div>}
    </div>
  )
}

export default Tooltip
