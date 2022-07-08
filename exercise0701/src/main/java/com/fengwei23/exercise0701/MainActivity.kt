package com.fengwei23.exercise0701

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fengwei23.exercise0701.presentation_common.navigation.NavRoutes
import com.fengwei23.exercise0701.presentation_post.list.PostListScreen
import com.fengwei23.exercise0701.presentation_post.single.PostScreen
import com.fengwei23.exercise0701.presentation_user.single.UserScreen
import com.fengwei23.exercise0701.ui.theme.CleanAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    App(navController = navController)
                }
            }
        }
    }
}

@Composable
fun App(navController: NavHostController) {
    NavHost(navController, startDestination = NavRoutes.Posts.route) {
        composable(route = NavRoutes.Posts.route) {
            PostListScreen(hiltViewModel(), navController)
        }
        composable(
            route = NavRoutes.Post.route,
            arguments = NavRoutes.Post.arguments
        ) {
            PostScreen(
                hiltViewModel(),
                NavRoutes.Post.fromEntry(it)
            )
        }
        composable(
            route = NavRoutes.User.route,
            arguments = NavRoutes.User.arguments
        ) {
            UserScreen(
                hiltViewModel(),
                NavRoutes.User.fromEntry(it)
            )
        }
    }
}