package com.example.lesson_5_1

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lesson_5_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)

    }

    private val presenter by lazy { CounterPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.attachView(this)

        binding.btnIncrement.setOnClickListener {
            presenter.incrementCount()
        }
        binding.btnDecrement.setOnClickListener {
            presenter.decrementCount()
        }
    }

    override fun showCount(count: String) {
        binding.tvResult.text = count
    }

    fun changeTextColor() {
        binding.tvResult.setTextColor(Color.GREEN)
    }
}