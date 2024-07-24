/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zwt.charsboard.repository

import com.zwt.charsboard.data.local.TopEntity
import com.zwt.charsboard.databases.TopCast
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Default implementation of [TopRepository]. Single entry point for managing tasks' data.
 *
 * @param networkDataSource - The network data source
 * @param localDataSource - The local data source
 * @param dispatcher - The dispatcher to be used for long running or complex operations, such as ID
 * generation or mapping many models.
 * @param scope - The coroutine scope used for deferred jobs where the result isn't important, such
 * as sending data to the network.
 */
@Singleton
class DefaultTopRepository @Inject constructor(
    private val localDataSource: TopCast
) : TopRepository {

    override suspend fun insert(title: String, intro: String, company:String) {
        val top = TopEntity(
            0,
            title = title,
            intro = intro,
            company = company
        )

        localDataSource.insertAll(top)
    }

    override suspend fun getAll(): List<TopEntity> {
        return localDataSource.getAll()
    }
}
