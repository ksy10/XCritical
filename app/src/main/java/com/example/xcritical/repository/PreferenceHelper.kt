package com.example.xcritical.repository

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceHelper @Inject constructor(@ApplicationContext context: Context) {
    private val KEY_SAVED_LOGIN = "SharedPreferenceDemo"

    private var settings: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null
    private var myContext: Context? = null

    init {
        myContext = context
    }

    private fun init() {
        settings = myContext?.getSharedPreferences(KEY_SAVED_LOGIN, Context.MODE_PRIVATE)
        editor = settings?.edit()
    }

    fun addProperty(key: String?, value: String?) {
        if (settings == null) {
            init()
        }
        editor?.putString(key, value)
        editor?.commit()
    }

    fun getProperty(key: String?): String? {
        if (settings == null) {
            init()
        }
        return settings?.getString(key, null)
    }

   /* private val preference: SharedPreferences

    init {
        preference = context.getSharedPreferences(KEY_SAVED_LOGIN, Context.MODE_PRIVATE)
    }

    fun setUserKey(userKey: String) {
        preference[USER_KEY] = userKey
    }

    fun getUserKey(): String {
        return preference[USER_KEY] ?: ""
    }

    fun setUserEmail(userEmail: String) {
        preference[USER_EMAIL] = userEmail
    }

    fun getUserEmail(): String {
        return preference[USER_EMAIL] ?: ""
    }

    fun setUserPassword(userPassword: String) {
        preference[USER_PASSWORD] = userPassword
    }

    fun getUserPassword(): String {
        return preference[USER_PASSWORD] ?: ""
    }

    fun clearPrefs() {
        preference.edit().clear().apply()
    }

    companion object {
        const val USER_KEY = "userKey"
        const val USER_EMAIL = "user_email"
        const val USER_PASSWORD = "user_password"
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }

    private operator fun SharedPreferences.set(key: String, value: Any?) {
        when (value) {
            is String? -> edit { it.putString(key, value) }
            is Int -> edit { it.putInt(key, value) }
            is Boolean -> edit { it.putBoolean(key, value) }
            is Float -> edit { it.putFloat(key, value) }
            is Long -> edit { it.putLong(key, value) }
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    private inline operator fun <reified T : Any> SharedPreferences.get(
        key: String,
        defaultValue: T? = null
    ): T? {
        return when (T::class) {
            String::class -> getString(key, defaultValue as? String) as T?
            Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
            Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
            Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
            Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }*/
}