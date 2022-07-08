package com.fengwei23.exercise0701.domain.repository

import com.fengwei23.exercise0701.domain.entity.Interaction
import kotlinx.coroutines.flow.Flow

interface InteractionRepository {
    fun getInteraction(): Flow<Interaction>

    fun saveInteraction(interaction: Interaction): Flow<Interaction>
}