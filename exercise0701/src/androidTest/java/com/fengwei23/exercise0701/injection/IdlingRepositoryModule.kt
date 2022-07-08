package com.fengwei23.exercise0701.injection


import com.fengwei23.exercise0701.repository.IdlingInteractionRepository
import com.fengwei23.exercise0701.repository.IdlingPostRepository
import com.fengwei23.exercise0701.repository.IdlingUserRepository
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
import com.fengwei23.exercise0701.idling.ComposeCountingIdlingResource
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepositoryModule::class]
)
class IdlingRepositoryModule {

    @Singleton
    @Provides
    fun provideIdlingResource(): ComposeCountingIdlingResource =
        ComposeCountingIdlingResource("repository-idling")

    @Provides
    fun providePostRepository(
        remotePostDataSource: RemotePostDataSource,
        localPostDataSource: LocalPostDataSource,
        countingIdlingResource: ComposeCountingIdlingResource
    ): PostRepository = IdlingPostRepository(
        PostRepositoryImpl(
            remotePostDataSource,
            localPostDataSource
        ),
        countingIdlingResource
    )

    @Provides
    fun provideUserRepository(
        remoteUserDataSource: RemoteUserDataSource,
        localUserDataSource: LocalUserDataSource,
        countingIdlingResource: ComposeCountingIdlingResource
    ): UserRepository = IdlingUserRepository(
        UserRepositoryImpl(
            remoteUserDataSource,
            localUserDataSource
        ),
        countingIdlingResource
    )

    @Provides
    fun provideInteractionRepository(
        interactionDataSource: LocalInteractionDataSource,
        countingIdlingResource: ComposeCountingIdlingResource
    ): InteractionRepository = IdlingInteractionRepository(
        InteractionRepositoryImpl(
            interactionDataSource
        ),
        countingIdlingResource
    )
}