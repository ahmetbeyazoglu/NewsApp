package com.herpestes.newsapp.di

import android.app.Application
import com.google.gson.Gson
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
import com.herpestes.newsapp.util.Constants.BASE_URL
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
            getNews = GetNews(newsRepository)
        )
    }


}