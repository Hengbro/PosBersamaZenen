package com.sarumah.posbersama.core.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sarumah.posbersama.core.data.source.modal.CategoryJava
import com.sarumah.posbersama.core.data.source.modal.ProductJava

@Database(entities = [CategoryJava::class, ProductJava::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun productDao(): ProductDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if(INSTANCE == null){
                INSTANCE =Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "AppDatabase")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }
    }
}
