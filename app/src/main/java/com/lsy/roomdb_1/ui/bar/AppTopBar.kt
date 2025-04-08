package com.lsy.roomdb_1.ui.bar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.lsy.roomdb_1.model.NavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(menuItems: List<NavigationItem>, navController: NavHostController) {

    TopAppBar(
        title = {}, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF00B0B9)),
        actions = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                menuItems.forEach {  nav -> val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable { navController.navigate(nav.route) }) {
                        val isCurrentRoute = nav.route == currentRoute
                        Text(text = nav.title, color = Color.White, fontWeight = FontWeight.Bold, style = TextStyle(shadow = Shadow(color = Color.Gray, offset = Offset(2f, 2f), blurRadius = 4f)))
                    }
                }
            }
        }
    )
}


