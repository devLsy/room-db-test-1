package com.lsy.roomdb_1.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lsy.roomdb_1.data.db.entity.UserEntity
import com.lsy.roomdb_1.ui.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun home(navController: NavController, viewModel: UserViewModel) {
    val userList by viewModel.allUsers.observeAsState(initial = emptyList())
    var searchQuery by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.getAllUsers()
    }
    Log.d("userList", "Fetched users: ${userList.joinToString()}")

    val filteredUsers = userList.filter { user ->
        user.name.contains(searchQuery, ignoreCase = true)
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            TopAppBar(
                title = { Text("홈 화면") },
                actions = {},
            )
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("이름으로 검색") }
            )
            LazyColumn {
                items(filteredUsers) { user ->
                    userRow(user)
                }
            }
        }
    }
}

@Composable
fun userRow(user: UserEntity) {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text(text = "이름: ${user.name}")
        Text(text = "나이: ${user.age}")
    }
}
