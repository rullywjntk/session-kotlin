package com.rully.loginapp.data

import android.content.Context

internal class UserPreference(context: Context) {

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setUser(value: User) {
        val editor = preferences.edit()
        editor.putString(EMAIL, value.email)
        editor.putString(PASSWORD, value.password)
        editor.apply()
    }

    fun getUser(): User {
        val model = User()
        preferences.getString(EMAIL, "")
        preferences.getString(PASSWORD, "")

        return model
    }

    companion object {
        const val PREFS_NAME = "user_pref"
        const val EMAIL = "email"
        const val PASSWORD = "password"
    }

}