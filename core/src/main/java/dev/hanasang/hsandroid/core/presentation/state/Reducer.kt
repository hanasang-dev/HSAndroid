package dev.hanasang.hsandroid.core.presentation.state

import android.content.Intent

interface Reducer<I : Intent, S : UiState<*, *, *>> {
    fun reduce(currentState: S, intent: I): S
}
