package com.lsy.roomdb_1.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lsy.roomdb_1.ui.screen.home
import com.lsy.roomdb_1.ui.viewmodel.UserViewModel

@Composable
fun NavGrapth(navController: NavHostController, userViewModel: UserViewModel) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { home(navController = navController, viewModel = userViewModel)  }
    }
}