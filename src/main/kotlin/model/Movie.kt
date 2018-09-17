package model

import com.squareup.moshi.Json

data class Movie(
        private val id: Int,
        private val title: String,
        private val overview: String,

        @Json(name = "release_date")
        private val releaseDate: String
)