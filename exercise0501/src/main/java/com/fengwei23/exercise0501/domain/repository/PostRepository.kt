package com.fengwei23.exercise0501.domain.repository

import com.fengwei23.exercise0501.domain.entity.Post
import kotlinx.coroutines.flow.Flow


interface PostRepository {
    fun getPosts(): Flow<List<Post>>

    fun getPost(id: Long): Flow<Post>
}