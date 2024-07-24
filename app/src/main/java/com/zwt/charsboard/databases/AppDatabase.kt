package com.zwt.charsboard.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zwt.charsboard.data.local.TopEntity

@Database(entities = [TopEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun TopDAO(): TopCast
}