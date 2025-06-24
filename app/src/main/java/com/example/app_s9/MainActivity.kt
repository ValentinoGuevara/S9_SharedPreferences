package com.example.app_s9

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    private lateinit var editTextUsername: TextInputEditText
    private lateinit var editTextEmail: TextInputEditText
    private lateinit var buttonSave: MaterialButton
    private lateinit var buttonLoad: MaterialButton
    private lateinit var buttonClear: MaterialButton
    private lateinit var buttonResetCounter: MaterialButton
    private lateinit var buttonOpenProfile: MaterialButton
    private lateinit var switchDarkMode: SwitchMaterial
    private lateinit var textViewTitle: TextView
    private lateinit var textViewVisitsCount: TextView
    private lateinit var textViewLastActivity: TextView
    private lateinit var profileProgress: LinearProgressIndicator
    private lateinit var rootLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        sharedPreferencesHelper = SharedPreferencesHelper(this)

        initViews()
        setupListeners()

        val isDarkMode = sharedPreferencesHelper.getBoolean(SharedPreferencesHelper.KEY_THEME_MODE, false)
        switchDarkMode.isChecked = isDarkMode
        applyTheme(isDarkMode)

        checkFirstTime()
        incrementVisitCount()
    }

    private fun initViews() {
        rootLayout = findViewById(R.id.main)
        editTextUsername = findViewById(R.id.editTextUsername)
        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSave = findViewById(R.id.buttonSave)
        buttonLoad = findViewById(R.id.buttonLoad)
        buttonClear = findViewById(R.id.buttonClear)
        buttonResetCounter = findViewById(R.id.buttonResetCounter)
        buttonOpenProfile = findViewById(R.id.buttonOpenProfile)
        switchDarkMode = findViewById(R.id.switchDarkMode)
        textViewTitle = findViewById(R.id.textViewTitle)
        textViewVisitsCount = findViewById(R.id.textViewVisitsCount)
        textViewLastActivity = findViewById(R.id.textViewLastActivity)
        profileProgress = findViewById(R.id.profileProgress)
    }

    private fun setupListeners() {
        buttonSave.setOnClickListener { saveData() }
        buttonLoad.setOnClickListener { loadData() }
        buttonClear.setOnClickListener { clearAllData() }
        buttonResetCounter.setOnClickListener { resetVisitCount() }
        buttonOpenProfile.setOnClickListener {
            startActivity(Intent(this, UserProfileActivity::class.java))
        }
        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferencesHelper.saveBoolean(SharedPreferencesHelper.KEY_THEME_MODE, isChecked)
            applyTheme(isChecked)
        }
    }

    private fun applyTheme(isDarkMode: Boolean) {
        if (isDarkMode) {
            // Fondo oscuro
            rootLayout.setBackgroundColor(Color.parseColor("#121212"))  // Fondo negro o gris oscuro
        } else {
            // Fondo original (gradiente)
            rootLayout.setBackgroundResource(R.drawable.gradient_background)  // Fondo con gradiente
        }
    }

    private fun saveData() {
        val username = editTextUsername.text.toString().trim()
        val email = editTextEmail.text.toString().trim()

        if (username.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Por favor completa los campos", Toast.LENGTH_SHORT).show()
            return
        }

        sharedPreferencesHelper.saveString(SharedPreferencesHelper.KEY_USERNAME, username)
        sharedPreferencesHelper.saveString(SharedPreferencesHelper.KEY_PROFILE_EMAIL, email)
        sharedPreferencesHelper.saveBoolean(SharedPreferencesHelper.KEY_IS_FIRST_TIME, false)
        sharedPreferencesHelper.saveInt(SharedPreferencesHelper.KEY_USER_ID, (1000..9999).random())

        Toast.makeText(this, "Datos guardados exitosamente", Toast.LENGTH_SHORT).show()
        updateProfileProgress(100)
    }

    private fun loadData() {
        val username = sharedPreferencesHelper.getString(SharedPreferencesHelper.KEY_USERNAME, "Sin nombre")
        val email = sharedPreferencesHelper.getString(SharedPreferencesHelper.KEY_PROFILE_EMAIL, "Sin email")
        val userId = sharedPreferencesHelper.getInt(SharedPreferencesHelper.KEY_USER_ID, 0)

        val message = """
            Usuario: $username
            ID: $userId
            Email: $email
        """.trimIndent()

        AlertDialog.Builder(this)
            .setTitle("Datos del usuario")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }

    private fun clearAllData() {
        sharedPreferencesHelper.clearAll()
        editTextUsername.setText("")
        editTextEmail.setText("")
        textViewVisitsCount.text = "0"
        textViewLastActivity.text = "-"
        profileProgress.progress = 0
        Toast.makeText(this, "Preferencias eliminadas", Toast.LENGTH_SHORT).show()
    }

    private fun incrementVisitCount() {
        val current = sharedPreferencesHelper.getInt(SharedPreferencesHelper.KEY_VISIT_COUNT, 0)
        val newCount = current + 1
        sharedPreferencesHelper.saveInt(SharedPreferencesHelper.KEY_VISIT_COUNT, newCount)
        textViewVisitsCount.text = newCount.toString()
        textViewLastActivity.text = "Hoy"
    }

    private fun resetVisitCount() {
        sharedPreferencesHelper.saveInt(SharedPreferencesHelper.KEY_VISIT_COUNT, 0)
        textViewVisitsCount.text = "0"
        Toast.makeText(this, "Contador reseteado", Toast.LENGTH_SHORT).show()
    }

    private fun checkFirstTime() {
        val isFirst = sharedPreferencesHelper.getBoolean(SharedPreferencesHelper.KEY_IS_FIRST_TIME, true)
        if (isFirst) {
            Toast.makeText(this, "¡Bienvenido por primera vez!", Toast.LENGTH_LONG).show()
        }
    }

    private fun updateProfileProgress(percent: Int) {
        profileProgress.progress = percent
    }
}
