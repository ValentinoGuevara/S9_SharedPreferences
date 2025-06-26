# 📱 UserProfile Manager - Gestor de Perfiles con SharedPreferences -S9

**Desarrollado por:** Valentino Guevara  
**Contacto:** [202114033@uns.edu.pe](mailto:202114033@uns.edu.pe)  
**GitHub:** [ValentinoGuevara](https://github.com/ValentinoGuevara)  
**Curso:** Aplicaciones Móviles - Semana 9  

<div align="center">
  <img src="screenshots/imagen1.jpg" width="200" alt="Banner de la aplicación">
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
<div align="center">
  <h2>📱 Galería Completa de la Aplicación</h2>
  
  <table>
    <!-- Primera fila -->
    <tr>
      <td align="center">
        <img src="screenshots/01_splash.png" width="200" alt="Pantalla Splash">
        <br><sub><b>Pantalla de inicio</b></sub>
      </td>
      <td align="center">
        <img src="screenshots/02_main_light.png" width="200" alt="Modo Claro">
        <br><sub><b>Vista principal (claro)</b></sub>
      </td>
      <td align="center">
        <img src="screenshots/03_main_dark.png" width="200" alt="Modo Oscuro">
        <br><sub><b>Vista principal (oscuro)</b></sub>
      </td>
    </tr>
    
    <!-- Segunda fila -->
    <tr>
      <td align="center">
        <img src="screenshots/04_form_empty.png" width="200" alt="Formulario Vacío">
        <br><sub><b>Formulario nuevo</b></sub>
      </td>
      <td align="center">
        <img src="screenshots/05_form_filled.png" width="200" alt="Formulario Completo">
        <br><sub><b>Datos ingresados</b></sub>
      </td>
      <td align="center">
        <img src="screenshots/06_validation.png" width="200" alt="Validación">
        <br><sub><b>Validación de campos</b></sub>
      </td>
    </tr>
    
    <!-- Tercera fila -->
    <tr>
      <td align="center">
        <img src="screenshots/07_success.png" width="200" alt="Éxito">
        <br><sub><b>Confirmación</b></sub>
      </td>
      <td align="center">
        <img src="screenshots/08_profile.png" width="200" alt="Perfil">
        <br><sub><b>Perfil guardado</b></sub>
      </td>
      <td align="center">
        <img src="screenshots/09_stats.png" width="200" alt="Estadísticas">
        <br><sub><b>Estadísticas</b></sub>
      </td>
    </tr>
    
    <!-- Cuarta fila -->
    <tr>
      <td align="center">
        <img src="screenshots/10_settings.png" width="200" alt="Configuración">
        <br><sub><b>Ajustes</b></sub>
      </td>
      <td align="center">
        <img src="screenshots/11_theme_change.gif" width="200" alt="Cambio de Tema">
        <br><sub><b>Cambio de tema</b></sub>
      </td>
      <td align="center">
        <img src="screenshots/12_responsive.png" width="200" alt="Responsive">
        <br><sub><b>Adaptabilidad</b></sub>
      </td>
    </tr>
    
    <!-- Quinta fila -->
    <tr>
      <td align="center" colspan="3">
        <img src="screenshots/13_demo.gif" width="400" alt="Demo Completa">
        <br><sub><b>Función completa</b></sub>
      </td>
    </tr>
  </table>

  <p>✨ <b>Interfaz intuitiva y experiencia de usuario fluida</b> ✨</p>
</div>
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

## 🌟 **Sobre el Proyecto**  

Este proyecto fue desarrollado como parte de la **Semana 9** del curso de Aplicaciones Móviles, demostrando:  

### 🛠 **Tecnologías y Habilidades**  
- ✅ **Manejo profesional** de SharedPreferences  
- ✅ Implementación de **temas dinámicos** (claro/oscuro)  
- ✅ **Buenas prácticas** de persistencia local  
- ✅ Arquitectura **limpia y mantenible**  

### 📚 **Contexto Académico**  
Proyecto desarrollado para la **Universidad Nacional del Santa (UNS)**  
como evidencia de aprendizaje en desarrollo móvil con Android.  

---

## **Copyright © 2025 - Valentino Guevara** 
`
Prohibido uso comercial sin autorización expresa.
<div align="center"> <img src="screenshots/app_demo.gif" width="300" alt="Demo animada"> <p>¡Explora el código y contribuye!</p> <a href="https://github.com/ValentinoGuevara/S9_SharedPreferences"> <img src="https://img.shields.io/badge/VER_EN_GITHUB-181717?style=for-the-badge&logo=github"> </a> </div> ```
