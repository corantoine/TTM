import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './components/Home'
import Layout from './components/Layout'
import React from 'react'
import Login from './components/Login'
import Profile from './components/Profile'
import CreateUserForm from './components/CreateUserForm'
import { AuthProvider } from './config/AuthContext'

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <AuthProvider>
          <Routes>
            <Route element={<Layout />}>
              <Route path="/" element={<Home />} />
              <Route path="/login" element={<Login />} />
              <Route path="/Profile" element={<Profile />} />
              <Route path="/register" element={<CreateUserForm />} />
            </Route>
          </Routes>
        </AuthProvider>
      </BrowserRouter>
    </div>
  )
}

export default App

// PROBLEME EXECUTION REACT ROUTER DOM A REGLER.
