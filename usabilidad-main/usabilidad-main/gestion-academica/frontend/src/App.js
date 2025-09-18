import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Dashboard from './components/Dashboard';
import Estudiantes from './components/Estudiantes';
import Cursos from './components/Cursos';
import Docentes from './components/Docentes';
import Evaluaciones from './components/Evaluaciones';

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/estudiantes" element={<Estudiantes />} />
        <Route path="/cursos" element={<Cursos />} />
        <Route path="/docentes" element={<Docentes />} />
        <Route path="/evaluaciones" element={<Evaluaciones />} />
      </Routes>
    </Router>
  );
}

export default App;