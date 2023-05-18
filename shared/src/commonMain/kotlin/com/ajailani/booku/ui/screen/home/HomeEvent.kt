package com.ajailani.booku.ui.screen.home

sealed class HomeEvent {
    data class OnSearchQueryChanged(val searchQuery: String) : HomeEvent()
}