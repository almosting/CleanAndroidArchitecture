package com.fengwei23.exercise0701.data_repository.data_source.local

import com.fengwei23.exercise0701.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface LocalUserDataSource {
    fun getUsers(): Flow<List<User>>

    suspend fun addUsers(users: List<User>)
}