package com.rully.loginapp.data

import android.content.Context

internal class UserPreference(context: Context) {

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setUser(value: User) {
        val editor = preferences.edit()
        editor.putString(EMAIL, value.email)
        editor.putString(PASSWORD, value.password)
        editor.putBoolean(IS_LOGIN, value.isLogin)
        editor.apply()
    }

    fun getUser(): User {
        val model = User()
        model.email = preferences.getString(EMAIL, "")
        model.password = preferences.getString(PASSWORD, "")
        model.isLogin = preferences.getBoolean(IS_LOGIN, false)

        return model
    }

    companion object {
        const val PREFS_NAME = "user_pref"
        const val EMAIL = "email"
        const val PASSWORD = "password"
        const val IS_LOGIN = "is_login"
    }

}