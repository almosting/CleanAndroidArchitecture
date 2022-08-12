package com.fengwei23.exercise0701.data_repository.repository

import com.fengwei23.exercise0701.data_repository.data_source.local.LocalInteractionDataSource
import com.fengwei23.exercise0701.domain.entity.Interaction
import com.fengwei23.exercise0701.domain.repository.InteractionRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InteractionRepositoryImpl @Inject constructor(
    private val interactionDataSource: LocalInteractionDataSource
) : InteractionRepository {

    override fun getInteraction(): Flow<Interaction> = interactionDataSource.getInteraction()

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun saveInteraction(interaction: Interaction): Flow<Interaction> = flow {
        interactionDataSource.saveInteraction(interaction)
        this.emit(Unit)
    }.flatMapLatest {
        getInteraction()
    }
}