package com.example.android_archives

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_archives.adapter.DishItemAdapter
import com.example.android_archives.databinding.ActivityMainBinding
import com.example.android_archives.listeners.DishQuantityListener
import com.example.android_archives.model.DishModel
import com.example.android_archives.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private val dishQuantityListener = object : DishQuantityListener {
        override fun onDecrementClick(data: DishModel, position: Int) {
            viewModel.decrementQuantity(data, position)
        }

        override fun onIncrementClick(data: DishModel, position: Int) {
            viewModel.incrementQuantity(data, position)
        }

    }

    private val dishItemAdapter by lazy { DishItemAdapter(dishQuantityListener) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        observeViewModelData()
    }

    private fun initViews() {
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.recyclerDishList.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerDishList.adapter = dishItemAdapter
    }

    private fun observeViewModelData() {
        viewModel.data.observe(this) {
            dishItemAdapter.submitList(it)
        }
    }
}