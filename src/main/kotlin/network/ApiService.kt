package network

import io.reactivex.Observable
import model.Movie
import model.MovieSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/3/search/movie")
    fun searchMovie(@Query("query") title: String,
                    @Query("api_key") apiKey: String): Observable<MovieSearchResponse>

}