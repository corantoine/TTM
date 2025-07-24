import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './components/Home'
import Layout from './components/Layout'
import React from 'react'
import Login from './components/Login'
import Profile from './components/Profile'
import CreateUserForm from './components/CreateUserForm'
import { AuthProvider } from './config/AuthContext'
import FilProfile from './pages/FilProfile'

function App() {
  return (
    <div className="app">
      <BrowserRouter>
        <AuthProvider>
          <Routes>
            <Route element={<Layout />}>
              <Route path="/" element={<Home />} />
              <Route path="/login" element={<Login />} />
              <Route path="/profile" element={<Profile />} />
              <Route path="/register" element={<CreateUserForm />} />
              <Route path="/fil-des-profils" element={<FilProfile />} />
            </Route>
          </Routes>
        </AuthProvider>
      </BrowserRouter>
    </div>
  )
}

export default App
