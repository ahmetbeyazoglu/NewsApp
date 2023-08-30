package com.herpestes.newsapp.domain.usercases

import com.herpestes.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
// suspend operator fun invoke(): Flow<Boolean>
    suspend operator fun invoke() {
        return localUserManager.saveAppEntry()
    }

}