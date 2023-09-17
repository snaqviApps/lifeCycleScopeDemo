package ghar.learn.lifecycleapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ghar.learn.lifecycleapp.dao.UserRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    private val repo = UserRepository()

    /**
     * using this Interface 'LiveDataScope<T>' generates Coroutine-block
     * that controls live-data directly.
     *
     * @'getUsers()' is a suspended function
     */
    val users = liveData(Dispatchers.IO) {
        emit(repo.getUsers())
    }

}