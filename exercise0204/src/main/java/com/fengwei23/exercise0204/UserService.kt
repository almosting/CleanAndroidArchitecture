package com.fengwei23.exercise0204

import retrofit2.http.GET

interface UserService {
    @GET("/users")
    suspend fun getUsers(): List<User>
}