package com.sarumah.posbersama.core.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sarumah.posbersama.core.source.model.CategoryJava
import com.sarumah.posbersama.core.source.model.ProductJava

@Database(entities = [CategoryJava::class, ProductJava::class], version = 2)
abstract class AppDatabaseOld : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabaseOld? = null

        fun getDatabase(context: Context): AppDatabaseOld {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabaseOld::class.java,
                    "AppDatabase"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }
    }
}
