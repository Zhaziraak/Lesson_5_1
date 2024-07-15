package com.example.lesson_5_1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

    override fun showCount(count: Int) {
        binding.tvResult.text = count.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeTextColor(color: Int) {
        binding.tvResult.setTextColor(color)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}