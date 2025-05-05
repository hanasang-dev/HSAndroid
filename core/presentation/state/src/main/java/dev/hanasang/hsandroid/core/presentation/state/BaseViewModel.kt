package dev.hanasang.hsandroid.core.presentation.state

import android.content.Intent
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<I : Intent, S : UiState<*, *, *>>(
    private val reducer: Reducer<I, S>,
) : ViewModel() {

    private val _uiState = MutableStateFlow(initialState())
    val uiState: StateFlow<S> = _uiState.asStateFlow()

    protected abstract fun initialState(): S

    fun processIntent(intent: I) {
        val newState = reducer.reduce(_uiState.value, intent)
        _uiState.value = newState
    }
}
