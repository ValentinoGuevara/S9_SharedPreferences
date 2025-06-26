
# 🚀 User Profile Manager - Aplicación Android (Semana 9)

<div align="center">
  <img src="screenshots/app_banner.png" width="800" alt="Banner de la aplicación">
  <br>
  <em>Aplicación de gestión de perfiles con persistencia de datos local</em>
</div>

## 🔥 ¿Qué hace esta aplicación?
**Gestión inteligente de perfiles** con almacenamiento persistente que permite:

- 📝 Crear y editar perfiles de usuario (nombre, edad, email)
- 🌗 Cambio dinámico de tema (claro/oscuro) con persistencia automática
- 📊 Registrar estadísticas de uso (contador de visitas, última actividad)
- 🔄 Resetear datos con confirmación de seguridad

## 🛠️ Arquitectura Técnica
```plaintext
📂 com.example.app_s9
├── 📁 data
│   └── SharedPreferencesHelper.kt  # Capa de persistencia
├── 📁 domain
│   └── User.kt                     # Modelo de datos
└── 📁 presentation
    ├── MainActivity.kt             # Lógica del contador
    └── UserProfileActivity.kt      # Gestión de formularios
