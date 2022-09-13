package com.moxy.moshi

import com.squareup.moshi.Json

data class PostsResponse(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "title")
    val title: String = "",
    @Json(name = "body")
    val body: String = "",
    @Json(name = "userId")
    val userId: Int = 0
)
