package com.s.siloamtestapp.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.s.siloamtestapp.R
import com.s.siloamtestapp.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.title.text = intent.getStringExtra("title")
        Picasso.get().load(intent.getStringExtra("image")).into(binding.image)
        binding.instruction.text= intent.getStringExtra("instructor")
        binding.ing1.text = intent.getStringExtra("ingredient1")
        binding.ing2.text = intent.getStringExtra("ingredient2")
        binding.ing3.text = intent.getStringExtra("ingredient3")
        binding.ing4.text = intent.getStringExtra("ingredient4")
        binding.ing5.text = intent.getStringExtra("ingredient5")
        binding.ing6.text = intent.getStringExtra("ingredient6")
        binding.ing7.text = intent.getStringExtra("ingredient7")
        binding.ing8.text = intent.getStringExtra("ingredient8")

    }
}