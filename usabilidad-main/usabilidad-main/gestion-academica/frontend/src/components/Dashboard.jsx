import React, { useEffect, useState } from 'react';
import axios from 'axios';

function Dashboard() {
  const [stats, setStats] = useState({
    estudiantes: 0,
    cursos: 0,
    docentes: 0,
    promedioNotas: 0
  });

  useEffect(() => {
    const fetchStats = async () => {
      try {
        const res = await axios.get('http://localhost:3000/dashboard');
        setStats(res.data);
      } catch (err) {
        console.error('Error al cargar estadísticas:', err);
      }
    };

    fetchStats();
  }, []);

  return (
    <div>
      <h2>Dashboard Académico</h2>
      <ul>
        <li>👨‍🎓 Estudiantes registrados: {stats.estudiantes}</li>
        <li>📚 Cursos activos: {stats.cursos}</li>
        <li>👩‍🏫 Docentes registrados: {stats.docentes}</li>
        <li>📈 Promedio general de notas: {stats.promedioNotas}</li>
      </ul>
    </div>
  );
}

export default Dashboard;