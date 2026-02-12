package com.example.datalayerpractice

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.datalayerpractice.dao.CoffeeDataSource
import com.example.datalayerpractice.databinding.ActivityMainBinding
import com.example.datalayerpractice.reciever.AirplaneModeReciever
import com.example.datalayerpractice.repository.CoffeeRepository
import com.example.datalayerpractice.services.MyFirstService
import com.example.datalayerpractice.viewmodel.CoffeeViewModel
import com.example.datalayerpractice.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: UserViewModel by viewModels()
    private val receiver = AirplaneModeReciever()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coffeeViewModel = CoffeeViewModel(CoffeeRepository(CoffeeDataSource()))
        coffeeViewModel.orderCoffee()
        lifecycleScope.launch {
            binding.tvUsername.text = coffeeViewModel._coffeeName
            binding.tvEmail.text = coffeeViewModel._price
        }

//        val userid = 1
//        viewModel.getUser(userid).observe(this, Observer{ user ->
//            binding.tvUsername.text = user.name
//            binding.tvEmail.text = user.email
//        })
//
//        val intent = Intent(this, MyFirstService::class.java)
//        startService(intent)
//
//        binding.submit.setOnClickListener {
//            stopService(intent)
//        }
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(receiver, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }

}