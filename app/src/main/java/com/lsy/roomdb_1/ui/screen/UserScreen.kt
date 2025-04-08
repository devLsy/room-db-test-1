package com.lsy.roomdb_1.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.lsy.roomdb_1.data.db.entity.UserEntity
import com.lsy.roomdb_1.ui.viewmodel.UserViewModel

@Composable
fun UserScreen(viewModel: UserViewModel) {

    val users by viewModel.allUsers.observeAsState(emptyList())
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    var selectedUser by remember { mutableStateOf<UserEntity?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("이름") }, modifier = Modifier.fillMaxWidth())
        TextField(value = age, onValueChange = { age = it }, label = { Text("나이") }, keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number), modifier = Modifier.fillMaxWidth() )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                if(name.isNotBlank() && age.isNotBlank()) {
                    viewModel.insert(UserEntity(name = name, age = age.toInt()))
                    name = ""
                    age = ""
                    viewModel.getAllUsers()
                }
            }) {
                Text("추가")
            }
        }
    }

}