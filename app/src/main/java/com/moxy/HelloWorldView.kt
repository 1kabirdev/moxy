package com.moxy

import com.arellomobile.mvp.MvpView

interface HelloWorldView : MvpView {
    fun loadMessage(message: String)
}
