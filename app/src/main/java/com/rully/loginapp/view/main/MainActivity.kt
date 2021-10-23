package com.rully.loginapp.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.rully.loginapp.R
import com.rully.loginapp.data.UserPreference
import com.rully.loginapp.databinding.ActivityMainBinding
import com.rully.loginapp.view.login.LoginActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userPreference: UserPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userPreference = UserPreference(this)
        binding.btnLogout.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        userPreference.clearUser()
        Toast.makeText(this, "Logout Berhasil", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}