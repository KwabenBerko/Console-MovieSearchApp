package network

import retrofit2.Retrofit

class ApiClient {

    companion object {

        private fun getRetrofit(): Retrofit{
            return Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org")
                    .build()

        }

        fun getService(): ApiService{
            return getRetrofit().create(ApiService::class.java)
        }
    }
}