import com.squareup.moshi.Moshi
import network.ApiClient

fun main(args: Array<String>){
    val apiService = ApiClient.getService()
    apiService.searchMovie("Spiderman 3",
            "TMDB_API_KEY")
            .subscribe {

            }
}