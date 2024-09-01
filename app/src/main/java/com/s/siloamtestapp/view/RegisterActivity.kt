package com.s.siloamtestapp.view

import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.s.siloamtestapp.R
import com.s.siloamtestapp.Repository.RepoImplementations
import com.s.siloamtestapp.Repository.RepoInterfaces
import com.s.siloamtestapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repo = RepoImplementations(this)
        binding.register.setOnClickListener {

            var username = binding.username.text
            var address = binding.address.text
            var password = binding.password.text

            val encriptPassword = Base64.encodeToString(password.toString().toByteArray(), Base64.DEFAULT)



            if (username.isEmpty() || address.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Form tidak boleh kosong", Toast.LENGTH_SHORT).show()

            } else {


                if (repo.Contains(username.toString())) {
                    repo.addData("$username-$address-$encriptPassword")
                    Toast.makeText(this, "Data Berhasil Ditambah", Toast.LENGTH_SHORT).show()

                    binding.username.setText("")
                    binding.address.setText("")
                    binding.password.setText("")
                    Log.d("Data", repo.getData().toString())
                    finish()
                } else {
                    Toast.makeText(this, "Username telah terdaftar", Toast.LENGTH_SHORT).show()
                }

            }
        }


    }
}