package com.lsy.roomdb_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lsy.roomdb_1.data.db.AppDatabase
import com.lsy.roomdb_1.data.db.repository.UserRepository
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
                UserScreen(userViewModel)
            }
        }
    }
}


