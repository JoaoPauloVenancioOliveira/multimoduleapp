package com.core.network.dataproviders

import com.core.network.ApiService
import javax.inject.Inject

class MovieDataSource @Inject constructor(
    private val apiService: ApiService
){
    suspend fun getMovieList(apikey: String, query: String) = apiService.getMovieList(apikey, query)

    suspend fun getMovieDetails(id:String, apikey: String) = apiService.getMovieDetails(id, apikey)
}