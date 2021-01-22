package com.example.fragmentmangerkotlin

import com.example.fragmentmangerkotlin.base.BaseModel
import com.example.fragmentmangerkotlin.base.BasePresenter
import com.example.fragmentmangerkotlin.base.BaseView

class MainPresenter(mainActivity: MainActivity,model: MainModel) : BasePresenter() {

    val view : BaseView = mainActivity
    val model : BaseModel? = model

    override fun onCreate(){
        view.setContentView()
    }
}