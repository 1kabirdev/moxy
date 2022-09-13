package com.moxy

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.arellomobile.mvp.MvpActivity
import com.arellomobile.mvp.MvpDelegate
import com.arellomobile.mvp.presenter.InjectPresenter
import com.moxy.databinding.ActivityMainBinding
import com.moxy.moshi.MoshiActivity

class MainActivity : MvpActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter
    private var mvpDelegate: MvpDelegate<out MainActivity>? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getMvpDelegate().onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.initPresenter()
    }

    override fun loadMessage(message: String) {
        with(binding) {
            helloWorldTextView.text = message

            clickMoshi.setOnClickListener {
                startActivity(Intent(this@MainActivity, MoshiActivity::class.java))
            }
        }
    }

    override fun loadData(list: List<String>) {
        for (i in list) {
            Log.d("LIST", i)
        }
    }

    override fun onStart() {
        super.onStart()
        getMvpDelegate().onAttach()
    }

    override fun onResume() {
        super.onResume()
        getMvpDelegate().onAttach()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        getMvpDelegate().onSaveInstanceState(outState)
        getMvpDelegate().onDetach()
    }

    override fun onStop() {
        super.onStop()
        getMvpDelegate().onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
        getMvpDelegate().onDestroyView()
        if (isFinishing) {
            getMvpDelegate().onDestroy()
        }
    }


    override fun getMvpDelegate(): MvpDelegate<*> {
        if (mvpDelegate == null) {
            mvpDelegate = MvpDelegate(this)
        }
        return mvpDelegate!!
    }
}