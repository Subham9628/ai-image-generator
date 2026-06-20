// src/App.js
import React from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider, useAuth } from './context/AuthContext';
import Login from './components/Auth/Login';
import Signup from './components/Auth/Signup';
import ImageGenerator from './components/ImageGenerator';
import HistoryGallery from './components/HistoryGallery';
import './App.css';

// Private route wrapper
const PrivateRoute = ({ children }) => {
  const { token } = useAuth();
  return token ? children : <Navigate to="/login" />;
};

function App() {
  return (
    <BrowserRouter>
      <AuthProvider>
        <div className="App">
          <header className="app-header">
            <h1>AI Image Generator</h1>
            <p>Generate stunning images from text descriptions</p>
          </header>
          <main>
            <Routes>
              <Route path="/login" element={<Login />} />
              <Route path="/signup" element={<Signup />} />
              <Route
                path="/"
                element={
                  <PrivateRoute>
                    <>
                      <ImageGenerator />
                      <HistoryGallery />
                    </>
                  </PrivateRoute>
                }
              />
              {/* Redirect any unknown path to home */}
              <Route path="*" element={<Navigate to="/" />} />
            </Routes>
          </main>
        </div>
      </AuthProvider>
    </BrowserRouter>
  );
}

export default App;