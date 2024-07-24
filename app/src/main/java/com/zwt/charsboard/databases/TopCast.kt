package com.zwt.charsboard.databases

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.zwt.charsboard.data.local.TopEntity

@Dao
interface TopCast {
    @Query("SELECT * FROM TopEntity")
    fun getAll(): List<TopEntity>

    @Insert
    fun insertAll(vararg topItems: TopEntity)
}