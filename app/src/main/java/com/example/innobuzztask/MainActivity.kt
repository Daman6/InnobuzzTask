package com.example.innobuzztask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.innobuzztask.databinding.ActivityMainBinding
import com.example.innobuzztask.db.ResponseDatabse
import com.example.innobuzztask.repo.DataRepo
import com.example.innobuzztask.viewModel.DataViewModel
import com.example.innobuzztask.viewModel.DataViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewmodel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
//        val navController = navHostFragment.navController


        val repo = DataRepo(ResponseDatabse(this))
        val viewModelProviderFactory = DataViewModelProviderFactory(repo)

        viewmodel  = ViewModelProvider(this,viewModelProviderFactory).get(DataViewModel::class.java)
    }
}