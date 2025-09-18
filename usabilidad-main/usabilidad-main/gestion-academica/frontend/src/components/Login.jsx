import React, { useState } from 'react';
import './Login.css'; // Opcional: para estilos personalizados

const Login = ({ onLogin }) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    // Validación simple
    if (!email || !password) {
      setError('Por favor, completa todos los campos.');
      return;
    }

    // Simulación de login (puedes reemplazar con llamada a tu API)
    if (email === 'admin@academia.com' && password === '123456') {
      setError('');
      onLogin?.({ email }); // Puedes usar esto para redirigir o guardar sesión
    } else {
      setError('Credenciales incorrectas.');
    }
  };

  return (
    <div className="login-container">
      <h2>Ingreso al Sistema Académico</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="email"
          placeholder="Correo institucional"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          placeholder="Contraseña"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        {error && <p className="error">{error}</p>}
        <button type="submit">Ingresar</button>
      </form>
    </div>
  );
};

export default Login;