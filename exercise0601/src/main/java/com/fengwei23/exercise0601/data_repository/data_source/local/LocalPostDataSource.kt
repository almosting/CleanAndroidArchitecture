package com.fengwei23.exercise0601.data_repository.data_source.local

import com.fengwei23.exercise0601.domain.entity.Post
import kotlinx.coroutines.flow.Flow

interface LocalPostDataSource {
    fun getPosts(): Flow<List<Post>>

    suspend fun addPosts(posts: List<Post>)
}