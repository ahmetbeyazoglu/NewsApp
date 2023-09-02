package com.herpestes.newsapp.data.remote.dto

import com.herpestes.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)