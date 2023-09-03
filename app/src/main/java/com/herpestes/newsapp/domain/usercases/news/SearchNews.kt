package com.herpestes.newsapp.domain.usercases.news

import androidx.paging.PagingData
import com.herpestes.newsapp.domain.model.Article
import com.herpestes.newsapp.domain.repository.NewsRepository
import com.herpestes.newsapp.presentation.search.SearchEvent
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(searchQuery: String,sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery = searchQuery, sources = sources)
    }
}