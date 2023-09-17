package ghar.learn.lifecycleapp.dao

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers() : List<User> {
        delay(5000)
        return listOf(
            User(5, "U5"),
            User(50, "U50"),
            User(500, "U500"),
            User(5000, "U5000"),
            User(5100, "U5100")
        )
    }
}