package com.s.siloamtestapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.s.siloamtestapp.adapter.AdapterRecipeList
import com.s.siloamtestapp.databinding.ActivityMainBinding
import com.s.siloamtestapp.util.SharedPreferenceCredential
import com.s.siloamtestapp.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var recipeAdapter: AdapterRecipeList
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()


        binding.logout.setOnClickListener {
            val credential =SharedPreferenceCredential(this)

            credential.savePassword("")
            credential.saveUsername("")
            finish()
        }

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        binding.editText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                viewModel.getDataRecipe(p0.toString())
            }


        })

        viewModel.recipeData.observe(this, Observer { review ->

            if(review.isNullOrEmpty()){
                Toast.makeText(this,"Data tidak ditemukan",Toast.LENGTH_SHORT).show()
            }else{
                recipeAdapter.setData(review)
            }

        })

    }

    private fun prepareRecyclerView() {
        recipeAdapter = AdapterRecipeList()
        binding.rvMenu.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = recipeAdapter
        }
    }
}