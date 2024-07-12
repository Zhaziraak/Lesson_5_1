package com.example.lesson_5_1

import android.view.View
import android.widget.Toast

class CounterPresenter {

    private val model = CounterModel()
    private var view: CounterView? = null
    private var toast = Toast.makeText(this, "Поздравляем!", Toast.LENGTH_SHORT)

    fun incrementCount(){
        model.increment()
        view?.showCount(model.getResult())
    }

    fun decrementCount(){
        model.decrement()
        view?.showCount(model.getResult())
    }

    fun attachView(view:CounterView){
        this.view = view
        view?.showCount(model.getResult())
    }

    fun showToast(view: CounterView){
        if (view.toString() == "10"){
            toast.show()
        }
    }

    fun condition15 (){
        if (model.getResult() == "15"){
            view.changeTextColor()
        }
    }


}