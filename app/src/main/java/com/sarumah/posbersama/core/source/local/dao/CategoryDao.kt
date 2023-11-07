package com.sarumah.posbersama.core.source.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.REPLACE
import com.sarumah.posbersama.core.source.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert(onConflict = REPLACE)
    fun insert(data: CategoryEntity)

    @Insert(onConflict = REPLACE)
    fun insert(data: List<CategoryEntity>)

    @Delete
    fun delete(data: CategoryEntity)

    @Update
    fun update(data: CategoryEntity)

    @Query("SELECT * from CategoryEntity ORDER BY id ASC")
    fun getAll(): Flow<List<CategoryEntity>>

    @Query("DELETE FROM CategoryEntity")
    fun deleteAll()
}