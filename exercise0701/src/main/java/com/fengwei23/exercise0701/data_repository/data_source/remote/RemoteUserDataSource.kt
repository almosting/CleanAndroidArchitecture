package com.fengwei23.exercise0701.data_repository.data_source.remote

import com.fengwei23.exercise0701.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface RemoteUserDataSource {
    fun getUsers(): Flow<List<User>>

    fun getUser(id: Long): Flow<User>
}