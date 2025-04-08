package com.lsy.roomdb_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.lsy.roomdb_1.data.db.AppDatabase
import com.lsy.roomdb_1.data.db.repository.UserRepository
import com.lsy.roomdb_1.model.NavigationItem
import com.lsy.roomdb_1.ui.bar.AppTopBar
import com.lsy.roomdb_1.ui.nav.NavGrapth
import com.lsy.roomdb_1.ui.screen.UserScreen
import com.lsy.roomdb_1.ui.theme.RoomDB1Theme
import com.lsy.roomdb_1.ui.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = AppDatabase.getDatabase(this)
        val repository = UserRepository(database.userDao())
        val userViewModel = UserViewModel(repository)

        setContent {
            RoomDB1Theme {
                appMain()
            }
        }
    }
}

@Composable
fun appMain() {
    val navController = rememberNavController()
    val menuItems = listOf(NavigationItem("홈", "home"), NavigationItem("등록", "bucketList"), NavigationItem("상세", "routine"))
    Scaffold(topBar = { AppTopBar(menuItems, navController) }, content = { paddingValues -> Box(modifier = Modifier.fillMaxSize().padding(paddingValues), contentAlignment = Alignment.Center) { NavGrapth(navController) } })
}


