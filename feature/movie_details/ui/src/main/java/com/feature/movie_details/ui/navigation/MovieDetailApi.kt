package com.feature.movie_details.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.core.feature_api.FeatureApi

interface MovieDetailApi: FeatureApi {}

class MovieDetailApiImpl: MovieDetailApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalMovieDetailApi.registerGraph(navController, navGraphBuilder)
    }
}