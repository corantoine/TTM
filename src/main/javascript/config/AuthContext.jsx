import React from 'react'
import { createContext, useState } from 'react'

export const AuthContext = createContext(undefined)

function jwtDecode(t) {
  if (t == undefined || t == null) {
    return null
  }
  let encoded = t.split('.')
  let token = {
    header: JSON.parse(window.atob(encoded[0])),
    payload: JSON.parse(window.atob(encoded[1])),
    token: t,
  }
  return token
}

export const AuthProvider = ({ children }) => {
  const [payload, setPayload] = useState(
    jwtDecode(sessionStorage.getItem('accessToken'))
  )

  const login = (token) => {
    sessionStorage.setItem('accessToken', token)
    setPayload(jwtDecode(token))
  }
  const logout = () => {
    sessionStorage.removeItem('accessToken')
    setPayload(null)
  }

  return (
    <AuthContext.Provider value={{ payload, login, logout }}>
      {children}
    </AuthContext.Provider>
  )
}
