package com.moxy

import com.arellomobile.mvp.MvpView

interface MainView : MvpView {
    fun loadMessage(message: String)
    fun loadData(list: List<String>)
}
