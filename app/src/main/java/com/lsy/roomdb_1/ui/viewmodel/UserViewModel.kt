package com.lsy.roomdb_1.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lsy.roomdb_1.data.db.entity.UserEntity
import com.lsy.roomdb_1.data.db.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository): ViewModel() {

    private val _allUsers = MutableLiveData<List<UserEntity>>()
    val allUsers: LiveData<List<UserEntity>> get() = _allUsers

    fun getAllUsers() {
        viewModelScope.launch {
            _allUsers.value = repository.getAllUsers()
        }
    }

    fun insert(user: UserEntity) {
        viewModelScope.launch {
            repository.insert(user)
        }
    }

    fun update(user: UserEntity) {
        viewModelScope.launch {
            repository.update(user)
        }
    }

    fun delete(user: UserEntity) {
        viewModelScope.launch {
            repository.delete(user)
        }
    }
}