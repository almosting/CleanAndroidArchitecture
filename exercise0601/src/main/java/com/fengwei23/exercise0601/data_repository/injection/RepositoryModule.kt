package com.fengwei23.exercise0601.data_repository.injection

import com.fengwei23.exercise0601.data_repository.repository.InteractionRepositoryImpl
import com.fengwei23.exercise0601.data_repository.repository.PostRepositoryImpl
import com.fengwei23.exercise0601.data_repository.repository.UserRepositoryImpl
import com.fengwei23.exercise0601.domain.repository.InteractionRepository
import com.fengwei23.exercise0601.domain.repository.PostRepository
import com.fengwei23.exercise0601.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindPostRepository(postRepositoryImpl: PostRepositoryImpl): PostRepository

    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindInteractionRepository(interactionRepositoryImpl: InteractionRepositoryImpl): InteractionRepository
}