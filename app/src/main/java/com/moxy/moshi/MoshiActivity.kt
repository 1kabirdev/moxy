package com.moxy.moshi

import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.MvpActivity
import com.moxy.R
import com.moxy.databinding.ActivityMoshiBinding
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class MoshiActivity : MvpActivity() {

    private lateinit var binding: ActivityMoshiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoshiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()


        retrofit.create(ApiService::class.java).getSinglePost().enqueue(object :
            Callback<PostsResponse> {

            override fun onResponse(call: Call<PostsResponse>, response: Response<PostsResponse>) {
                response.body()?.let { data ->
                    with(binding) {
                        title.text = data.title
                    }
                }
            }

            override fun onFailure(call: Call<PostsResponse>, t: Throwable) = Unit
        })
    }

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
}

interface ApiService {
    @GET("/posts/1")
    fun getSinglePost(): Call<PostsResponse>
}