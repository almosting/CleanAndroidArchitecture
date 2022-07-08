package com.fengwei23.exercise0501.domain.usecase

import com.fengwei23.exercise0501.domain.entity.Post
import com.fengwei23.exercise0501.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPostUseCase @Inject constructor(
    configuration: Configuration,
    private val postRepository: PostRepository
) : UseCase<GetPostUseCase.Request, GetPostUseCase.Response>(configuration) {


    data class Request(val postId: Long) : UseCase.Request
    data class Response(val post: Post) : UseCase.Response

    override fun process(request: Request): Flow<Response> =
        postRepository.getPost(request.postId).map {
            Response(it)
        }
}