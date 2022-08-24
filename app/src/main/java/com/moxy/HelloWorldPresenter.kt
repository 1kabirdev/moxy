package com.moxy

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class HelloWorldPresenter : MvpPresenter<HelloWorldView>() {

    fun helloWorldPresenter(){
        viewState.loadMessage("Hello World Kabir Agamirzaev")
    }

}
