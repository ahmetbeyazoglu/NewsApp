package com.herpestes.newsapp.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.herpestes.newsapp.data.local.NewsDao
import com.herpestes.newsapp.data.local.NewsDatabase
import com.herpestes.newsapp.data.local.NewsTypeConvertor
import com.herpestes.newsapp.data.manager.LocalUserMangerImpl
import com.herpestes.newsapp.data.remote.NewsApi
import com.herpestes.newsapp.data.repository.NewsRepositoryImpl
import com.herpestes.newsapp.domain.manager.LocalUserManager
import com.herpestes.newsapp.domain.repository.NewsRepository
import com.herpestes.newsapp.domain.usercases.app_entry.AppEntryUseCases
import com.herpestes.newsapp.domain.usercases.app_entry.ReadAppEntry
import com.herpestes.newsapp.domain.usercases.app_entry.SaveAppEntry
import com.herpestes.newsapp.domain.usercases.news.GetNews
import com.herpestes.newsapp.domain.usercases.news.NewsUseCases
import com.herpestes.newsapp.domain.usercases.news.SearchNews
import com.herpestes.newsapp.util.Constants.BASE_URL
import com.herpestes.newsapp.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsAp(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }


    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase{
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao


}