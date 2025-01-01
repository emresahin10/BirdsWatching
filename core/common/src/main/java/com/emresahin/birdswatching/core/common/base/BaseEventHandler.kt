package com.emresahin.birdswatching.core.common.base

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BaseEventHandler<Event : UiEvent> {
    private val _events = Channel<Event>()
    val events: Flow<Event> = _events.receiveAsFlow()

    suspend fun sendEvent(event: Event) {
        _events.send(event)
    }
} 