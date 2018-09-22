package model

import com.squareup.moshi.Json

data class Movie(
        val id: Int,
        val title: String,
        val overview: String,

        @field:Json(name = "release_date")
        val releaseDate: String
)