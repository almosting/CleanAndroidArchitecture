package com.fengwei23.exercise0701.repository

import com.fengwei23.exercise0701.domain.entity.Post
import com.fengwei23.exercise0701.domain.repository.PostRepository
import com.fengwei23.exercise0701.idling.ComposeCountingIdlingResource
import com.fengwei23.exercise0701.idling.attachIdling
import kotlinx.coroutines.flow.Flow

class IdlingPostRepository(
    private val postRepository: PostRepository,
    private val countingIdlingResource: ComposeCountingIdlingResource
) : PostRepository {
    override fun getPosts(): Flow<List<Post>> =
        postRepository.getPosts().attachIdling(countingIdlingResource)

    override fun getPost(id: Long): Flow<Post> =
        postRepository.getPost(id).attachIdling(countingIdlingResource)
}