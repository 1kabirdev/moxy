package com.moxy

import android.os.Bundle
import android.widget.TextView
import com.arellomobile.mvp.MvpActivity
import com.arellomobile.mvp.presenter.InjectPresenter

class MainActivity : MvpActivity(), HelloWorldView {

    @InjectPresenter
    lateinit var mHelloWorldPresenter: HelloWorldPresenter

    private var helloWorldTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloWorldTextView = findViewById(R.id.helloWorldTextView)

        mHelloWorldPresenter.helloWorldPresenter()

    }

    override fun loadMessage(message: String) {
        helloWorldTextView!!.text = message
    }
}