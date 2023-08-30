package com.herpestes.newsapp.di

import android.app.Application
import com.herpestes.newsapp.data.manager.LocalUserMangerImpl
import com.herpestes.newsapp.domain.manager.LocalUserManager
import com.herpestes.newsapp.domain.usercases.AppEntryUseCases
import com.herpestes.newsapp.domain.usercases.ReadAppEntry
import com.herpestes.newsapp.domain.usercases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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


}