package com.fengwei23.exercise0701.injection

import com.fengwei23.exercise0701.remote.MockRemotePostDataSource
import com.fengwei23.exercise0701.remote.MockRemoteUserDataSource
import com.fengwei23.exercise0701.data_remote.injection.RemoteDataSourceModule
import com.fengwei23.exercise0701.data_repository.data_source.remote.RemotePostDataSource
import com.fengwei23.exercise0701.data_repository.data_source.remote.RemoteUserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RemoteDataSourceModule::class]
)
abstract class MockRemoteDataSourceModule {

    @Binds
    abstract fun bindPostDataSource(postDataSourceImpl: MockRemotePostDataSource): RemotePostDataSource

    @Binds
    abstract fun bindUserDataSource(userDataSourceImpl: MockRemoteUserDataSource): RemoteUserDataSource
}