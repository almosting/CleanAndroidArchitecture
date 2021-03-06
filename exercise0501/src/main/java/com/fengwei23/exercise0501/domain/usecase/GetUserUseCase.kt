package com.fengwei23.exercise0501.domain.usecase

import com.fengwei23.exercise0501.domain.entity.User
import com.fengwei23.exercise0501.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    configuration: Configuration,
    private val userRepository: UserRepository
) : UseCase<GetUserUseCase.Request, GetUserUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        userRepository.getUser(request.userId)
            .map {
                Response(it)
            }

    data class Request(val userId: Long) : UseCase.Request
    data class Response(val user: User) : UseCase.Response
}