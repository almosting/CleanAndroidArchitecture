package com.fengwei23.exercise0701.repository

import com.fengwei23.exercise0701.domain.entity.Interaction
import com.fengwei23.exercise0701.domain.repository.InteractionRepository
import com.fengwei23.exercise0701.idling.ComposeCountingIdlingResource
import com.fengwei23.exercise0701.idling.attachIdling
import kotlinx.coroutines.flow.Flow

class IdlingInteractionRepository(
    private val interactionRepository: InteractionRepository,
    private val countingIdlingResource: ComposeCountingIdlingResource
) : InteractionRepository {

    override fun getInteraction(): Flow<Interaction> {
        return interactionRepository.getInteraction()
            .attachIdling(countingIdlingResource)
    }

    override fun saveInteraction(interaction: Interaction): Flow<Interaction> {
        return interactionRepository.saveInteraction(interaction)
            .attachIdling(countingIdlingResource)
    }
}