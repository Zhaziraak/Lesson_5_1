package com.example.lesson_5_1
import android.graphics.Color

class CounterPresenter {

    private val model = CounterModel()
    private var view: CounterView? = null

    fun incrementCount() {
        model.increment()
        view?.showCount(model.getResult())
        checkConditions(model.getResult())
    }

    fun decrementCount() {
        model.decrement()
        view?.showCount(model.getResult())
        checkConditions(model.getResult())
    }

    fun attachView(view: CounterView) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

    private fun checkConditions(value: Int) {
        when (value) {
            10 -> view?.showToast("Поздравляем!")
            15 -> view?.changeTextColor(Color.GREEN)
            else -> view?.changeTextColor(Color.BLACK)
        }

    }
}