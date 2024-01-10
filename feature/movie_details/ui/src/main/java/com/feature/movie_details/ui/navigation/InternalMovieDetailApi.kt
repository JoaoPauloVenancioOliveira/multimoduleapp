package com.feature.movie_details.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.navigation_constant.MovieDetailsFeature
import com.core.feature_api.FeatureApi
import com.feature.movie_details.ui.screen.MovieDetailViewModel
import com.feature.movie_details.ui.screen.MovieDetailsScreen

object InternalMovieDetailApi : FeatureApi {

    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            route = MovieDetailsFeature.nestedRoute,
            startDestination = MovieDetailsFeature.movieDetailScreenRoute
        ) {
            composable(MovieDetailsFeature.movieDetailScreenRoute) {
                val id = it.arguments?.getString("id")
                val viewModel = hiltViewModel<MovieDetailViewModel>()
                MovieDetailsScreen(id = id.toString(), viewModel = viewModel)
            }
        }
    }

}