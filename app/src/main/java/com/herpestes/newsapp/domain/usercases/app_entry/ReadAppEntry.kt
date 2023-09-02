package com.herpestes.newsapp.domain.usercases.app_entry

import com.herpestes.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManger: LocalUserManager
) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry() as Flow<Boolean>
    }

}