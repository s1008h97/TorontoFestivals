package com.toronto.festivals.jk.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.toronto.festivals.jk.R
import com.toronto.festivals.jk.databinding.ActivityMainBinding
import com.toronto.festivals.jk.viewmodel.FestivalsViewModel
import com.toronto.festivals.jk.viewmodel.factory.FestivalsViewModelFactory

class FestivalsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: FestivalsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpViewModel()
        setUpListeners()
    }

    private fun setUpViewModel() {
        viewModel =
            ViewModelProvider(this, FestivalsViewModelFactory()).get(FestivalsViewModel::class.java)
        viewModel.liveData.observe(this, Observer {
            binding.btnTest.text = it.toString()
        })
    }

    private fun setUpListeners() {
        binding.btnTest.setOnClickListener {
            viewModel.increment("Clicked the button!")
        }
    }
}
