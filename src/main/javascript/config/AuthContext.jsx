import React from 'react'
import { createContext, useState } from 'react'

export const AuthContext = createContext(undefined)

export const AuthProvider = ({ children }) => {
  const [isLogged, setIsLogged] = useState(false)

  const loginContext = () => {
    setIsLogged(true)
  }
  const logout = () => {
    sessionStorage.removeItem('accessToken')
    setIsLogged(false)
  }

  return (
    <AuthContext.Provider value={{ isLogged, loginContext, logout }}>
      {children}
    </AuthContext.Provider>
  )
}
