package com.herpestes.newsapp.presentation.search

sealed class SearchEvent {

    data class  UpdateSearchQuery(val searchQuery: String): SearchEvent()

    object SearhNews: SearchEvent()

}