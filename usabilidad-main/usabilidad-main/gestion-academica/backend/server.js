const express = require('express');
const mysql = require('mysql2');
const cors = require('cors');
const bodyParser = require('body-parser');

const app = express();
app.use(cors());
app.use(bodyParser.json());

// Conexión a MySQL
const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '', // cambia si tienes contraseña
  database: 'gestion_academica'
});

db.connect(err => {
  if (err) {
    console.error('Error de conexión:', err);
    return;
  }
  console.log('Conectado a MySQL');
});


// 📊 Ruta para estadísticas del dashboard
app.get('/dashboard', (req, res) => {
  const stats = {};

  db.query('SELECT COUNT(*) AS total FROM estudiantes', (err, result) => {
    if (err) return res.status(500).send(err);
    stats.estudiantes = result[0].total;

    db.query('SELECT COUNT(*) AS total FROM cursos', (err, result) => {
      if (err) return res.status(500).send(err);
      stats.cursos = result[0].total;

      db.query('SELECT COUNT(*) AS total FROM docentes', (err, result) => {
        if (err) return res.status(500).send(err);
        stats.docentes = result[0].total;

        db.query('SELECT AVG(nota) AS promedio FROM evaluaciones', (err, result) => {
          if (err) return res.status(500).send(err);
          stats.promedioNotas = parseFloat(result[0].promedio || 0).toFixed(2);
          res.send(stats);
        });
      });
    });
  });
});


// 👨‍🎓 Ruta para registrar estudiantes
app.post('/estudiantes', (req, res) => {
  const { nombre, correo, fecha_nacimiento, carrera } = req.body;
  const sql = 'INSERT INTO estudiantes (nombre, correo, fecha_nacimiento, carrera) VALUES (?, ?, ?, ?)';
  db.query(sql, [nombre, correo, fecha_nacimiento, carrera], (err, result) => {
    if (err) {
      console.error('Error al insertar estudiante:', err);
      res.status(500).send({ message: 'Error al registrar estudiante' });
      return;
    }
    res.send({ message: 'Estudiante registrado', id: result.insertId });
  });
});

// 👨‍🎓 Ruta para obtener estudiantes
app.get('/estudiantes', (req, res) => {
  db.query('SELECT * FROM estudiantes', (err, results) => {
    if (err) {
      console.error('Error al consultar estudiantes:', err);
      res.status(500).send({ message: 'Error al obtener estudiantes' });
      return;
    }
    res.send(results);
  });
});


// 👩‍🏫 Ruta para obtener docentes
app.get('/docentes', (req, res) => {
  db.query('SELECT * FROM docentes', (err, results) => {
    if (err) {
      console.error('Error al consultar docentes:', err);
      res.status(500).send({ message: 'Error al obtener docentes' });
      return;
    }
    res.send(results);
  });
});


// 📚 Ruta para crear cursos
app.post('/cursos', (req, res) => {
  const { nombre, descripcion, docente_id } = req.body;
  const sql = 'INSERT INTO cursos (nombre, descripcion, docente_id) VALUES (?, ?, ?)';
  db.query(sql, [nombre, descripcion, docente_id], (err, result) => {
    if (err) {
      console.error('Error al crear curso:', err);
      res.status(500).send({ message: 'Error al crear curso' });
      return;
    }
    res.send({ message: 'Curso creado', id: result.insertId });
  });
});

// 📚 Ruta para obtener cursos con nombre del docente
app.get('/cursos', (req, res) => {
  const sql = `
    SELECT cursos.id, cursos.nombre, cursos.descripcion, docentes.nombre AS docente_nombre
    FROM cursos
    LEFT JOIN docentes ON cursos.docente_id = docentes.id
  `;
  db.query(sql, (err, results) => {
    if (err) {
      console.error('Error al consultar cursos:', err);
      res.status(500).send({ message: 'Error al obtener cursos' });
      return;
    }
    res.send(results);
  });
});


// 🚀 Iniciar servidor
app.listen(3000, () => {
  console.log('Servidor backend corriendo en http://localhost:3000');
});