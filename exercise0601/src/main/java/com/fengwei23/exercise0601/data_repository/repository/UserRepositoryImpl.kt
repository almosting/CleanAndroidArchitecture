package com.fengwei23.exercise0601.data_repository.repository

import com.fengwei23.exercise0601.data_repository.data_source.local.LocalUserDataSource
import com.fengwei23.exercise0601.data_repository.data_source.remote.RemoteUserDataSource
import com.fengwei23.exercise0601.domain.entity.User
import com.fengwei23.exercise0601.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteUserDataSource: RemoteUserDataSource,
    private val localUserDataSource: LocalUserDataSource
) : UserRepository {
    override fun getUsers(): Flow<List<User>> = remoteUserDataSource.getUsers().onEach {
        localUserDataSource.addUsers(it)
    }

    override fun getUser(id: Long): Flow<User> = remoteUserDataSource.getUser(id).onEach {
        localUserDataSource.addUsers(listOf(it))
    }
}