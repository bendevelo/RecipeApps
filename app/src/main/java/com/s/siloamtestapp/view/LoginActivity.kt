package com.s.siloamtestapp.view

import android.content.Intent
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.s.siloamtestapp.MainActivity
import com.s.siloamtestapp.R
import com.s.siloamtestapp.Repository.RepoImplementations
import com.s.siloamtestapp.databinding.ActivityLoginBinding
import com.s.siloamtestapp.util.SharedPreferenceCredential

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //repo for data user
        val repo = RepoImplementations(this)
        // repo for credential
        val credential = SharedPreferenceCredential(this)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.regis.setOnClickListener {
            var intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.login.setOnClickListener {

            val encriptPassword = " " + Base64.encodeToString(
                binding.password.text.toString().toByteArray(),
                Base64.DEFAULT
            )

            if (repo.Contains(binding.username.text.toString())) {
                Toast.makeText(this, "Username Salah", Toast.LENGTH_SHORT).show()
            } else {
             val index= repo.getData().indexOf(binding.username.text.toString())
                if (repo.getData()[index+2].trim() == encriptPassword.trim()){

                    credential.saveUsername(binding.username.text.toString())
                    credential.savePassword(encriptPassword)

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this, "Password Salah", Toast.LENGTH_SHORT).show()
                }

            }

        }


    }
}