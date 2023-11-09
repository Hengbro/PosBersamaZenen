package com.sarumah.posbersama.core.source.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.REPLACE
import com.sarumah.posbersama.core.source.local.entity.CategoryEntity
import com.sarumah.posbersama.core.source.local.entity.DiscountEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DiscountDao {

    @Insert(onConflict = REPLACE)
    fun insert(data: DiscountEntity)

    @Insert(onConflict = REPLACE)
    fun insert(data: List<DiscountEntity>)

    @Delete
    fun delete(data: DiscountEntity)

    @Update
    fun update(data: DiscountEntity)

    @Query("SELECT * from DiscountEntity ORDER BY id ASC")
    fun getAll(): Flow<List<DiscountEntity>>

    @Query("DELETE FROM DiscountEntity")
    fun deleteAll()
}