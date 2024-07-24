package com.zwt.charsboard.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TopEntity(
    @PrimaryKey(autoGenerate = true) val topId: Int,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "intro") val intro: String?,
    @ColumnInfo(name = "company") val company: String?
)