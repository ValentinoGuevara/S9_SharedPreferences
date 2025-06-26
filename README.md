# 📱 UserProfile Manager - Gestor de Perfiles con SharedPreferences

**Desarrollado por:** Valentino Guevara  
**Contacto:** [202114033@uns.edu.pe](mailto:202114033@uns.edu.pe)  
**GitHub:** [ValentinoGuevara](https://github.com/ValentinoGuevara)  
**Curso:** Aplicaciones Móviles - Semana 9  

<div align="center">
  <img src="screenshots/app_banner.png" width="800" alt="Banner de la aplicación">
</div>

## 🔍 ¿Cómo funciona el programa?
Esta aplicación permite gestionar perfiles de usuario con persistencia local usando SharedPreferences. Su arquitectura se compone de:

### 🏗️ Núcleo del Sistema
1. **Almacenamiento Persistente**:
   - Usa SharedPreferences para guardar:
     - Perfil de usuario (nombre, edad, email)
     - Preferencias de tema (claro/oscuro)
     - Estadísticas de uso (contador de visitas)

2. **Flujo Principal**:
   ```mermaid
   graph TD
     A[Inicio] --> B{Primer uso?}
     B -->|Sí| C[Mostrar formulario]
     B -->|No| D[Cargar perfil]
     C --> E[Guardar en SharedPreferences]
     D --> F[Mostrar datos existentes]
Características Clave:

Cambio de tema en tiempo real sin reiniciar la app

Validación de campos obligatorios

Feedback visual con Snackbars

Sistema de limpieza segura de datos

📸 Galería de Capturas
Organiza tus imágenes en /screenshots así:

<div align="center"> <h3>🎨 Interfaz de Usuario</h3> <table> <tr> <td><img src="screenshots/01_main_light.jpg" width="200" alt="Modo claro"></td> <td><img src="screenshots/02_main_dark.jpg" width="200" alt="Modo oscuro"></td> <td><img src="screenshots/03_profile_form.jpg" width="200" alt="Formulario"></td> </tr> <tr> <td><img src="screenshots/04_data_saved.jpg" width="200" alt="Datos guardados"></td> <td><img src="screenshots/05_validation.jpg" width="200" alt="Validación"></td> <td><img src="screenshots/06_stats.jpg" width="200" alt="Estadísticas"></td> </tr> </table> <p>¡Captura real de la aplicación en acción!</p> </div>
🛠️ Implementación Técnica
Estructura de Código
kotlin
// Clase principal para manejar preferencias
class PrefsManager(context: Context) {
    private val prefs = context.getSharedPreferences("USER_DATA", MODE_PRIVATE)

    // Guardar tema seleccionado
    fun saveTheme(isDark: Boolean) {
        prefs.edit().putBoolean("DARK_MODE", isDark).apply()
    }

    // Cargar perfil de usuario
    fun loadProfile(): User? {
        return if (prefs.contains("USER_NAME")) {
            User(
                name = prefs.getString("USER_NAME", "")!!,
                age = prefs.getInt("USER_AGE", 0),
                email = prefs.getString("USER_EMAIL", "")!!
            )
        } else null
    }
}

**🌟 Sobre el Proyecto
Este proyecto fue desarrollado como parte de la Semana 9 del curso de Aplicaciones Móviles, demostrando:

✅ Manejo profesional de SharedPreferences

✅ Implementación de temas dinámicos

✅ Buenas prácticas de persistencia local

✅ Arquitectura limpia y mantenible**

**📄 Licencia**
text
MIT License
**Copyright (c) 2025 Valentino Guevara**

Permiso concedido para uso académico y personal.
Prohibido uso comercial sin autorización expresa.
<div align="center"> <img src="screenshots/app_demo.gif" width="300" alt="Demo animada"> <p>¡Explora el código y contribuye!</p> <a href="https://github.com/ValentinoGuevara/S9_SharedPreferences"> <img src="https://img.shields.io/badge/VER_EN_GITHUB-181717?style=for-the-badge&logo=github"> </a> </div> ```
