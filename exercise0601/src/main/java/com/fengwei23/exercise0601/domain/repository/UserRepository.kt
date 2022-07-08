package com.fengwei23.exercise0601.domain.repository

import com.fengwei23.exercise0601.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<User>>

    fun getUser(id: Long): Flow<User>
}