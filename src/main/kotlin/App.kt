import io.reactivex.Observable
import io.reactivex.rxkotlin.blockingSubscribeBy
import io.reactivex.schedulers.Schedulers
import model.MovieSearchResponse
import network.ApiClient
import kotlin.system.exitProcess

private val apiService = ApiClient.getService()

fun main(args: Array<String>){

    val apiService = ApiClient.getService()
    apiService.searchMovie("Spiderman 3",
            "TMDB_API_KEY")
            .subscribe {
    searchMovie()
}

fun showOptions(){
    println()
    println("1.Search again \n2.Exit")
    print("Select an option: [1] - [2]: ")
    val response = readLine()?.toInt()
    when(response){
        1 -> searchMovie()
        2 -> exitProcess(1)
    }
    println()
}

fun searchMovie(){
    println()
    print("Enter a movie title to search: ")
    val title = readLine().toString()
    print("Loading, please wait...\n\n")
    getMovieDetails(title)
            .subscribeOn(Schedulers.io())
            .blockingSubscribeBy(
                    onNext = {
                        println("Title: ")
                        println(it.results[0].title)
                        println()
                        println("Overview: ")
                        println(it.results[0].overview)
                        println()
                        println("Release Date: ")
                        println(it.results[0].releaseDate)
                    },

                    onError = {
                        println("An unexpected error occurred: (${it.message})")
                    }
            )

    showOptions()

}
fun getMovieDetails(title: String): Observable<MovieSearchResponse>{
    return apiService.searchMovie(title,
            "TMDB_API_KEY")
}