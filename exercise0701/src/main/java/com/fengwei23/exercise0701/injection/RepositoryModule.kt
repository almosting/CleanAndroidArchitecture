package com.fengwei23.exercise0701.injection

import com.fengwei23.exercise0701.data_repository.data_source.local.LocalInteractionDataSource
import com.fengwei23.exercise0701.data_repository.data_source.local.LocalPostDataSource
import com.fengwei23.exercise0701.data_repository.data_source.local.LocalUserDataSource
import com.fengwei23.exercise0701.data_repository.data_source.remote.RemotePostDataSource
import com.fengwei23.exercise0701.data_repository.data_source.remote.RemoteUserDataSource
import com.fengwei23.exercise0701.data_repository.repository.InteractionRepositoryImpl
import com.fengwei23.exercise0701.data_repository.repository.PostRepositoryImpl
import com.fengwei23.exercise0701.data_repository.repository.UserRepositoryImpl
import com.fengwei23.exercise0701.domain.repository.InteractionRepository
import com.fengwei23.exercise0701.domain.repository.PostRepository
import com.fengwei23.exercise0701.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providePostRepository(
        remotePostDataSource: RemotePostDataSource,
        localPostDataSource: LocalPostDataSource
    ): PostRepository = PostRepositoryImpl(
        remotePostDataSource,
        localPostDataSource
    )

    @Provides
    fun provideUserRepository(
        remoteUserDataSource: RemoteUserDataSource,
        localUserDataSource: LocalUserDataSource
    ): UserRepository = UserRepositoryImpl(
        remoteUserDataSource,
        localUserDataSource
    )

    @Provides
    fun provideInteractionRepository(
        interactionDataSource: LocalInteractionDataSource
    ): InteractionRepository = InteractionRepositoryImpl(
        interactionDataSource
    )
}