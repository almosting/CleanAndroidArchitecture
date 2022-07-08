package com.fengwei23.exercise0701.repository

import com.fengwei23.exercise0701.domain.entity.User
import com.fengwei23.exercise0701.domain.repository.UserRepository
import com.fengwei23.exercise0701.idling.ComposeCountingIdlingResource
import com.fengwei23.exercise0701.idling.attachIdling
import kotlinx.coroutines.flow.Flow

class IdlingUserRepository(
    private val userRepository: UserRepository,
    private val countingIdlingResource: ComposeCountingIdlingResource
) : UserRepository {
    override fun getUsers(): Flow<List<User>> =
        userRepository.getUsers()
            .attachIdling(countingIdlingResource)

    override fun getUser(id: Long): Flow<User> =
        userRepository.getUser(id)
            .attachIdling(countingIdlingResource)
}