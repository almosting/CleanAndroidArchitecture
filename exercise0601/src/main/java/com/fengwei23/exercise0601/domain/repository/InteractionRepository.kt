package com.fengwei23.exercise0601.domain.repository

import com.fengwei23.exercise0601.domain.entity.Interaction
import kotlinx.coroutines.flow.Flow

interface InteractionRepository {
    fun getInteraction(): Flow<Interaction>

    fun saveInteraction(interaction: Interaction): Flow<Interaction>
}