package com.fengwei23.exercise0701.data_repository.data_source.local

import com.fengwei23.exercise0701.domain.entity.Interaction
import kotlinx.coroutines.flow.Flow

interface LocalInteractionDataSource {
    fun getInteraction(): Flow<Interaction>

    suspend fun saveInteraction(interaction: Interaction)
}