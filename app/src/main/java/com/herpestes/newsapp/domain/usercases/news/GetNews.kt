package com.herpestes.newsapp.domain.usercases.news

import androidx.paging.PagingData
import com.herpestes.newsapp.domain.model.Article
import com.herpestes.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>>{
        return newsRepository.getNews(sources = sources)
    }

}