package com.example.lifecycleapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.lifecycleapp.dao.UserRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    private val repo = UserRepository()

    /**
     * using this Interface 'LiveDataScope<T>' generates Coroutine-block
     * that controls live-data directly.
     */
    val users = liveData(Dispatchers.IO) {
        emit(repo.getUsers())
    }

}