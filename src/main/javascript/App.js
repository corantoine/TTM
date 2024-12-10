import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './components/Home'
import Layout from './components/Layout'
import React from 'react'
import Login from './components/Login'
import Match from './components/Match'
import CreateUserForm from './components/CreateUserForm'

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route element={<Layout />}>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/matchs" element={<Match />} />
            <Route path="/register" element={<CreateUserForm />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App

// PROBLEME EXECUTION REACT ROUTER DOM A REGLER.
