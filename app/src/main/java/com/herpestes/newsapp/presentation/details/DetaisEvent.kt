package com.herpestes.newsapp.presentation.details

import com.herpestes.newsapp.domain.model.Article

sealed class DetaisEvent {

    data class UpsertDeleteArticle(val article: Article) : DetaisEvent()

    object RemoveSideEffect: DetaisEvent()


}