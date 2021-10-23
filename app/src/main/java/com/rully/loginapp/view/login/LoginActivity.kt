package com.rully.loginapp.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.rully.loginapp.R
import com.rully.loginapp.data.User
import com.rully.loginapp.data.UserPreference
import com.rully.loginapp.databinding.ActivityLoginBinding
import com.rully.loginapp.view.main.MainActivity

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var userPreference: UserPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userPreference = UserPreference(this)

        binding.btnLogin.setOnClickListener(this)

    }

    override fun onStart() {
        super.onStart()
        if (userPreference.getUser().isLogin) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btnLogin) {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.etEmail.error = FIELD_REQUIRED
                return
            }

            if (!isValidEmail(email)) {
                binding.etEmail.error = FIELD_IS_NOT_VALID
                return
            }

            if (password.isEmpty()) {
                binding.etPassword.error = FIELD_REQUIRED
                return
            }

            saveUser(email, password)
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }
    }

    private fun saveUser(email: String, password: String) {
        val userPreference = UserPreference(this)
        val user = User()

        user.email = email
        user.password = password
        user.isLogin = true

        userPreference.setUser(user)
        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()

    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    companion object {
        const val FIELD_REQUIRED = "Field tidak boleh kosong"
        const val FIELD_IS_NOT_VALID = "Email tidak valid"
    }
}