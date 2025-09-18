import React from 'react';
import { Link } from 'react-router-dom';

function Navbar() {
  return (
    <nav>
      <ul>
        <li><Link to="/">Dashboard</Link></li>
        <li><Link to="/estudiantes">Estudiantes</Link></li>
        <li><Link to="/cursos">Cursos</Link></li>
        <li><Link to="/docentes">Docentes</Link></li>
        <li><Link to="/evaluaciones">Evaluaciones</Link></li>
      </ul>
    </nav>
  );
}

export default Navbar;