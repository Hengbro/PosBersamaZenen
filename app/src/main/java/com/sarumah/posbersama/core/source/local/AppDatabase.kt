package com.sarumah.posbersama.core.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sarumah.posbersama.core.source.local.dao.CategoryDao
import com.sarumah.posbersama.core.source.local.dao.DiscountDao
import com.sarumah.posbersama.core.source.local.entity.CategoryEntity
import com.sarumah.posbersama.util.Constants

@Database(
    entities = [
        CategoryEntity::class,
    ], version = Constants.DB_VERSION, exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun dicountDao(): DiscountDao
}