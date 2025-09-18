import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Estudiantes() {
  const [formData, setFormData] = useState({
    nombre: '',
    correo: '',
    fecha_nacimiento: '',
    carrera: ''
  });

  const [estudiantes, setEstudiantes] = useState([]);

  // Cargar estudiantes al iniciar
  useEffect(() => {
    fetchEstudiantes();
  }, []);

  const fetchEstudiantes = async () => {
    try {
      const res = await axios.get('http://localhost:3000/estudiantes');
      setEstudiantes(res.data);
    } catch (err) {
      console.error('Error al obtener estudiantes:', err);
    }
  };

  const handleChange = e => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async e => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:3000/estudiantes', formData);
      alert('Estudiante registrado');
      setFormData({ nombre: '', correo: '', fecha_nacimiento: '', carrera: '' });
      fetchEstudiantes(); // recargar lista
    } catch (err) {
      alert('Error al registrar estudiante');
    }
  };

  return (
    <div>
      <h2>Gestión de Estudiantes</h2>

      <form onSubmit={handleSubmit}>
        <input name="nombre" value={formData.nombre} onChange={handleChange} placeholder="Nombre" required />
        <input name="correo" value={formData.correo} onChange={handleChange} placeholder="Correo" required />
        <input name="fecha_nacimiento" type="date" value={formData.fecha_nacimiento} onChange={handleChange} required />
        <input name="carrera" value={formData.carrera} onChange={handleChange} placeholder="Carrera" required />
        <button type="submit">Registrar</button>
      </form>

      <h3>Estudiantes registrados</h3>
      <ul>
        {estudiantes.map(est => (
          <li key={est.id}>
            {est.nombre} – {est.correo} – {est.carrera}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Estudiantes;