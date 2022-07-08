package com.fengwei23.exercise0601.domain.usecase

import com.fengwei23.exercise0601.domain.entity.Interaction
import com.fengwei23.exercise0601.domain.repository.InteractionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UpdateInteractionUseCase @Inject constructor(
    configuration: Configuration,
    private val interactionRepository: InteractionRepository
) : UseCase<UpdateInteractionUseCase.Request, UpdateInteractionUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> {
        return interactionRepository.saveInteraction(request.interaction)
            .map {
                Response
            }
    }

    data class Request(val interaction: Interaction) : UseCase.Request

    object Response : UseCase.Response
}