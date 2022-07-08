package com.fengwei23.exercise0601.data_repository.data_source.remote

import com.fengwei23.exercise0601.domain.entity.Post
import kotlinx.coroutines.flow.Flow

interface RemotePostDataSource {
    fun getPosts(): Flow<List<Post>>

    fun getPost(id: Long): Flow<Post>
}