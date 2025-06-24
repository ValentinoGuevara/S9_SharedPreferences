package com.example.app_s9

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class UserProfileActivity : AppCompatActivity() {

    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSaveProfile: Button
    private lateinit var buttonLoadProfile: Button
    private lateinit var buttonBack: Button
    private lateinit var textViewProfileResult: TextView
    private lateinit var rootLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_profile)

        sharedPreferencesHelper = SharedPreferencesHelper(this)

        initViews()
        setupListeners()

        val isDarkMode = sharedPreferencesHelper.getBoolean(SharedPreferencesHelper.KEY_THEME_MODE, false)
        applyTheme(isDarkMode)
    }

    private fun initViews() {
        editTextName = findViewById(R.id.editTextName)
        editTextAge = findViewById(R.id.editTextAge)
        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSaveProfile = findViewById(R.id.buttonSaveProfile)
        buttonLoadProfile = findViewById(R.id.buttonLoadProfile)
        buttonBack = findViewById(R.id.buttonBack)
        textViewProfileResult = findViewById(R.id.textViewProfileResult)
        rootLayout = findViewById(R.id.profile_main)
    }

    private fun setupListeners() {
        buttonSaveProfile.setOnClickListener { saveProfile() }
        buttonLoadProfile.setOnClickListener { loadProfile() }
        buttonBack.setOnClickListener {
            finish()  // Solo cerrar esta activity, sin crear nueva MainActivity
        }
    }

    private fun applyTheme(isDarkMode: Boolean) {
        // Fondo y textos en negro siempre
        textViewProfileResult.setTextColor(Color.BLACK)  // Texto en negro
        setInputTextColor(Color.BLACK)  // Inputs y hints en negro

        if (isDarkMode) {
            // Fondo oscuro
            rootLayout.setBackgroundColor(Color.parseColor("#121212"))  // Fondo negro o gris oscuro
        } else {
            // Fondo con gradiente original
            rootLayout.setBackgroundResource(R.drawable.gradient_background)  // Fondo con gradiente
        }
    }

    private fun setInputTextColor(color: Int) {
        editTextName.setTextColor(color)
        editTextAge.setTextColor(color)
        editTextEmail.setTextColor(color)
        editTextName.setHintTextColor(color)
        editTextAge.setHintTextColor(color)
        editTextEmail.setHintTextColor(color)
    }

    private fun saveProfile() {
        val name = editTextName.text.toString().trim()
        val age = editTextAge.text.toString().trim()
        val email = editTextEmail.text.toString().trim()

        if (name.isEmpty() || age.isEmpty() || email.isEmpty()) {
            textViewProfileResult.text = "Completa todos los campos"
            return
        }

        sharedPreferencesHelper.saveString(SharedPreferencesHelper.KEY_PROFILE_NAME, name)
        sharedPreferencesHelper.saveInt(SharedPreferencesHelper.KEY_PROFILE_AGE, age.toInt())
        sharedPreferencesHelper.saveString(SharedPreferencesHelper.KEY_PROFILE_EMAIL, email)

        textViewProfileResult.text = "Perfil guardado exitosamente"

        editTextName.setText("")
        editTextAge.setText("")
        editTextEmail.setText("")
    }

    private fun loadProfile() {
        val name = sharedPreferencesHelper.getString(SharedPreferencesHelper.KEY_PROFILE_NAME, "Sin nombre")
        val age = sharedPreferencesHelper.getInt(SharedPreferencesHelper.KEY_PROFILE_AGE, 0)
        val email = sharedPreferencesHelper.getString(SharedPreferencesHelper.KEY_PROFILE_EMAIL, "Sin email")

        editTextName.setText(name)
        editTextAge.setText(if (age == 0) "" else age.toString())
        editTextEmail.setText(email)

        val profileText = """
            Perfil cargado:
            Nombre: $name
            Edad: $age
            Email: $email
        """.trimIndent()

        textViewProfileResult.text = profileText
    }
}
