package com.example.app_s9

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    companion object {
        private const val PREF_NAME = "AppS9Preferences"

        // Claves generales
        const val KEY_USERNAME = "username"
        const val KEY_IS_FIRST_TIME = "is_first_time"
        const val KEY_USER_ID = "user_id"
        const val KEY_VISIT_COUNT = "visit_count"
        const val KEY_THEME_MODE = "theme_mode"

        // Claves perfil de usuario
        const val KEY_PROFILE_NAME = "profile_name"
        const val KEY_PROFILE_AGE = "profile_age"
        const val KEY_PROFILE_EMAIL = "profile_email"
    }

    fun saveString(key: String, value: String) {
        editor.putString(key, value).apply()
    }

    fun getString(key: String, defaultValue: String = ""): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun saveBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value).apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun saveInt(key: String, value: Int) {
        editor.putInt(key, value).apply()
    }

    fun getInt(key: String, defaultValue: Int = 0): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun saveFloat(key: String, value: Float) {
        editor.putFloat(key, value).apply()
    }

    fun getFloat(key: String, defaultValue: Float = 0f): Float {
        return sharedPreferences.getFloat(key, defaultValue)
    }

    fun saveLong(key: String, value: Long) {
        editor.putLong(key, value).apply()
    }

    fun getLong(key: String, defaultValue: Long = 0L): Long {
        return sharedPreferences.getLong(key, defaultValue)
    }

    fun remove(key: String) {
        editor.remove(key).apply()
    }

    fun clearAll() {
        editor.clear().apply()
    }

    fun contains(key: String): Boolean {
        return sharedPreferences.contains(key)
    }
}
