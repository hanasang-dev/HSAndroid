package dev.hanasang.hsandroid.core.presentation.state

interface UiState<D, S, E> {
    val data: D
    val status: S
    val event: E?
}
