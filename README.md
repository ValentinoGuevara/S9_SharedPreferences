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
  <h2>🖼️ Galería de la Aplicación</h2>
  <p>Capturas reales del funcionamiento de la app</p>
  
  <table>
    <!-- Fila 1 -->
    <tr>
      <td align="center"><img src="screenshots/01_splash.jpg" width="180" alt="Pantalla de inicio"></td>
      <td align="center"><img src="screenshots/02_main_light.jpg" width="180" alt="Modo claro"></td>
      <td align="center"><img src="screenshots/03_main_dark.jpg" width="180" alt="Modo oscuro"></td>
      <td align="center"><img src="screenshots/04_menu.jpg" width="180" alt="Menú principal"></td>
    </tr>
    <tr>
      <td align="center"><em>Pantalla de bienvenida</em></td>
      <td align="center"><em>Modo claro activado</em></td>
      <td align="center"><em>Modo oscuro activado</em></td>
      <td align="center"><em>Opciones principales</em></td>
    </tr>
    
    <!-- Fila 2 -->
    <tr>
      <td align="center"><img src="screenshots/05_form_empty.jpg" width="180" alt="Formulario vacío"></td>
      <td align="center"><img src="screenshots/06_form_filled.jpg" width="180" alt="Formulario completo"></td>
      <td align="center"><img src="screenshots/07_validation.jpg" width="180" alt="Validación"></td>
      <td align="center"><img src="screenshots/08_success.jpg" width="180" alt="Datos guardados"></td>
    </tr>
    <tr>
      <td align="center"><em>Formulario nuevo</em></td>
      <td align="center"><em>Datos completados</em></td>
      <td align="center"><em>Validación de campos</em></td>
      <td align="center"><em>Confirmación</em></td>
    </tr>
    
    <!-- Fila 3 -->
    <tr>
      <td align="center"><img src="screenshots/09_profile.jpg" width="180" alt="Perfil"></td>
      <td align="center"><img src="screenshots/10_stats.jpg" width="180" alt="Estadísticas"></td>
      <td align="center"><img src="screenshots/11_settings.jpg" width="180" alt="Configuración"></td>
      <td align="center"><img src="screenshots/12_dark_theme.jpg" width="180" alt="Tema oscuro"></td>
    </tr>
    <tr>
      <td align="center"><em>Perfil guardado</em></td>
      <td align="center"><em>Estadísticas de uso</em></td>
      <td align="center"><em>Ajustes</em></td>
      <td align="center"><em>Personalización</em></td>
    </tr>
    
    <!-- Fila 4 -->
    <tr>
      <td align="center" colspan="2"><img src="screenshots/13_animacion.gif" width="360" alt="Demo animada"></td>
      <td align="center" colspan="2"><img src="screenshots/14_responsive.jpg" width="360" alt="Vista responsive"></td>
    </tr>
    <tr>
      <td align="center" colspan="2"><em>Función completa en GIF</em></td>
      <td align="center" colspan="2"><em>Adaptación a pantallas</em></td>
    </tr>
  </table>
  
  <p>✨ <strong>Experiencia de usuario fluida e intuitiva</strong> ✨</p>
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
