package com.emresahin.birdswatching.core.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel<Event : UiEvent> : ViewModel() {
    private val eventHandler = object : BaseEventHandler<Event>() {}

    val events = eventHandler.events

    protected fun sendEvent(event: Event) {
        viewModelScope.launch {
            eventHandler.sendEvent(event)
        }
    }
} 