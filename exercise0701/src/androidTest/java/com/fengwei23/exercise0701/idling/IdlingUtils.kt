package com.fengwei23.exercise0701.idling

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

fun <T> Flow<T>.attachIdling(
    countingIdlingResource: ComposeCountingIdlingResource
): Flow<T> {
    return onStart {
        countingIdlingResource.increment()
    }.onEach {
        countingIdlingResource.decrement()
    }
}