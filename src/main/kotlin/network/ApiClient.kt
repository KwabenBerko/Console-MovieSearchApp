package network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiClient {

    companion object {

        private fun getRetrofit(): Retrofit{
            return Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()

        }

        fun getService(): ApiService{
            return getRetrofit().create(ApiService::class.java)
        }
    }
}