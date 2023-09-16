package com.example.lifecycleapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifecycleapp.dao.User
import com.example.lifecycleapp.dao.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val repo = UserRepository()
    private val _users = MutableLiveData<List<User>?>()
    val users : MutableLiveData<List<User>?> = _users          // user is backing-field

    init {
        getUsers()
    }

    private fun getUsers(){
        viewModelScope.launch {
            var result : List<User>?
            withContext(Dispatchers.IO){    // switching to background (worker) thread
                result = repo.getUsers()
            }
            _users.value = result
        }
    }
}