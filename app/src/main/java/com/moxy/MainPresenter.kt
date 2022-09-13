package com.moxy

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    fun initPresenter() {
        val list: List<String> = arrayListOf("name", "email", "phone", "profession")
        viewState.loadMessage("Hello World Moxy!!!")
        viewState.loadData(list)
    }
}
