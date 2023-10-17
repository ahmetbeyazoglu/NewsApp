package com.herpestes.newsapp.data.local

import androidx.room.*
import com.herpestes.newsapp.domain.model.Article
import java.util.concurrent.Flow

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("SELECT * FROM Article")
    fun getArticles(): kotlinx.coroutines.flow.Flow<List<Article>>


}