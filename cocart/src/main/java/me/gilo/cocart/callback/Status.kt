package me.gilo.cocart.callback

enum class Status {
    EMPTY,
    SUCCESS,
    ERROR,
    LOADING;

    val isLoading: Status
        get() = LOADING
}
